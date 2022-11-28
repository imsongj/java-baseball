package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballGameTest {
    @ParameterizedTest
    @MethodSource("provideParametersForPlayerNumbers")
    @DisplayName("입력 문자열을 숫자 리스트로 변환한다.")
    void countIntersects(String input, List<Integer> numbers) {
        assertThat(new BaseballGame().createPlayerNumbers(input)).isEqualTo(numbers);
    }

    private static Stream<Arguments> provideParametersForPlayerNumbers() {
        return Stream.of(
                Arguments.of("123", List.of(1, 2, 3)),
                Arguments.of("123987", List.of(1, 2, 3, 9, 8, 7))
        );
    }
}
