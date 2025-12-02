package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String ISSUED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public static void printLotto(LottoDto lottoDto) {
        List<List<Integer>> lottoNumbers = lottoDto.getLottoNumbers();

        System.out.printf(NEW_LINE + ISSUED_LOTTO_COUNT_MESSAGE + NEW_LINE, lottoNumbers.size());
        for (List<Integer> lottoNumber : lottoNumbers) {
            lottoNumber.sort(null);
            System.out.println(lottoNumber);
        }
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
        // TODO: DTO 에서 값 가져오기
        // TODO: 결과 출력
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
