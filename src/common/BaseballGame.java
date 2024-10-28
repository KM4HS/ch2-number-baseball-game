package common;

import input.WrongInputException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 숫자 야구 게임 한 사이클의 진행을 담당
public class BaseballGame {
    private final List<Character> availableChars = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    private final String correctNumber;
    private final int numberSize;

    private boolean isGameEnded;
    private int tryCount = 0;

    /**
     * 생성자가 호출될 때 크기에 맞는 불변 랜덤 숫자 Set 생성
     *
     * @param numberSize : 지정 자리수
     */
    public BaseballGame(int numberSize) {
        this.numberSize = numberSize;
        correctNumber = generateRandomNumber();
    }

    /**
     * 게임을 순차적으로 진행시키는 메서드. 사용자의 input 값 받음.
     * 1. 입력값을 숫자 Set으로 파싱
     * 2. 파싱한 값을 정답값과 비교하여 점수 책정
     * 3. 점수 출력
     *
     * @param input : 사용자의 입력값
     */
    public void startGame(String input) {
        tryCount++;
        ScoreManager scoreManager = new ScoreManager(input, correctNumber);
        printScore(scoreManager.getStrikeCount(), scoreManager.getBallCount());
        checkIsGameEnded(scoreManager.getStrikeCount());
    }

    /**
     * 게임이 끝났는가 여부를 알림
     *
     * @return : {@code isGameEnded}가 true 일 때 게임 종료
     */
    public boolean getIsGameEnded() {
        return !isGameEnded;
    }

    /**
     * 게임 종료 여부를 판단
     *
     * @param strikeCount : strike 점수
     */
    private void checkIsGameEnded(int strikeCount) {
        isGameEnded = (strikeCount == this.numberSize);
    }

    /**
     * 점수를 출력함
     *
     * @param strikeCount : strike 점수
     * @param ballCount   : ball 점수
     */
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
    }

    /**
     * 정답을 맞추기까지의 시도 횟수를 반환함 (입력 예외인 경우도 포함)
     *
     * @return : 시도 횟수
     */
    public int getTryCount() {
        return tryCount;
    }

    private String generateRandomNumber() {
        List<Character> target = new ArrayList<>(availableChars);
        Collections.shuffle(target);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberSize; i++) {
            sb.append(target.get(i));
        }
        return sb.toString();
    }
}
