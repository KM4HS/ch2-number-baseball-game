package challenge.lv3;

import challenge.PlayController;

public class PlayControllerLv3 extends PlayController {
    @Override
    public void startGameMenu() {
        System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
        switch (sc.nextLine()) {
            case "1" -> {
                System.out.println("< 게임을 시작합니다 >");
                playGame(3);
            }
            case "2" -> {
                System.out.println("< 게임 기록 보기 >");
                printRecord(gameRecordManager.getRecord());
            }
            case "3" -> {
                System.out.println("게임을 종료합니다.");
                isPlayRunning = false;
            }
            default -> System.out.println("잘못된 입력값입니다.");
        }
    }
}
