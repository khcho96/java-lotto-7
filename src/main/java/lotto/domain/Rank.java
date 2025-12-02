package lotto.domain;

public enum Rank {

    FIRST(2_000_000_000L, "6개 일치 (2,000,000,000원) - %개"),
    SECOND(30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - %개"),
    THIRD( 1_500_000L, "5개 일치 (1,500,000원) - %개"),
    FOURTH( 50_000L, "4개 일치 (50,000원) - %개"),
    FIFTH(5_000L, "3개 일치 (5,000원) - %개"),
    NONE(null, null);

    private final Long prize;
    private final String printMessage;

    Rank(Long prize, String printMessage) {
        this.prize = prize;
        this.printMessage = printMessage;
    }

    public static Rank of(int matchedCount, boolean isMatchedBonusNumber) {
        if (matchedCount == 6) return FIRST;
        if (matchedCount == 5 && isMatchedBonusNumber) return SECOND;
        if (matchedCount == 5) return THIRD;
        if (matchedCount == 4) return FOURTH;
        if (matchedCount == 3) return FIFTH;
        return NONE;
    }

    public Long getPrize() {
        return prize;
    }

    public String getPrintMessage() {
        return printMessage;
    }
}
