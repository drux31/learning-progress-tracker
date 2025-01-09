package tracker.core;

import org.junit.jupiter.api.Test;
import tracker.core.back.ProcessStudents;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private final Student student1 = new Student("-name", "Surname", "test@test.com");
    private final Student student2 = new Student("name", "Surname'-", "test@test.com");
    private final Student student3 = new Student("J-C", "VD", "jc@vd.me");
    private final Student student4 = new Student("Lan", "Dry", "test@test");
    ProcessStudents process = new ProcessStudents();

    @Test
    public void testFirstname() {
        assertFalse(student1.checkFirstName(), "The first character of the first name must be a letter");
    }

    @Test
    public void testLastName() {
        assertFalse(student2.checkLastName(), "The last name must end with a letter");
    }

    @Test
    public void testEmail() {
        assertFalse(student4.checkEmail(), "The Email format is invalid");
    }

    @Test
    public void testInput() {
        String input = "John Doe";
        assertFalse(process.checkInput(input), "Invalid credentials");
    }

    @Test
    public void validFirstName() {
        assertTrue(student3.checkFirstName());
    }

    @Test
    public void validLastName() {
        assertTrue(student3.checkLastName());
    }

    @Test
    public void validEmail() {
        assertTrue(student3.checkEmail());
    }
}
