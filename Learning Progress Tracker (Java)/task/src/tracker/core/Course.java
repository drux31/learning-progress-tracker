package tracker.core;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<Integer> coursePoints;
    private int courMaxPoints;

    public int getCoursePoints(int i) {
        return coursePoints.get(i);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addCoursePoints(int points) {
        this.coursePoints.add(points);
    }

    public void setCourMaxPoints(int courMaxPoints) {
        this.courMaxPoints = courMaxPoints;
    }

    public int getCourMaxPoints() {
        return courMaxPoints;
    }
}
