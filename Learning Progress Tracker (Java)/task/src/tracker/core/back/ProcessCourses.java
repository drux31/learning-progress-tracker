package tracker.core.back;

import tracker.core.Course;

import java.util.*;

public class ProcessCourses {
    // map of students points
    private Hashtable<Integer, ArrayList<ArrayList<Integer>>> studentPoints;
    private Hashtable<String, Integer> coursesMax;

    ProcessCourses() {
        this.studentPoints = new Hashtable<>();
        coursesMax = new Hashtable<>();
        coursesMax.put("Java", 600);
        coursesMax.put("DSA", 400);
        coursesMax.put("Databases", 480);
        coursesMax.put("Spring", 550);
    }

    public void setStudentPoints(int studentID, ArrayList<Integer> points) {
        ArrayList<ArrayList<Integer>> coursePoints = new ArrayList<>();
        coursePoints.add(points);
        this.studentPoints.put(studentID, coursePoints);
    }

    public void addStudentPoints(int studentID, ArrayList<Integer> coursePoint) {
        this.studentPoints.get(studentID).add(coursePoint);
    }

    public boolean checkStudentSub(int studentID) {
        return this.studentPoints.containsKey(studentID);
    }

    public Hashtable<Integer, ArrayList<ArrayList<Integer>>> getStudentPoints() {
        return studentPoints;
    }

    public int getSizeStudentPoints() {
        return studentPoints.size();
    }

    public ArrayList<String> mostPopularCourses() {
        /*
        0 = Java
        1 = DSA
        2 = Databases
        3 = Spring
        */
        int nbJava = 0;
        int nbDSA = 0;
        int nbDB = 0;
        int nbSpring = 0;
        int max;
        boolean jv = false;
        boolean dsa = false;
        boolean db = false;
        boolean spr = false;

        ArrayList<String> mostPopular = new ArrayList<>();
        for (int stuID: this.studentPoints.keySet()) {
            ArrayList<ArrayList<Integer>> pointsList = this.studentPoints.get(stuID);
            for (ArrayList<Integer> points: pointsList) {

                if (points.get(0) > 0) {
                    jv = true;
                }
                if (points.get(1) > 0) {
                    dsa = true;
                }
                if (points.get(2) > 0) {
                    db = true;
                }
                if (points.get(3) > 0) {
                    spr = true;
                }
            }
            if (jv)
                nbJava ++;
            if (dsa)
                nbDSA ++;
            if (db)
                nbDB ++;
            if (spr)
                nbSpring++;
        }
        List<Integer> vals = List.of(nbJava, nbDSA, nbDB, nbSpring);
        max = Collections.max(vals);
        int index = 0;
        for (int i = 0; i < vals.size(); i++) {
            if (vals.get(i) == max) {
                switch (i) {
                    case 0:
                        mostPopular.add("Java");
                        break;
                    case 1:
                        mostPopular.add("DSA");
                        break;
                    case 2:
                        mostPopular.add("Database");
                        break;
                    case 3:
                        mostPopular.add("Spring");
                        break;
                }
            }
        }
        return mostPopular;
    }

    public ArrayList<String> leastopularCourses() {
        /*
        0 = Java
        1 = DSA
        2 = Databases
        3 = Spring
        */
        int nbJava = 0;
        int nbDSA = 0;
        int nbDB = 0;
        int nbSpring = 0;
        int min;
        boolean jv = false;
        boolean dsa = false;
        boolean db = false;
        boolean spr = false;

        ArrayList<String> leastPopular = new ArrayList<>();
        for (int stuID: this.studentPoints.keySet()) {
            ArrayList<ArrayList<Integer>> pointsList = this.studentPoints.get(stuID);
            for (ArrayList<Integer> points: pointsList) {

                if (points.get(0) >= 0) {
                    jv = true;
                }
                if (points.get(1) >= 0) {
                    dsa = true;
                }
                if (points.get(2) >= 0) {
                    db = true;
                }
                if (points.get(3) >= 0) {
                    spr = true;
                }
            }
            if (jv)
                nbJava ++;
            if (dsa)
                nbDSA ++;
            if (db)
                nbDB ++;
            if (spr)
                nbSpring++;
        }
        List<Integer> vals = List.of(nbJava, nbDSA, nbDB, nbSpring);
        min = Collections.min(vals);
        int index = 0;
        for (int i = 0; i < vals.size(); i++) {
            if (vals.get(i) == min) {
                switch (i) {
                    case 0:
                        leastPopular.add("Java");
                        break;
                    case 1:
                        leastPopular.add("DSA");
                        break;
                    case 2:
                        leastPopular.add("Database");
                        break;
                    case 3:
                        leastPopular.add("Spring");
                        break;
                }
            }
        }
        return leastPopular;
    }
}
