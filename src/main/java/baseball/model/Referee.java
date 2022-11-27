package baseball.model;

import java.util.HashSet;
import java.util.List;

public class Referee {
    //두 숫자 비교, 스트라이크 볼 개수 반환
    public Result compare(List<Integer> computerBaseball, List<Integer> playerBaseball) {
        return new Result(
                countBalls(computerBaseball, playerBaseball),
                countStrikes(computerBaseball, playerBaseball)
        );
    }

    public int countStrikes(List<Integer> computerBaseball, List<Integer> playerBaseball) {
        int strikes = 0;
        for (int index = 0; index < BaseballStatistic.SIZE.getValue(); index++) {
            if (computerBaseball.get(index).equals(playerBaseball.get(index))) {
                strikes++;
            }
        }
        return strikes;
    }

    public int countBalls(List<Integer> computerBaseball, List<Integer> playerBaseball) {
        int strikes = countStrikes(computerBaseball, playerBaseball);
        int intersects = countIntersects(computerBaseball, playerBaseball);
        return intersects - strikes;
    }

    public int countIntersects(List<Integer> computerBaseball, List<Integer> playerBaseball) {
        HashSet<Integer> intersect = new HashSet<>(computerBaseball);
        intersect.retainAll(playerBaseball);
        return intersect.size();
    }
}
