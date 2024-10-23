package lv3;

public class Numplay {
    public static void main(String[] args) {
        PlayController playController = new PlayController();
        do {
            playController.startGameMenu();
        }while(playController.getIsPlayRunning());
    }
}
