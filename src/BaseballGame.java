import java.util.HashSet;
import java.util.Set;

public class BaseballGame {
    protected final static Set<Integer> correctNum = new HashSet<>();

    BaseballGame() {
        while (correctNum.size() < Utils.numSize) {
            correctNum.add((int) Math.floor(Math.random() * 9 + 1));
        }
    }

    public void startGame(String input) throws WrongInputException {
        new Parser(input);
    }
}
