package lotto.dto;

import java.util.EnumMap;
import lotto.domain.Rank;

public class LottoResultDto {

    private final EnumMap<Rank, Integer> result;
    private final double profitRate;

    private LottoResultDto(EnumMap<Rank, Integer> result, double profitRate) {
        this.result = new EnumMap<>(result);
        this.profitRate = profitRate;
    }

    public static LottoResultDto of(EnumMap<Rank, Integer> result, double profitRate) {
        return new LottoResultDto(result, profitRate);
    }

    public EnumMap<Rank, Integer> getResult() {
        return result;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
