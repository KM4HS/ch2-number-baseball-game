package input.inspector;

import input.WrongInputException;

public interface Inspector {
    void checkInput(String input) throws WrongInputException;
}

