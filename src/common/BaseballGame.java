package common;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseballGame {
    private static Set<Integer> correctNum = new LinkedHashSet<>();
    private static boolean isGameEnded = false;
    private final int numberSize;

    public BaseballGame(int numberSize) {
        this.numberSize = numberSize;
        while (correctNum.size() < this.numberSize) {
            correctNum.add((int) Math.floor(Math.random() * 9 + 1));
        }
        correctNum = Collections.unmodifiableSet(correctNum);
    }

    public void startGame(String input) throws WrongInputException {
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
}
