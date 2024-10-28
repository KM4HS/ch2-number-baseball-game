package input;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    public static String input(String prompt){
        System.out.print(prompt);
        return sc.nextLine();
    }
}
