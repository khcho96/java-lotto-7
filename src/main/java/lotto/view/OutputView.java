package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Rank;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String ISSUED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계" + NEW_LINE + "---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    public static void printLotto(LottoDto lottoDto) {
        List<List<Integer>> lottoNumbers = lottoDto.getLottoNumbers();

        System.out.printf(NEW_LINE + ISSUED_LOTTO_COUNT_MESSAGE + NEW_LINE, lottoNumbers.size());
        for (List<Integer> lottoNumber : lottoNumbers) {
            lottoNumber.sort(null);
            System.out.println(lottoNumber);
        }
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
        EnumMap<Rank, Integer> result = lottoResultDto.getResult();
        double profitRate = lottoResultDto.getProfitRate();

        System.out.println(NEW_LINE + LOTTO_RESULT_MESSAGE);
        for (Rank rank : result.keySet()) {
            System.out.printf(rank.getPrintMessage() + NEW_LINE, result.get(rank));
        }

        System.out.println(String.format(PROFIT_RATE_MESSAGE, profitRate));
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
