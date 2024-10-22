import java.util.Iterator;
import java.util.Set;

public class ScoreManager {
    private final Set<Integer> inputNumber;
    private final Set<Integer> correctNumber;
    private final Score score = new Score();

    ScoreManager(Set<Integer> inputNumber, Set<Integer> correctNumber) {
        this.inputNumber = inputNumber;
        this.correctNumber = correctNumber;
        makeScore();
    }

    static class Score {
        int ballCount;
        int strikeCount;
    }

    private void makeScore() {
        Iterator<Integer> inputNumberIt = inputNumber.iterator();
        Iterator<Integer> correctNumIt = correctNumber.iterator();

//        // 테스트 코드
//        System.out.print("정답 : ");
//        for (int i : correctNumber) {
//            System.out.print(i);
//        }
//        System.out.println(" ");

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

    public int getBallCount() {
        return score.ballCount;
    }

    public int getStrikeCount() {
        return score.strikeCount;
    }
}
