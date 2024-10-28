package input.inspector;

import input.ExceptionKeyword;
import input.WrongInputException;

public class InvalidNumberInspector implements Inspector {
    @Override
    public void checkInput(String input) throws WrongInputException {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new WrongInputException(ExceptionKeyword.INVALID_NUMBER);
        }
    }
}
