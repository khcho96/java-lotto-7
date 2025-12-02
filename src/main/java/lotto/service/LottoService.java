package lotto.service;

import java.util.List;
import lotto.domain.IssuedLotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

public class LottoService {

    // TODO: 도메인 객체 인스턴스 변수로 저장
    private PurchaseAmount purchaseAmount;
    private IssuedLotto issuedLotto;
    private WinningLotto winningLotto;

    // DTO 반환 메서드
    public LottoDto issueLotto(Integer purchaseAmount) {
        this.purchaseAmount = PurchaseAmount.from(purchaseAmount);
        LottoMachine lottoMachine = LottoMachine.newInstance();
        issuedLotto = lottoMachine.issueLotto(this.purchaseAmount);
        return issuedLotto.getDto();
    }

    public void registerWinningNumber(List<Integer> winningNumber) {
        winningLotto = WinningLotto.newInstance();
        winningLotto.registerWinningNumber(winningNumber);
    }

    public void registerBonusNumber(int bonusNumber) {
        winningLotto.registerBonusNumber(bonusNumber);
    }

    public LottoResultDto calculateLottoResult() {
        LottoResult lottoResult = LottoResult.newInstance();
        return lottoResult.getResult(purchaseAmount, issuedLotto, winningLotto);
    }
}
