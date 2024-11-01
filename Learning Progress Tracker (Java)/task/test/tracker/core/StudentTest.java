package tracker.core;

import org.junit.jupiter.api.Test;
import tracker.core.back.ProcessStudents;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student1 = new Student("-name", "Surname", "test@test.com");
    private Student student2 = new Student("name", "Surname'-", "test@test.com");
    private Student student3 = new Student("J-C", "VD", "jc@vd.me");
    private Student student4 = new Student("Lan", "Dry", "test@test");
    private String input = "John Doe";
    ProcessStudents process = new ProcessStudents();

    @Test
    public void testFirstname() {
        assertEquals(false,
                student1.checkFirstName(),
                "The first character of the first name must be a letter");
    }

    @Test
    public void testLastName() {
        assertEquals(false,
                student2.checkLastName(),
                "The last name must end with a letter");
    }

    @Test
    public void testInput() {
        assertEquals(false,
                process.checkInput(input),
                "Invalid credentials");
    }

    @Test
    public void validFirstName() {
        assertEquals(true, student3.checkFirstName());
    }

    @Test
    public void validLastName() {
        assertEquals(true, student3.checkLastName());
    }

    @Test
    public void validEmail() {
        assertEquals(true, student3.checkEmail());
    }
}
