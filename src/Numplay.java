import java.util.Scanner;

public class Numplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isGameEnded = false;
        do {
            BaseballGame baseballGame = new BaseballGame();

            System.out.println("< 게임을 시작합니다 >");
            System.out.println("숫자를 입력하세요");

            String inputNumber = sc.nextLine();
            if("exit".equals(inputNumber)){
                isGameEnded = true;
            } else if (String.valueOf(baseballGame.getCorrectNum()).equals(inputNumber)){
                System.out.println("정답입니다!");
            }
        }while(!isGameEnded);
    }
}
