package baseball.model;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RefereeTest {
    @ParameterizedTest
    @MethodSource("provideParametersForIntersect")
    @DisplayName("두 리스트의 공통 요소 개수를 구한다.")
    void countIntersects(List<Integer> list1, List<Integer> list2, int numberOfIntersects) {
        assertThat(new Referee().countIntersects(list1, list2)).isEqualTo(numberOfIntersects);
    }

    private static Stream<Arguments> provideParametersForIntersect() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 4), 2),
                Arguments.of(List.of(1, 2, 3), List.of(1, 4, 6), 1),
                Arguments.of(List.of(1, 2, 3), List.of(7, 6, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForStrikes")
    @DisplayName("두 리스트의 스트라이크 개수를 구한다.")
    void countStrikes(List<Integer> list1, List<Integer> list2, int strikes) {
        assertThat(new Referee().countStrikes(list1, list2)).isEqualTo(strikes);
    }

    private static Stream<Arguments> provideParametersForStrikes() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 4), 2),
                Arguments.of(List.of(1, 2, 3), List.of(1, 4, 6), 1),
                Arguments.of(List.of(1, 2, 3), List.of(7, 6, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForBalls")
    @DisplayName("두 리스트의 볼 개수를 구한다.")
    void countBalls(List<Integer> list1, List<Integer> list2, int Balls) {
        assertThat(new Referee().countBalls(list1, list2)).isEqualTo(Balls);
    }

    private static Stream<Arguments> provideParametersForBalls() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 0),
                Arguments.of(List.of(1, 4, 3), List.of(1, 2, 4), 1),
                Arguments.of(List.of(4, 6, 3), List.of(1, 4, 6), 2),
                Arguments.of(List.of(5, 7, 6), List.of(7, 6, 5), 3)
        );
    }
}
