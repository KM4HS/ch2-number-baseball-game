package input.inspector;

import input.ExceptionKeyword;
import input.WrongInputException;

public class IncludeZeroInspector implements Inspector {
    @Override
    public void checkInput(String input) throws WrongInputException {
        if (input.contains("0")) {
            throw new WrongInputException(ExceptionKeyword.INCLUDE_ZERO);
        }
    }
}
