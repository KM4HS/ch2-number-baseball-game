package input.inspector;

import input.ExceptionKeyword;
import input.WrongInputException;

public class LevelDigitInspector implements Inspector {
    @Override
    public void checkInput(String input) throws WrongInputException {
        if (Integer.parseInt(input) > 5 || Integer.parseInt(input) < 3) {
            throw new WrongInputException(ExceptionKeyword.UNMATCHED_DIGIT);
        }
    }
}
