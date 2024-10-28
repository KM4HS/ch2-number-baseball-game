package challenge.lv4;

import challenge.PlayController;
import input.ExceptionKeyword;
import input.WrongInputException;
import input.InputHelper;

// lv4의 게임 실행 흐름을 관리
public class PlayControllerLv4 extends PlayController {
    private String inputNumberSize = "3";

    @Override
    public void startGameMenu() {
        switch (InputHelper.input("0. 자리수 설정(기본 3자리) 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기\n")) {
            case "0": {
                String temp = InputHelper.input("설정하고자 하는 자리수를 입력하세요(3~5) : ");
                try {
                    ExceptionKeyword.checkInput(ExceptionKeyword.INVALID_NUMBER, temp);
                    ExceptionKeyword.checkInput(ExceptionKeyword.UNMATCHED_DIGIT,temp);
                } catch (WrongInputException e) {
                    System.out.println(e.getMessage());
                    break;
                }
                inputNumberSize = temp;
                System.out.println(inputNumberSize + "자리수 난이도로 설정되었습니다.\n");
            }
            case "1": {
                System.out.println("< 게임을 시작합니다 >");
                playGame(Integer.parseInt(inputNumberSize));
                break;
            }
            case "2": {
                System.out.println("< 게임 기록 보기 >");
                printRecord(gameRecordManager.getRecord());
                break;
            }
            case "3": {
                System.out.println("게임을 종료합니다.");
                isPlayRunning = false;
                break;
            }
            default: {
                System.out.println("잘못된 입력값입니다.");
                break;
            }
        }
    }
}
