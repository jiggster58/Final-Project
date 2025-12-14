package org.ryank;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Student {

    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses = new ArrayList<>();
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.studentId = "S" + String.format("%06d", nextId++);
    }

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) return false;
        registeredCourses.add(course);
        course.registerStudent(this);
        return true;
    }

    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) return false;
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        return true;
    }

    public String toSimplifiedString() {
        return studentId + " - " + studentName + " (" + department.getDepartmentName() + ")";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toSimplifiedString()).append(", Courses: ");
        for (Course c : registeredCourses) sb.append(c.toSimplifiedString()).append("; ");
        return sb.toString();
    }
}
