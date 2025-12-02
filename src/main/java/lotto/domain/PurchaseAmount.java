package lotto.domain;

import static lotto.constant.Constant.PURCHASE_AMOUNT_MAX;
import static lotto.constant.Constant.PURCHASE_AMOUNT_UNIT;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;

public class PurchaseAmount {

    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validateAll(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validateAll(int purchaseAmount) {
        validateUnit(purchaseAmount);
        validateRange(purchaseAmount);
    }

    private void validateUnit(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR.getErrorMessage());
        }
    }

    private void validateRange(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount > PURCHASE_AMOUNT_MAX) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_RANGE_ERROR.getErrorMessage());
        }
    }

    public int getLottoCount() {
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
