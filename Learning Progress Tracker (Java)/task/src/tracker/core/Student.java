package tracker.core;

import java.util.Hashtable;
import java.util.Random;

public class Student {
    private final int ID = (new Random()).nextInt(20000);
    private int studentID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Hashtable<String, Integer> studentsPoints;
    private final String NAME_PATTERN = "^[a-zA-Z]+(-|')?[a-zA-Z]+((-|')?[a-zA-Z]+)*";
    private final String EMAIL_PATTERN = "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)?@[A-Za-z0-9]+\\.[A-Za-z0-9]+";

    public Student() {
        this.studentID = ID;
        this.studentsPoints = new Hashtable<>();
    }

    public Student(String firstName, String lastName, String emailAddress) {
        this.studentID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void addPoints(String course, int points) {
        this.studentsPoints.put(course, points);
    }

    public Hashtable<String, Integer> getStudentsPoints() {
        return studentsPoints;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public boolean checkFirstName() {
        return this.firstName.matches(NAME_PATTERN);
    }

    public boolean checkLastName() {
        return this.lastName.matches(NAME_PATTERN + "( " + NAME_PATTERN + ")*");
    }

    public boolean checkEmail() {
        return this.emailAddress.matches(EMAIL_PATTERN);
    }
}
