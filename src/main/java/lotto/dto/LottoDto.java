package lotto.dto;

import java.util.List;

public class LottoDto {

    private final List<List<Integer>> lottoNumbers;

    private LottoDto(List<List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoDto from(List<List<Integer>> lottoNumbers) {
        return new LottoDto(lottoNumbers);
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
