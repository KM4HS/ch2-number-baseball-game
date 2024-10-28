package input.inspector;

import input.ExceptionKeyword;
import input.WrongInputException;

import java.util.HashSet;
import java.util.Set;

public class SameNumberInspector implements Inspector {
    @Override
    public void checkInput(String input) throws WrongInputException {
        Set<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            set.add(c);
        }
        if (input.length() != set.size()) {
            throw new WrongInputException(ExceptionKeyword.SAME_NUMBER);
        }
    }
}
