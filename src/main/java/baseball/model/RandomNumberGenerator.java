package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> generateRandomNumbers(int size, int lowerBound, int upperBound) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(lowerBound, upperBound);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
