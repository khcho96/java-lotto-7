package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_UNIQUE_ERROR;
import static lotto.constant.ErrorMessage.CSV_FORMAT_ERROR;
import static lotto.constant.ErrorMessage.INPUT_NULL_OR_BLANK_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_UNIQUE_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 당첨_1등_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 200,000,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 당첨_2등_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 3,000,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @Test
    void 당첨_3등_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 8]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 150,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 8)
        );
    }

    @Test
    void 당첨_4등_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 8, 9]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 5,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 8, 9)
        );
    }

    @Test
    void 당첨_5등_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 8, 9, 10]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 8, 9, 10)
        );
    }

    @Test
    void 당첨_여러개_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 8, 9, 10]",
                            "[1, 2, 3, 4, 8, 9]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 7, 8, 9, 10]",
                            "[1, 2, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 601,100.0%입니다."
                    );
                },
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 7, 8, 9, 10),
                List.of(1, 2, 8, 9, 10, 11)
        );
    }

    @Test
    void 낙첨_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(1, 2, 8, 9, 10, 11)
        );
    }

    @Test
    void 구입금액_입력값이_공백이면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
        });
    }

    @Test
    void 구입금액_입력값이_숫자가_아니면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(NUMBER_FORMAT_ERROR.getErrorMessage());
        });
    }

    @Test
    void 구입금액_입력값이_1000원_단위가_아니면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(PURCHASE_AMOUNT_UNIT_ERROR.getErrorMessage());
        });
    }

    @Test
    void 구입금액_입력값이_10만원_초과이면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException("110000");
            assertThat(output()).contains(PURCHASE_AMOUNT_RANGE_ERROR.getErrorMessage());
        });
    }

    @Test
    void 당첨번호_입력값이_공백이면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException("1000", " ");
            assertThat(output()).contains(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,a,b", "1 2 3 4 5 6"})
    void 당첨번호_입력값이_알맞은_형식이_아니면_예외를_발생시킨다(String input) {
        assertSimpleTest(() -> {
            runException("1000", input);
            assertThat(output()).contains(CSV_FORMAT_ERROR.getErrorMessage());
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 당첨번호_입력값이_알맞은_로또번호_개수가_아니면_예외를_발생시킨다(String input) {
        assertSimpleTest(() -> {
            runException("1000", input);
            assertThat(output()).contains(LOTTO_NUMBER_COUNT_ERROR.getErrorMessage());
        });
    }

    @Test
    void 당첨번호_입력값이_알맞은_로또번호_범위가_아니면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46");
            assertThat(output()).contains(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        });
    }

    @Test
    void 당첨번호_입력값이_중복이면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(LOTTO_NUMBER_UNIQUE_ERROR.getErrorMessage());
        });
    }

    @Test
    void 보너스번호_입력값이_공백이면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", " ");
            assertThat(output()).contains(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
        });
    }

    @Test
    void 보너스번호_입력값이_숫자가_아니면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(NUMBER_FORMAT_ERROR.getErrorMessage());
        });
    }

    @Test
    void 보너스번호_입력값이_로또번호_범위가_아니면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        });
    }

    @Test
    void 보너스번호_입력값이_당첨번호와_중복이면_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(BONUS_NUMBER_UNIQUE_ERROR.getErrorMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
