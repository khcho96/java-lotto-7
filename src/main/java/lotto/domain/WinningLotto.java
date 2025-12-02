package lotto.domain;

import java.util.List;

public class WinningLotto {

    private Lotto winningNumber;
    private int bonusNumber;

    private WinningLotto() {
    }

    public static WinningLotto newInstance() {
        return new WinningLotto();
    }

    public void registerWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = Lotto.from(winningNumber);
    }
}
