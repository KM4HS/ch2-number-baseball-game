package lv3;

import common.BaseballGame;
import common.WrongInputException;

import java.util.List;
import java.util.Scanner;

public class PlayController {
    private final Scanner sc = new Scanner(System.in);
    private final GameRecordManager gameRecordManager = new GameRecordManager();
    private boolean isPlayRunning = true;

    public void startGameMenu(){
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
        System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
        switch (sc.nextLine()) {
            case "1" -> {
                System.out.println("< 게임을 시작합니다 >");
                playGame();
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
    public boolean getIsPlayRunning(){
        return isPlayRunning;
    }

    private void playGame(){
        BaseballGame baseballGame = new BaseballGame(3);
        do {
            System.out.print("숫자를 입력하세요 : ");
            try {
                baseballGame.startGame(sc.nextLine());
            } catch (WrongInputException e) {
                continue;
            }
            System.out.println("-----------------");
        } while (baseballGame.getIsGameEnded());
        gameRecordManager.addRecord(baseballGame.getAttemptTime());
        System.out.println("정답입니다!");
    }
    private void printRecord(List<Integer> recordList){
        for(int i=0; i<recordList.size(); i++){
            System.out.println((i+1) + "번째 게임 : 시도횟수 - "+recordList.get(i));
        }
    }
}
