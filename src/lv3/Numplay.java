package lv3;

import common.BaseballGame;
import common.WrongInputException;

import java.util.Scanner;


public class Numplay {
    static final int NUMBER_SIZE = 3;
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isPlayEnded = false;
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
        do {
            System.out.println("1. 게임 시작하기 2. 종료하기");
            switch (sc.nextLine()) {
                case "1" -> playGame();
                case "2" -> {
                    System.out.println("게임을 종료합니다.");
                    isPlayEnded = true;
                }
                default -> System.out.println("잘못된 입력값입니다.");
            }
        }while(!isPlayEnded);
    }

    private static void playGame(){
        BaseballGame baseballGame = new BaseballGame(NUMBER_SIZE);

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
