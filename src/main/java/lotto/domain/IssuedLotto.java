package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoDto;

public class IssuedLotto {

    private List<Lotto> lottos;

    private IssuedLotto() {
        lottos = new ArrayList<>();
    }

    public static IssuedLotto newInstance() {
        return new IssuedLotto();
    }

    public void add(List<Integer> numbers) {
        Lotto lotto = Lotto.from(numbers);
        lottos.add(lotto);
    }

    public LottoDto getDto() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return LottoDto.from(lottoNumbers);
    }
}
