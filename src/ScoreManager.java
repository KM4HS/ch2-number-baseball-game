import java.util.Iterator;
import java.util.Set;

public class ScoreManager extends BaseballGame {
    private final Set<Integer> inputNumber;
    private final Score score = new Score();

    ScoreManager(Set<Integer> inputNumber) {
        this.inputNumber = inputNumber;
    }

    private static class Score {
        int ballCount;
        int strikeCount;
    }

    private void makeScore() {
        Iterator<Integer> inputNumberIt = inputNumber.iterator();
        Iterator<Integer> correctNumIt = correctNum.iterator();

        // 테스트 코드
        for (int i : correctNum) {
            System.out.print("정답: " + i);
        }
        System.out.println(" ");

        while (inputNumberIt.hasNext()) {
            int nextInputNum = inputNumberIt.next();
            int nextCorrectNum = correctNumIt.next();
            if (nextInputNum == nextCorrectNum) {
                score.strikeCount++;
            } else if (correctNum.contains(nextInputNum)) {
                score.ballCount++;
            }
        }
    }

    public void printScore() {
        makeScore();
        if (score.strikeCount == 0 && score.ballCount == 0) {
            System.out.print("아웃");
        }
        if (score.strikeCount != 0) {
            System.out.print("스트라이크" + score.strikeCount + " ");
        }
        if (score.ballCount != 0) {
            System.out.print("볼" + score.ballCount);
        }
        System.out.println(" ");
        Utils.isGameEnded = (score.strikeCount == inputNumber.size());
    }
}
