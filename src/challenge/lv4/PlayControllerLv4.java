package challenge.lv4;

import challenge.PlayController;
import common.ExceptionKeyword;
import common.WrongInputException;

// lv4의 게임 실행 흐름을 관리
public class PlayControllerLv4 extends PlayController {
    private static int numberSize = 3;

    /**
     * 사용자에게 4개의 선택지를 제공하고, 각 선택지에 따른 메서드를 실행함. 잘못된 선택지 입력시 탈출.
     *
     * @throws WrongInputException : 선택지 이후 메서드의 예외, 또는 자리수 설정시 지정 범위(3~5)를 벗어나거나 숫자가 아닐 경우
     */
    @Override
    public void startGameMenu() throws WrongInputException {
        System.out.println("0. 자리수 설정(기본 3자리) 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
        switch (sc.nextLine()) {
            case "0": {
                System.out.print("설정하고자 하는 자리수를 입력하세요(3~5) : ");
                try {
                    numberSize = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    throw new WrongInputException(ExceptionKeyword.INVALID_NUMBER);
                }
                if (numberSize > 5 || numberSize < 3) {
                    throw new WrongInputException(ExceptionKeyword.ENABLE_DIGIT);
                }
                System.out.println(numberSize + "자리수 난이도로 설정되었습니다.\n");
            }
            case "1": {
                System.out.println("< 게임을 시작합니다 >");
                playGame(numberSize);
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
