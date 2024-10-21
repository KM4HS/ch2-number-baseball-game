import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Parser {
    private static final String NUMBER_REG = "^[0-9]*$";

    public static List<Integer> parseIntArr(String input) throws WrongInputException {
        if(Pattern.matches(NUMBER_REG, input)){
            Set<Integer> set = new HashSet<>();
            for(String s : input.split("")){
                if(s.equals("0")){
                    throw new WrongInputException(ExceptionKeyword.INCLUDE_ZERO);
                }
                set.add(Integer.parseInt(s));
            }
            if(set.size() == input.length()){
                return new ArrayList<>(set);
            }else{
                throw new WrongInputException(ExceptionKeyword.INVALID_NUMBER);
            }
        } else {
            throw new WrongInputException(ExceptionKeyword.INVALID_NUMBER);
        }
    }
}
