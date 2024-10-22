import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Parser {
    private static final String NUMBER_REG = "^[0-9]*$";
    private final String input;
    private final Set<Integer> set = new LinkedHashSet<>();

    Parser(String input) throws WrongInputException {
        this.input = input;
        ScoreManager scoreManager = new ScoreManager(parseIntSet());
        scoreManager.printScore();
    }

    /**
     * 사용자가 입력한 String을 각 예외사항 체크한 후 Set으로 반환
     *
     * @return 사용자 입력값이 담긴 LinkedHashSet
     * @throws WrongInputException {@code checkSame}: 중복 숫자,
     *                             {@code checkZero}: 0 포함,
     *                             {@code checkDigit}: 자릿수 체크,
     *                             {@code Pattern.matches} 숫자인지 체크
     */
    public Set<Integer> parseIntSet() throws WrongInputException {
        if (Pattern.matches(NUMBER_REG, input)) {
            for (String s : input.split("")) {
                set.add(Integer.parseInt(s));
            }
            checkSame();
            checkZero();
            checkDigit();
            return set;
        } else {
            throw new WrongInputException(ExceptionKeyword.INVALID_NUMBER);
        }
    }

    /**
     * 입력한 자릿수와 정답 자릿수가 일치한지 체크
     *
     * @throws WrongInputException 자릿수가 다를 경우
     */
    private void checkDigit() throws WrongInputException {
        if (input.length() > Utils.numSize) {
            throw new WrongInputException(ExceptionKeyword.UNMATCHED_DIGIT);
        }
    }

    /**
     * 입력값에 0이 포함되어 있는지 체크
     *
     * @throws WrongInputException 0이 포함된 경우
     */
    private void checkZero() throws WrongInputException {
        if (set.contains(0)) {
            throw new WrongInputException(ExceptionKeyword.INCLUDE_ZERO);
        }
    }

    /**
     * 입력값에 중복 숫자가 있는지 체크
     *
     * @throws WrongInputException 중복 숫자가 있는 경우
     */
    private void checkSame() throws WrongInputException {
        if (set.size() != input.length()) {
            throw new WrongInputException(ExceptionKeyword.SAME_NUMBER);
        }
    }
}
