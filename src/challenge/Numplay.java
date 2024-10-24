package challenge;

// 도전 과제의 실행을 위한 부모 클래스
public class Numplay {
    /**
     * 지정 레벨의 {@code playController}로 게임을 시작함
     *
     * @param playController : {@link PlayController}의 자식 클래스를 받아 레벨을 결정
     */
    protected static void mainMethod(PlayController playController) {
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
        do {
            try {
                playController.startGameMenu();
            } catch (common.WrongInputException e) {
                continue;
            }
            System.out.println("====================");
        } while (playController.getIsPlayRunning());
    }
}
