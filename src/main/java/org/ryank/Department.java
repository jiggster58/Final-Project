package org.ryank;

import lombok.Data;

@Data
public class Department {

    private String departmentId;     // D01, D02, ...
    private String departmentName;
    private static int nextId = 1;

    public static boolean isDepartmentNameValid(String name) {
        if (name == null || name.isEmpty()) return false;
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') return false;
        }
        return true;
    }

    public Department(String departmentName) {

        if (!isDepartmentNameValid(departmentName)) {
            this.departmentId = null;
            this.departmentName = null;
            return;
        }

        // Convert to Title Case using Util
        this.departmentName = Util.toTitleCase(departmentName);

        this.departmentId = "D" + String.format("%02d", nextId++);
    }
}
