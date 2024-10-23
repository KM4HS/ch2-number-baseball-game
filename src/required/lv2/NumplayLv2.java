package required.lv2;

import required.Numplay;

public class NumplayLv2 extends Numplay {
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
        } while (!isPlayEnded);
    }
}
