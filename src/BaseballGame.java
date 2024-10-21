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

    public List<Integer> getCorrectNum(){
        return this.correctNum;
    }

    private static class Result{
        int ballCount;
        int strikeCount;
    }

    public boolean printAnswer(List<Integer> inputNumber){
        Result result = new Result();
        for(int i=0; i<inputNumber.size(); i++){
            if(inputNumber.indexOf(i) == correctNum.indexOf(i)){
                result.strikeCount++;
            }else if(correctNum.contains(inputNumber.indexOf(i))) {
                result.ballCount++;
            }
        }
        if(result.strikeCount==0&&result.ballCount==0){
            System.out.println("아웃");
        }
        if(result.strikeCount != 0){
            System.out.println("스트라이크"+result.strikeCount+" ");
        }
        if(result.ballCount != 0){
            System.out.println("볼"+result.ballCount);
        }

        return result.strikeCount==inputNumber.size();
    }
}
