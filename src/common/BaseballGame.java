package common;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseballGame {
    private Set<Integer> correctNum = new LinkedHashSet<>();
    private static boolean isGameEnded = false;
    private final int numberSize;
    private int attemptTime = 0;

    public BaseballGame(int numberSize) {
        this.numberSize = numberSize;
        while (correctNum.size() < this.numberSize) {
            correctNum.add((int) Math.floor(Math.random() * 9 + 1));
        }
        correctNum = Collections.unmodifiableSet(correctNum);

        // 정답 테스트 코드
        System.out.println("테스트용 정답 출력 : ");
        for(int i: correctNum){
            System.out.print(i);
        }
        System.out.println(" ");
    }

    public void startGame(String input) throws WrongInputException {
        attemptTime++;
        Parser parser = new Parser(input, numberSize);
        ScoreManager scoreManager = new ScoreManager(parser.parseIntSet(), correctNum);
        printScore(scoreManager.getStrikeCount(), scoreManager.getBallCount());
    }

    public boolean getIsGameEnded() {
        return !isGameEnded;
    }

    public void printScore(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("아웃");
        }
        if (strikeCount != 0) {
            System.out.print("스트라이크" + strikeCount + " ");
        }
        if (ballCount != 0) {
            System.out.print("볼" + ballCount);
        }
        System.out.println(" ");
        isGameEnded = (strikeCount == this.numberSize);
    }
    public int getAttemptTime(){
        return attemptTime;
    }
}
