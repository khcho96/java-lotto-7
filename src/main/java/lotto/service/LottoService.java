package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmount;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

public class LottoService {

    // TODO: 도메인 객체 인스턴스 변수로 저장
    private PurchaseAmount purchaseAmount;
    private LottoMachine lottoMachine;
    private IssuedLotto issuedLotto;

    // DTO 반환 메서드
    public LottoDto issueLotto(Integer purchaseAmount) {
        this.purchaseAmount = PurchaseAmount.from(purchaseAmount);
        lottoMachine = LottoMachine.newInstance();
        issuedLotto = lottoMachine.issueLotto(this.purchaseAmount);
        return issuedLotto.getDto();
    }

    // 내부 작업만 하는 메서드
    /*public void method2(입력값 매개변수) {
        // TODO: 정적 팩토리 메서드 호출로 도메인 객체 생성
    }

    // 촤종 결과 생성 메서드
    public LottoResultDto getXxxResult() {
        LottoResult lottoResult = LottoResult.newInstance();

        return LottoResult.getLottoResult(필요한 매개변수);
    }*/
}
