package required;

import common.BaseballGame;
import common.WrongInputException;

import java.util.Scanner;

// 필수(required) 기능의 실행을 위한 부모 클래스
public class Numplay {
    protected static final Scanner sc = new Scanner(System.in);
    protected static final int NUMBER_SIZE = 3;
    protected static final BaseballGame baseballGame = new BaseballGame(NUMBER_SIZE);

    /**
     * 정답을 맞출 때까지 게임을 반복 실행
     */
    protected static void playGame() {
        System.out.println("< 게임을 시작합니다 >");
        do {
            System.out.println("숫자를 입력하세요");
            try {
                baseballGame.startGame(sc.nextLine());
            } catch (WrongInputException e) {
                continue;
            }
            System.out.println(" ");
        } while (baseballGame.getIsGameEnded());
        System.out.println("정답입니다!");
    }
}
