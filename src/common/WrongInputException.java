package common;

public class WrongInputException extends Exception {
    public WrongInputException(ExceptionKeyword exceptionKeyword) {
        switch (exceptionKeyword) {
            case INVALID_NUMBER -> System.out.println("올바른 숫자를 입력해주세요.\n");
            case INCLUDE_ZERO -> System.out.println("입력값은 0을 포함할 수 없습니다.\n");
            case SAME_NUMBER -> System.out.println("중복되지 않는 숫자를 입력해주세요.\n");
            case ENABLE_DIGIT -> System.out.println("3~5 사이의 숫자를 입력해주세요.\n");
        }
    }

    WrongInputException(ExceptionKeyword exceptionKeyword, int numberSize) {
        if (exceptionKeyword == ExceptionKeyword.UNMATCHED_DIGIT) {
            System.out.println(numberSize + "자리 숫자를 입력해주세요.\n");
        }
    }
}
