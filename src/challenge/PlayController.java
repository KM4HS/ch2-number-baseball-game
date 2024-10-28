package challenge;

import common.BaseballGame;
import input.ExceptionKeyword;
import input.WrongInputException;
import input.InputHelper;

import java.util.List;

// 숫자 야구 게임의 전체적인 흐름을 관리하는 추상 클래스
public abstract class PlayController {
    protected final GameRecordManager gameRecordManager = new GameRecordManager();
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
            String inputNumber = InputHelper.input("숫자를 입력하세요 : ");
            try {
                ExceptionKeyword.checkInput(ExceptionKeyword.INVALID_NUMBER, inputNumber);
                ExceptionKeyword.checkInput(ExceptionKeyword.SAME_NUMBER, inputNumber);
                ExceptionKeyword.checkInput(ExceptionKeyword.INCLUDE_ZERO, inputNumber);
                if(numberSize != inputNumber.length()){
                    System.out.println(numberSize + "자리수로 입력해주세요.\n");
                    continue;
                }
                baseballGame.startGame(inputNumber);
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("-----------------");
        } while (baseballGame.getIsGameEnded());
        gameRecordManager.addRecord(baseballGame.getTryCount());
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
