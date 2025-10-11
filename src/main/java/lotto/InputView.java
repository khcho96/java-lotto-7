package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }
}
