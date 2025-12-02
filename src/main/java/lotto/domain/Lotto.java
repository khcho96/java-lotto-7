package lotto.domain;

import static lotto.constant.Constant.LOTTO_NUMBER_COUNT;
import static lotto.constant.Constant.LOTTO_NUMBER_MAX;
import static lotto.constant.Constant.LOTTO_NUMBER_MIN;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_UNIQUE_ERROR;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateAll(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validateAll(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateUnique(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (isNotValidRange(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    private static boolean isNotValidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX);
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_UNIQUE_ERROR.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int calculateMatchedCount(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        numbers.retainAll(lotto.numbers);
        return numbers.size();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
