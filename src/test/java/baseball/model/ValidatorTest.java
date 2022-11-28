package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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
    @MethodSource("provideParametersForRange")
    @DisplayName("입력 숫자 범위를 벗어나면 예외를 발생시킨다.")
    void throwExceptionForInvalidRange(List<Integer> numbers) {
        assertThatThrownBy(() -> Validator.validateRange(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
    private static Stream<Arguments> provideParametersForRange() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 0)),
                Arguments.of(List.of(10, 2, 3)),
                Arguments.of(List.of(-1, 2, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForDuplicate")
    @DisplayName("중복되는 숫자가 존재하면 예외를 발생시킨다.")
    void throwExceptionForDuplicate(List<Integer> numbers) {
        assertThatThrownBy(() -> Validator.validateDuplicate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
    private static Stream<Arguments> provideParametersForDuplicate() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 1)),
                Arguments.of(List.of(10, 3, 3)),
                Arguments.of(List.of(1, 1, 1))
        );
    }
}
