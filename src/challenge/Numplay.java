package challenge;

public class Numplay {
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
