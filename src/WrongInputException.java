enum ExceptionKeyword{
    INVALID_NUMBER,
    INCLUDE_ZERO,
    SAME_NUMBER;
}

public class WrongInputException extends Exception {
    WrongInputException(ExceptionKeyword exceptionKeyword){
        switch (exceptionKeyword){
            case INVALID_NUMBER -> System.out.println("올바른 숫자를 입력해주세요.");
            case INCLUDE_ZERO -> System.out.println("입력값은 0을 포함할 수 없습니다.");
            case SAME_NUMBER -> System.out.println("중복되지 않는 숫자를 입력해주세요.");
        }
    }
}
