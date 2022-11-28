package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "abc",
            "12vv",
            "+42"
    })
    @DisplayName("입력이 숫자 이외의 문자를 포함하면 예외를 발생시킨다.")
    void throwExceptionForNonNumeric(String input) {
        assertThatThrownBy(() -> Validator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "1234",
            "1",
            "12"
    })
    @DisplayName("입력 길이가 틀리면 예외를 발생시킨다.")
    void throwExceptionForInvalidSize(String input) {
        assertThatThrownBy(() -> Validator.validateSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "012",
            "230"
    })
    @DisplayName("입력 숫자 범위를 벗어나면 예외를 발생시킨다.")
    void throwExceptionForInvalidRange(String input) {
        assertThatThrownBy(() -> Validator.validateRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
