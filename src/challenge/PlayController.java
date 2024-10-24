package challenge;

import common.BaseballGame;
import common.WrongInputException;

import java.util.List;
import java.util.Scanner;

// 숫자 야구 게임의 전체적인 흐름을 관리하는 추상 클래스
public abstract class PlayController {
    protected final GameRecordManager gameRecordManager = new GameRecordManager();
    protected final Scanner sc = new Scanner(System.in);
    protected boolean isPlayRunning = true;

    /**
     * 게임 시작시 메뉴를 각 클래스에서 설정하게 함
     *
     * @throws WrongInputException : 입력값 예외
     */
    abstract public void startGameMenu() throws WrongInputException;

    /**
     * 게임 진행 여부를 반환함
     *
     * @return : {@code isPlayRunning}이 false 일 때 게임 종료
     */
    public boolean getIsPlayRunning() {
        return isPlayRunning;
    }

    /**
     * 숫자 야구 게임을 1회 진행시킴. 결과를 {@link GameRecordManager}로 저장.
     *
     * @param numberSize : 이번 게임에서 설정된 자리수
     */
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

    /**
     * 시도 횟수 기록을 양식에 맞게 출력
     *
     * @param recordList : 시도 횟수가 담긴 리스트
     */
    protected void printRecord(List<Integer> recordList) {
        for (int i = 0; i < recordList.size(); i++) {
            System.out.println((i + 1) + "번째 게임 : 시도횟수 - " + recordList.get(i));
        }
    }
}
