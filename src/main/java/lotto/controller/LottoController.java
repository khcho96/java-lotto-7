package lotto.controller;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        LottoDto lottoDto = issueLotto(); // DTO 반환 메서드 호출
        OutputView.printLotto(lottoDto); // DTO 출력

        registerWinningNumber(); // 내부 작업만 수행하는 메서드 호출
        registerBonusNumber();

        /*LottoResultDto lottoResultDto = getLottoResult(); // 결과 반환 메서드 호출
        OutputView.printLottoResult(lottoResultDto); // 결과 출력*/
    }

    private LottoDto issueLotto() {
        while (true) {
            try {
                String rawPurchaseAmount = InputView.readPurchaseAmount();
                Integer purchaseAmount = InputParser.parseToInteger(rawPurchaseAmount);

                return lottoService.issueLotto(purchaseAmount);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void registerWinningNumber() {
        while (true) {
            try {
                String rawWinningNumber = InputView.readWinningNumber();
                List<Integer> winningNumber = InputParser.parseToElements(rawWinningNumber);
                lottoService.registerWinningNumber(winningNumber);

                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void registerBonusNumber() {

    }

    private LottoResultDto getLottoResult() {
        while (true) {
            try {

            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
