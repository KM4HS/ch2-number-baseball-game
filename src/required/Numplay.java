package required;

import common.BaseballGame;
import common.WrongInputException;

import java.util.Scanner;

public class Numplay {
    protected static final Scanner sc = new Scanner(System.in);
    protected static final int NUMBER_SIZE = 3;
    protected static final BaseballGame baseballGame = new BaseballGame(NUMBER_SIZE);

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
