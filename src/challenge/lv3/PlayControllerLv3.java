package challenge.lv3;

import challenge.PlayController;

// lv3의 게임 실행 흐름을 관리
public class PlayControllerLv3 extends PlayController {
    /**
     * 사용자에게 3개의 선택지를 제공하고, 각 선택지에 따른 메서드를 실행함.
     */
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
