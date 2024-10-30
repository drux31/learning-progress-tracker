package tracker.core;

import java.util.Scanner;

public class Menu {
    private String input;
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }


    public void showMenu() {
        final String EU = "Error: unknown command!";
        final String NI = "No input";

        while (true) {
            input = scanner.nextLine();
            if (input.compareTo("exit") == 0)
            {
                System.out.println("Bye!");
                this.scanner.close();
                break;
            } else if(input.isEmpty() || input.isBlank())
            {
                System.out.println(NI);
            } else
            {
                System.out.println(EU);
            }
        }
    }

}
