import java.util.Scanner;

public class Numplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseballGame baseballGame = new BaseballGame();

        System.out.println("< 게임을 시작합니다 >");
        do {
            System.out.println("숫자를 입력하세요");
            try {
                baseballGame.startGame(sc.nextLine());
            } catch (WrongInputException e) {
                continue;
            }
            System.out.println(" ");
        } while (!Utils.isGameEnded);
        System.out.println("정답입니다!");
    }
}
