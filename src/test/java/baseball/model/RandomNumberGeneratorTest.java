package baseball.model;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RandomNumberGeneratorTest {
    @ParameterizedTest
    @CsvSource({
            "0",
            "3",
            "5"
    })
    @DisplayName("사이즈에 맞는 랜덤한 숫자 리스트를 반환한다.")
    void generateNumberListWithCorrectSize(int size) {
        List<Integer> numbers = new RandomNumberGenerator().generateRandomNumbers(size, 0, size);
        assertThat(numbers.size()).isEqualTo(size);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 9",
            "1, 45"
    })
    @DisplayName("범위에 맞는 랜덤한 숫자 리스트를 반환한다.")
    void generateNumberListWithCorrectRange(int lowerBound, int upperBound) {
        List<Integer> numbers = new RandomNumberGenerator().generateRandomNumbers(1, lowerBound, upperBound);
        assertThat(numbers.get(0)).isGreaterThanOrEqualTo(lowerBound).isLessThanOrEqualTo(upperBound);
    }
}
