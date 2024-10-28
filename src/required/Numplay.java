package required;

import common.BaseballGame;
import input.ExceptionKeyword;
import input.InputHelper;
import input.WrongInputException;

import java.util.Scanner;

// 필수(required) 기능의 실행을 위한 부모 클래스
public class Numplay {
    protected static final int NUMBER_SIZE = 3;

    /**
     * 정답을 맞출 때까지 게임을 반복 실행
     */
    protected static void playGame() {
        System.out.println("< 게임을 시작합니다 >");
        BaseballGame baseballGame = new BaseballGame(NUMBER_SIZE);
        do {
            try {
                String inputNumber = InputHelper.input("숫자를 입력하세요\n");
                ExceptionKeyword.checkInput(ExceptionKeyword.INVALID_NUMBER, inputNumber);
                ExceptionKeyword.checkInput(ExceptionKeyword.INCLUDE_ZERO, inputNumber);
                ExceptionKeyword.checkInput(ExceptionKeyword.SAME_NUMBER, inputNumber);
                if(NUMBER_SIZE != inputNumber.length()){
                    System.out.println(NUMBER_SIZE + "자리수로 입력해주세요.\n");
                    continue;
                }
                baseballGame.startGame(inputNumber);
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println(" ");
        } while (baseballGame.getIsGameEnded());
        System.out.println("정답입니다!");
    }
}
