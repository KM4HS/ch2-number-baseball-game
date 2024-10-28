package common;

// 사용자 입력값과 정답값을 비교하여 점수를 계산 및 관리하는 클래스
public class ScoreManager {
    private final String inputNumber;
    private final String correctNumber;
    private final int strike;
    private final int ball;

    /**
     * 생성자가 호출되면 매개변수 값을 받아 {@code makeScore()}로 점수를 계산
     *
     * @param inputNumber   : 사용자가 입력한 정답값
     * @param correctNumber : 정답값
     */
    public ScoreManager(String inputNumber, String correctNumber) {
        this.inputNumber = inputNumber;
        this.correctNumber = correctNumber;
        this.strike = countStrike();
        this.ball = countBall();
    }

    private int countStrike() {
        int strikeCount = 0;
        for (int i = 0; i < correctNumber.length(); i++) {
            if (correctNumber.charAt(i) == inputNumber.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall() {
        int ballCount = 0;
        for (int i=0; i < correctNumber.length(); i++){
            if(correctNumber.charAt(i) != inputNumber.charAt(i) &&
            correctNumber.contains(Character.toString(inputNumber.charAt(i)))){
                ballCount++;
            }
        }
        return ballCount;
    }

    /**
     * @return : ball 점수를 반환
     */
    public int getBallCount() {
        return ball;
    }

    /**
     * @return : strike 점수를 반환
     */
    public int getStrikeCount() {
        return strike;
    }
}
