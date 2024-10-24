package common;

import java.util.Iterator;
import java.util.Set;

// 사용자 입력값과 정답값을 비교하여 점수를 계산 및 관리하는 클래스
public class ScoreManager {
    private final Set<Integer> inputNumber;
    private final Set<Integer> correctNumber;
    private final Score score = new Score();

    /**
     * 생성자가 호출되면 매개변수 값을 받아 {@code makeScore()}로 점수를 계산
     *
     * @param inputNumber   : 사용자가 입력한 정답값
     * @param correctNumber : 정답값
     */
    public ScoreManager(Set<Integer> inputNumber, Set<Integer> correctNumber) {
        this.inputNumber = inputNumber;
        this.correctNumber = correctNumber;
        makeScore();
    }

    // ball, strike 점수를 각각 저장하기 위한 이너 클래스
    private static class Score {
        int ballCount;
        int strikeCount;
    }

    /**
     * 입력값, 정답값 두 Set 을 돌며 점수 계산
     */
    private void makeScore() {
        Iterator<Integer> inputNumberIt = inputNumber.iterator();
        Iterator<Integer> correctNumIt = correctNumber.iterator();

        while (inputNumberIt.hasNext()) {
            int nextInputNum = inputNumberIt.next();
            int nextCorrectNum = correctNumIt.next();
            if (nextInputNum == nextCorrectNum) {
                score.strikeCount++;
            } else if (correctNumber.contains(nextInputNum)) {
                score.ballCount++;
            }
        }
    }

    /**
     * @return : ball 점수를 반환
     */
    public int getBallCount() {
        return score.ballCount;
    }

    /**
     * @return : strike 점수를 반환
     */
    public int getStrikeCount() {
        return score.strikeCount;
    }
}
