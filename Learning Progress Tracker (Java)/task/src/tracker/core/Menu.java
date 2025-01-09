package tracker.core;

import tracker.core.back.ProcessStudents;

import java.util.ArrayList;
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
    final List<String> commands = List.of("exit", "back", "list", "add students", "add points", "find");

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
        // Create the student
        Student student = new Student();
        // Get the student credentials
        String[] credTab = this.input.split(" ");
        String[] lastNames = Arrays.copyOfRange(credTab, 1, credTab.length - 1);

        StringBuilder lastName = new StringBuilder();
        for (String str: lastNames) {
            lastName.append(str);
        }
        // Set the student credentials
        student.setFirstName(credTab[0]);
        student.setLastName(lastName.toString());
        student.setEmailAddress(credTab[credTab.length - 1]);

        if (!student.checkFirstName()) {
            return -3;
        } else if(!student.checkLastName()) {
            return -2;
        } else if (!student.checkEmail()) {
            return -1;
        } else if(process.checkEmail(student.getEmailAddress())) {
            return -4;
        }else {
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
            case -4:
                System.out.println("This email is already taken.");
                break;
            default:
                System.out.println("The student has been added.");
        }
    }

    /**
     * Action indicate the action to be performed:
     * 1 - add student
     * 2 - add points
     * 3 - find students
     * @param action
     * @return - the awaited result of the identified action
     */
    private void processInput(int action) {

        while(true) {
            input = scanner.nextLine();
            if (checkInput("back")) {
                break;
            } else {
                switch (action) {
                    case 1:
                        if (emptyInput()) {
                            System.out.println(IC);
                        } else if (!process.checkInput(input)) {
                            System.out.println(IC);
                        } else {
                            checkStudent();
                        }
                        //return process.getNbStudents();
                    case 2:
                        // add points
                        break;

                }
            }
        }
    }

    public void showMenu() {
        boolean exit_status = false;
        while (true) {
            input = scanner.nextLine();

            if(commands.contains(input) && checkInput("back"))
            {
                System.out.println(EP);
            }
            else
            {
                switch (input.toLowerCase()) {
                    case "exit":
                        System.out.println("Bye!");
                        exit_status = true;
                        break;
                    case "add students":
                        System.out.println("Enter student credentials or 'back' to return:");
                        processInput(1);
                        System.out.printf("Total %d students have been added.\n", process.getNbStudents());
                        break;
                    case "list":
                        System.out.println("Students:");
                        process.listStudents();
                        break;
                    case "add points":
                        System.out.println("Enter an id and points or 'back' to return:");
                        // add the process for adding points
                        break;
                    case "find":
                        System.out.println("Enter an id or 'back' to return:");
                        // add the process for find action
                        break;
                    default:
                        System.out.println(EU);
                        break;
                }
            }
            if(exit_status)
                break;
        }
        this.scanner.close();
    }

}
