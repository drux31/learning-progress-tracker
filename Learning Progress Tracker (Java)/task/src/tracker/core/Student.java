package tracker.core;

public class Student {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private final String NAME_PATTERN = "^[a-zA-Z]+(-|')?[a-zA-Z]+((-|')?[a-zA-Z]+)*";
    private final String EMAIL_PATTERN = "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)?@[A-Za-z0-9]+\\.[A-Za-z0-9]+";

    public Student() {
        this.firstName = new String();
        this.lastName = new String();
        this.emailAddress = new String();
    }

    public Student(String firstName, String lastName, String emailAddress) {
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
