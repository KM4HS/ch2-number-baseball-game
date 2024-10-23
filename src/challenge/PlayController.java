package challenge;

import common.BaseballGame;
import common.WrongInputException;

import java.util.List;
import java.util.Scanner;

public abstract class PlayController {
    protected final GameRecordManager gameRecordManager = new GameRecordManager();
    protected final Scanner sc = new Scanner(System.in);
    protected boolean isPlayRunning = true;

    abstract public void startGameMenu() throws WrongInputException;

    public boolean getIsPlayRunning() {
        return isPlayRunning;
    }

    protected void playGame(int numberSize) {
        BaseballGame baseballGame = new BaseballGame(numberSize);
        do {
            try {
                System.out.print("숫자를 입력하세요 : ");
                baseballGame.startGame(sc.nextLine());
            } catch (WrongInputException e) {
                continue;
            }
            System.out.println("-----------------");
        } while (baseballGame.getIsGameEnded());
        gameRecordManager.addRecord(baseballGame.getAttemptTime());
        System.out.println("정답입니다!");
    }

    protected void printRecord(List<Integer> recordList) {
        for (int i = 0; i < recordList.size(); i++) {
            System.out.println((i + 1) + "번째 게임 : 시도횟수 - " + recordList.get(i));
        }
    }
}
