package tracker.core.back;
import tracker.core.Student;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ProcessStudents {

    List<Student> students;// = new HashMap<>();
    Hashtable<Integer, String> studentsIDs;

    public ProcessStudents() {
        this.students = new ArrayList<>();
        this.studentsIDs = new Hashtable<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
        this.studentsIDs.put(student.getStudentID(), student.getEmailAddress());
    }

    public void listStudents() {
        if (studentsIDs.isEmpty()) {
            System.out.println("No students found");
        } else {
            for (Map.Entry<Integer, String> entry: studentsIDs.entrySet()) {
                System.out.println(entry.getKey());
            }
        }
    }

    public Student getStudent(int ID) {
        Student student = null;
        for(Student stu: students) {
            if(stu.getStudentID() == ID) {
                student = stu;
                break;
            }
        }
        return student;
    }

    public boolean checkEmail(String email) {
        return studentsIDs.containsValue(email);
    }

    public boolean checkID(int id) {
        return studentsIDs.containsKey(id);
    }

    public boolean checkInput(String input) {
        return input.split(" ").length >= 3;
    }

    public int getNbStudents() {
        return this.students.size();
    }
}
