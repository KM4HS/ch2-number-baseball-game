import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {
    private final List<Integer> correctNum = new ArrayList<>();
    BaseballGame(){
        Set<Integer> numberSet = new HashSet<>();
        while(numberSet.size() < 3){
            numberSet.add((int)Math.floor(Math.random()*9+1));
        }
        this.correctNum.addAll(numberSet);
    }

    public String getCorrectNum(){
        StringBuilder sb = new StringBuilder();
        for(int i : correctNum){
            sb.append(i);
        }
        return sb.toString();
    }
}
