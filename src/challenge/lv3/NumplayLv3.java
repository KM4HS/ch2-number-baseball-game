package challenge.lv3;

import challenge.Numplay;
import challenge.PlayController;

public class NumplayLv3 extends Numplay {
    private static final PlayController playController = new PlayControllerLv3();

    public static void main(String[] args) {
        mainMethod(playController);
    }
}
