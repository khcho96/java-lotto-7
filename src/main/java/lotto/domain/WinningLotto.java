package lotto.domain;

import static lotto.constant.Constant.LOTTO_NUMBER_MAX;
import static lotto.constant.Constant.LOTTO_NUMBER_MIN;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_UNIQUE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;

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

    public void registerBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        validateUnique(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    private void validateUnique(int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_UNIQUE_ERROR.getErrorMessage());
        }
    }

    public Rank judgeRank(Lotto lotto) {
        int matchedCount = winningNumber.calculateMatchedCount(lotto);
        boolean isMatchedBonusNumber = lotto.contains(bonusNumber);

        return Rank.of(matchedCount, isMatchedBonusNumber);
    }
}
