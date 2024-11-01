package tracker.core.back;
import tracker.core.Student;
import java.util.ArrayList;
import java.util.List;

public class ProcessStudents {

    List<Student> students;// = new HashMap<>();

    public ProcessStudents() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Student getStudent(int index) {
        return this.students.get(index);
    }

    public boolean checkInput(String input) {
        return input.split(" ").length >= 3;
    }

    public int getNbStudents() {
        return this.students.size();
    }
}
