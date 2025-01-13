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

    public List<Integer> calculPopularity() {
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

        boolean jv = false;
        boolean dsa = false;
        boolean db = false;
        boolean spr = false;

        for (int stuID : this.studentPoints.keySet()) {
            ArrayList<ArrayList<Integer>> pointsList = this.studentPoints.get(stuID);
            for (ArrayList<Integer> points : pointsList) {

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
                nbJava++;
            if (dsa)
                nbDSA++;
            if (db)
                nbDB++;
            if (spr)
                nbSpring++;
        }
        List<Integer> vals = List.of(nbJava, nbDSA, nbDB, nbSpring);
        return vals;
    }

    public List<Integer> calculateRatio() {
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
        for (int stuID : this.studentPoints.keySet()) {
            ArrayList<ArrayList<Integer>> pointsList = this.studentPoints.get(stuID);
            for (ArrayList<Integer> points : pointsList) {

                if (points.get(0) > 0) {
                    nbJava ++;
                }
                if (points.get(1) > 0) {
                    nbDSA ++;
                }
                if (points.get(2) > 0) {
                    nbDB ++;
                }
                if (points.get(3) > 0) {
                    nbSpring ++;
                }
            }
        }
        List<Integer> vals = List.of(nbJava, nbDSA, nbDB, nbSpring);
        return vals;
    }

    public List<Integer> calculateDifficulty() {
        /*
        0 = Java
        1 = DSA
        2 = Databases
        3 = Spring
        */
        int nbJava = 0;
        int ijava = 0;
        int avgJava = 0;

        int nbDSA = 0;
        int idsa = 0;
        int avgDSA = 0;

        int nbDB = 0;
        int idb = 0;
        int avgDB = 0;

        int nbSpring = 0;
        int ispring = 0;
        int avgSpring = 0;

        for (int stuID : this.studentPoints.keySet()) {
            ArrayList<ArrayList<Integer>> pointsList = this.studentPoints.get(stuID);
            for (ArrayList<Integer> points : pointsList) {

                if (points.get(0) > 0) {
                    nbJava += points.get(0);
                    ijava ++;
                }
                if (points.get(1) > 0) {
                    nbDSA += points.get(1);
                    idsa ++;
                }
                if (points.get(2) > 0) {
                    nbDB += points.get(2);
                    idb ++;
                }
                if (points.get(3) > 0) {
                    nbSpring += points.get(3);
                    ispring ++;
                }
            }
        }
        if (nbJava > 0) {
            avgJava = nbJava/ijava;
        }
        if (nbDSA > 0) {
            avgDSA = nbDSA/idsa;
        }
        if (nbDB > 0) {
            avgDB = nbDB/idb;
        }
        if (nbSpring > 0) {
            avgSpring = nbSpring/ispring;
        }
        List<Integer> vals = List.of(avgJava, avgDSA, avgDB, avgSpring);
        return vals;
    }

    ArrayList<String> mostPopularCourses() {
        ArrayList<String> mostPopular = new ArrayList<>();
        List<Integer> vals = this.calculPopularity();

        int max = Collections.max(vals);
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

    public ArrayList<String> leastpopularCourses() {
        List<Integer> vals = this.calculPopularity();
        ArrayList<String> leastPopular = new ArrayList<>();
        int min = Collections.min(vals);

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

    ArrayList<String> highestCourses() {
        List<Integer> vals = this.calculateRatio();
        ArrayList<String> highest = new ArrayList<>();
        int max = Collections.max(vals);

        for (int i = 0; i < vals.size(); i++) {
            if (vals.get(i) == max) {
                switch (i) {
                    case 0:
                        highest.add("Java");
                        break;
                    case 1:
                        highest.add("DSA");
                        break;
                    case 2:
                        highest.add("Database");
                        break;
                    case 3:
                        highest.add("Spring");
                        break;
                }
            }
        }
        return highest;
    }

    ArrayList<String> lowestCourses() {
        List<Integer> vals = this.calculateRatio();
        ArrayList<String> lowest = new ArrayList<>();
        int min = Collections.min(vals);

        for (int i = 0; i < vals.size(); i++) {
            if (vals.get(i) == min) {
                switch (i) {
                    case 0:
                        lowest.add("Java");
                        break;
                    case 1:
                        lowest.add("DSA");
                        break;
                    case 2:
                        lowest.add("Database");
                        break;
                    case 3:
                        lowest.add("Spring");
                        break;
                }
            }
        }
        return lowest;
    }

    ArrayList<String> easiestCourses() {
        List<Integer> vals = this.calculateRatio();
        ArrayList<String> easiest = new ArrayList<>();
        int max = Collections.max(vals);

        for (int i = 0; i < vals.size(); i++) {
            if (vals.get(i) == max) {
                switch (i) {
                    case 0:
                        easiest.add("Java");
                        break;
                    case 1:
                        easiest.add("DSA");
                        break;
                    case 2:
                        easiest.add("Database");
                        break;
                    case 3:
                        easiest.add("Spring");
                        break;
                }
            }
        }
        return easiest;
    }

    ArrayList<String> hardestCourses() {
        List<Integer> vals = this.calculateRatio();
        ArrayList<String> hardest = new ArrayList<>();
        int min = Collections.min(vals);

        for (int i = 0; i < vals.size(); i++) {
            if (vals.get(i) == min) {
                switch (i) {
                    case 0:
                        hardest.add("Java");
                        break;
                    case 1:
                        hardest.add("DSA");
                        break;
                    case 2:
                        hardest.add("Database");
                        break;
                    case 3:
                        hardest.add("Spring");
                        break;
                }
            }
        }
        return hardest;
    }
}
