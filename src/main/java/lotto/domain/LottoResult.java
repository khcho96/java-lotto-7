package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import lotto.dto.LottoResultDto;

public class LottoResult {

    // 결과 저장하는 자료구조
    private final EnumMap<Rank, Integer> result;
    private double profitRate;

    private LottoResult() {
        // (필요하다면) 자료구조 세팅
        result = new EnumMap<>(Rank.class);
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
    }

    public static LottoResult newInstance() {
        return new LottoResult();
    }

    public LottoResultDto getResult(PurchaseAmount purchaseAmount, IssuedLotto issuedLotto, WinningLotto winningLotto) {
        decideLottoRank(issuedLotto, winningLotto);
        calculateProfitRate(purchaseAmount);

        return LottoResultDto.of(result, profitRate);
    }

    private void decideLottoRank(IssuedLotto issuedLotto, WinningLotto winningLotto) {
        List<Lotto> lottos = issuedLotto.getLottos();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.judgeRank(lotto);
            if (rank != Rank.NONE) {
                result.put(rank, result.get(rank) + 1);
            }
        }
    }

    private void calculateProfitRate(PurchaseAmount purchaseAmount) {
        long sum = 0;
        for (Rank rank : result.keySet()) {
            Integer count = result.get(rank);
            Long prize = rank.getPrize();
            sum += prize * count;
        }
        profitRate = (double) sum / purchaseAmount.getPurchaseAmount() * 100.0;
    }
}
