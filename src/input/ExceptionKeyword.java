package input;

import input.inspector.*;

// Input 오류 키워드 모음
public enum ExceptionKeyword {
    INVALID_NUMBER("올바른 숫자를 입력해주세요.\n", new InvalidNumberInspector()),
    INCLUDE_ZERO("입력값은 0을 포함할 수 없습니다.\n" , new IncludeZeroInspector()),
    SAME_NUMBER("중복되지 않는 숫자를 입력해주세요.\n", new SameNumberInspector()),
    UNMATCHED_DIGIT("3~5 사이의 숫자를 입력해주세요.\n", new LevelDigitInspector());
    // ENABLE_DIGIT("자리 숫자를 입력해주세요.\n", new DigitInspector());

    private final String message;
    private final Inspector inspector;

    ExceptionKeyword(String message, Inspector inspector){
        this.message = message;
        this.inspector = inspector;
    }
    public String getMessage(){
        return message;
    }
    public static void checkInput(ExceptionKeyword exceptionKeyword, String input) throws WrongInputException{
        exceptionKeyword.inspector.checkInput(input);
    }
}
