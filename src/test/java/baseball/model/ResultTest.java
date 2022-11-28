package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultTest {
    @ParameterizedTest
    @CsvSource({
            "3, 0, 3볼",
            "0, 2, 2스트라이크",
            "2, 1, 2볼 1스트라이크",
            "0, 0, 낫싱"
    })
    @DisplayName("결과에 따라 출력 문자열을 생성한다.")
    void throwExceptionForNonNumeric(int balls, int strikes, String result) {
        assertThat(new Result(balls, strikes).toString()).isEqualTo(result);
    }
}
