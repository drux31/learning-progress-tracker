package tracker.core.back;
import tracker.core.Student;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ProcessStudents {

    List<Student> students;// = new HashMap<>();
    Hashtable<Integer, String> studentsIDs;
    ProcessCourses processCourses;

    public ProcessStudents() {
        this.students = new ArrayList<>();
        this.studentsIDs = new Hashtable<>();
        this.processCourses = new ProcessCourses();
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

    public void addPoints(int studentID, ArrayList<Integer> points) {
        if (!this.processCourses.checkStudentSub(studentID)) {
            this.processCourses.setStudentPoints(studentID, points);
        } else {
            this.processCourses.addStudentPoints(studentID, points);
        }
    }

    public Hashtable<Integer, ArrayList<ArrayList<Integer>>> getStudentsPoints() {
        return processCourses.getStudentPoints();
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

    public ArrayList<String> getMostPopularCourse() {
        return this.processCourses.mostPopularCourses();
    }

    public ArrayList<String> getLeastPopularCourse() {
        return this.processCourses.leastpopularCourses();
    }

    public ArrayList<String> getHighestCourse() {
        return this.processCourses.highestCourses();
    }

    public ArrayList<String> getLowestCourse() {
        return this.processCourses.lowestCourses();
    }

    public ArrayList<String> getEasiestCourse() {
        return this.processCourses.easiestCourses();
    }

    public ArrayList<String> getHardestCourse() {
        return this.processCourses.hardestCourses();
    }
}
