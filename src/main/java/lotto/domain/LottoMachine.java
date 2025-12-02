package lotto.domain;

import java.util.List;
import lotto.generator.RandomLottoGenerator;

public class LottoMachine {

    private LottoMachine() {
    }

    public static LottoMachine newInstance() {
        return new LottoMachine();
    }

    public IssuedLotto issueLotto(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.getLottoCount();
        IssuedLotto issuedLotto = IssuedLotto.newInstance();
        for (int count = 0; count < lottoCount; count++) {
            List<Integer> numbers = RandomLottoGenerator.generateLotto();
            issuedLotto.add(numbers);
        }
        return issuedLotto;
    }
}
