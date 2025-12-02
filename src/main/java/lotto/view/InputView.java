package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";

    public static String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST);
        return Console.readLine();
    }
}
