package common;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

// 숫자 야구 게임 한 사이클의 진행을 담당
public class BaseballGame {
    private Set<Integer> correctNum = new LinkedHashSet<>();
    private boolean isGameEnded;
    private final int numberSize;
    private int attemptTime = 0;

    /**
     * 생성자가 호출될 때 크기에 맞는 불변 랜덤 숫자 Set 생성
     *
     * @param numberSize : 지정 자리수
     */
    public BaseballGame(int numberSize) {
        this.numberSize = numberSize;
        while (correctNum.size() < this.numberSize) {
            correctNum.add((int) Math.floor(Math.random() * 9 + 1));
        }
        correctNum = Collections.unmodifiableSet(correctNum);

/*        // 정답 테스트 코드
        System.out.print("테스트용 정답 출력 : ");
        for (int i : correctNum) {
            System.out.print(i);
        }
        System.out.println(" ");*/
    }

    /**
     * 게임을 순차적으로 진행시키는 메서드. 사용자의 input 값 받음.
     * 1. 입력값을 숫자 Set으로 파싱
     * 2. 파싱한 값을 정답값과 비교하여 점수 책정
     * 3. 점수 출력
     *
     * @param input : 사용자의 입력값
     * @throws WrongInputException : 입력값 예외 발생시
     */
    public void startGame(String input) throws WrongInputException {
        int strikeCount = -1;
        attemptTime++;
        Parser parser = new Parser(input, numberSize);
        try {
            ScoreManager scoreManager = new ScoreManager(parser.parseIntSet(), correctNum);
            strikeCount = scoreManager.getStrikeCount();
            printScore(strikeCount, scoreManager.getBallCount());
        } finally {
            setIsGameEnded(strikeCount);
        }
    }

    /**
     * 게임이 끝났는가 여부를 알림
     *
     * @return : {@code isGameEnded}가 true일 때 게임 종료
     */
    public boolean getIsGameEnded() {
        return !isGameEnded;
    }

    /**
     * 게임 종료 여부를 판단
     *
     * @param strikeCount : strike 점수
     */
    private void setIsGameEnded(int strikeCount) {
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
    public int getAttemptTime() {
        return attemptTime;
    }
}
