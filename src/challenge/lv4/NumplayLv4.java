package challenge.lv4;

import challenge.Numplay;
import challenge.PlayController;

public class NumplayLv4 extends Numplay {
    private static final PlayController playController = new PlayControllerLv4();
    public static void main(String[] args) {
        mainMethod(playController);
    }
}
