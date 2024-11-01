package tracker.core;

import tracker.core.back.ProcessStudents;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String input;
    private Scanner scanner;
    private ProcessStudents process;
    final String NI = "No input";
    final String EU = "Error: unknown command!";
    final String EP = "Enter 'exit' to exit the program.";
    final String IC = "Incorrect credentials";
    final List<String> commands = List.of("exit", "back");


    public Menu() {
        this.scanner = new Scanner(System.in);
        this.process = new ProcessStudents();
    }

    private boolean checkInput(String str) {
        return this.input.compareToIgnoreCase(str) == 0;
    }

    private boolean emptyInput() {
        return input.isEmpty() || input.isBlank() ;
    }

    private int createStudent() {
        //create the student
        Student student = new Student();
        String[] credTab = this.input.split(" ");
        String[] lastNames = Arrays.copyOfRange(credTab, 1, credTab.length - 1);

        StringBuilder lastName = new StringBuilder();
        for (String str: lastNames) {
            lastName.append(str);
        }

        student.setFirstName(credTab[0]);
        student.setLastName(lastName.toString());
        student.setEmailAddress(credTab[credTab.length - 1]);

        if (!student.checkFirstName()) {
            return -3;
        } else if(!student.checkLastName()) {
            return -2;
        } else if (!student.checkEmail()) {
            return -1;
        } else {
            this.process.addStudent(student);
        }
        return 1;
    }

    private void checkStudent() {
        switch (createStudent()) {
            case -1:
                System.out.println("Incorrect email.");
                break;
            case -2:
                System.out.println("Incorrect last name.");
                break;
            case -3:
                System.out.println("Incorrect first name.");
                break;
            default:
                System.out.println("The student has been added.");
        }
    }

    private int processInput() {
        while(true) {
            input = scanner.nextLine();
            if (checkInput("back")) {
                break;
            } else if(emptyInput()) {
                System.out.println(IC);
            } else if(!process.checkInput(input)) {
                System.out.println(IC);
            }
            else {
                checkStudent();
            }
        }
        return process.getNbStudents();
    }

    public void showMenu() {
        int nbStudent;
        while (true) {
            input = scanner.nextLine();

            if (this.checkInput("exit"))
            {
                System.out.println("Bye!");
                this.scanner.close();
                break;
            } else if(this.checkInput("add students")) {
                System.out.println("Enter student credentials or 'back' to return:");
                nbStudent = processInput();
                System.out.printf("Total %d students have been added.\n", nbStudent);
            }
            else if(emptyInput())
            {
                System.out.println(NI);
            }
            else if(commands.contains(input) && !checkInput("exit"))
            {
                System.out.println(EP);
            }
            else
            {
                System.out.println(EU);
            }
        }
        this.scanner.close();
    }

}
