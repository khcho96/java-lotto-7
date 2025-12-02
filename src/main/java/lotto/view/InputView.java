package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";

    public static String readPurchaseAmount() {
        System.out.println(NEW_LINE + PURCHASE_AMOUNT_REQUEST);
        return Console.readLine();
    }

    public static String readWinningNumber() {
        System.out.println(NEW_LINE + WINNING_NUMBER_REQUEST);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(NEW_LINE + BONUS_NUMBER_REQUEST);
        return Console.readLine();
    }
}
