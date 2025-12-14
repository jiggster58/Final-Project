package org.ryank;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Course {

    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private ArrayList<Student> registeredStudents = new ArrayList<>();
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
    }

    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment a : assignments) sum += a.getWeight();
        return Math.abs(sum - 100) < 0.0001;
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) return false;
        registeredStudents.add(student);
        for (Assignment a : assignments) a.getScores().add(null);
        return true;
    }

    public boolean addAssignment(String name, double weight) {
        assignments.add(new Assignment(Util.toTitleCase(name), weight));
        for (Student s : registeredStudents) assignments.get(assignments.size()-1).getScores().add(null);
        return true;
    }

    public String toSimplifiedString() {
        return courseId + " - " + courseName + " (" + credits + ") Dept: " + department.getDepartmentName();
    }

    @Override
    public String toString() {
        return toSimplifiedString() + ", Assignments: " + assignments.size() + ", Students: " + registeredStudents.size() +
                ", WeightValid: " + isAssignmentWeightValid();
    }
}
