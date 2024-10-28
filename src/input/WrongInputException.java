package input;

public class WrongInputException extends Exception {
    public WrongInputException(ExceptionKeyword exceptionKeyword) {
        super(exceptionKeyword.getMessage());
    }
}
