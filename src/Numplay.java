import java.util.List;
import java.util.Scanner;

public class Numplay {
    private final static int numSize = 3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isGameEnded = false;

        System.out.println("< 게임을 시작합니다 >");
        do {
            BaseballGame baseballGame = new BaseballGame();
            List<Integer> inputNumber;

            System.out.println("숫자를 입력하세요");
            try{
                inputNumber = Parser.parseIntArr(sc.nextLine());
            }catch(WrongInputException e){
                continue;
            }
            isGameEnded = baseballGame.printAnswer(inputNumber);
            System.out.println(" ");
        }while(!isGameEnded);
    }
}
