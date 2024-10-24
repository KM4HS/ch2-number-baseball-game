package challenge.lv4;

import challenge.Numplay;
import challenge.PlayController;

// lv4 실행 클래스
public class NumplayLv4 extends Numplay {
    private static final PlayController playController = new PlayControllerLv4();
    public static void main(String[] args) {
        mainMethod(playController);
    }
}
