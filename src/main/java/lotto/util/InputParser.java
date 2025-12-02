package lotto.util;

import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {}

    public static Integer parseToInteger(String rawXxx) {
        Validator.validateNullOrBlank(rawXxx);
        rawXxx = rawXxx.strip();

        return NumberConvertor.convertToNumber(rawXxx);
    }

    public static List<Integer> parseToElements(String rawXxx) {
        Validator.validateNullOrBlank(rawXxx);
        rawXxx = rawXxx.strip();

        Validator.validateCsvFormat(rawXxx);

        return Stream.of(rawXxx.split(DELIMITER))
                .map(String::strip)
                .map(NumberConvertor::convertToNumber)
                .toList();
    }
}
