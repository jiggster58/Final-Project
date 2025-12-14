package org.ryank;

import lombok.Data;

import java.util.ArrayList;
import java.util.Random;

@Data
public class Assignment {

    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores = new ArrayList<>();
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.assignmentId = "A" + String.format("%02d", nextId++);
    }

    public double calcAssignmentAvg() {
        if (scores.isEmpty()) return 0;
        int sum = 0, count = 0;
        for (Integer s : scores) {
            if (s != null) {
                sum += s;
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    public void generateRandomScore(int numberOfStudents) {
        Random rand = new Random();
        scores.clear();
        for (int i = 0; i < numberOfStudents; i++) {
            int r = rand.nextInt(11); // 0-10
            int score;
            if (r == 0) score = rand.nextInt(60);
            else if (r <= 2) score = 60 + rand.nextInt(10);
            else if (r <= 4) score = 70 + rand.nextInt(10);
            else if (r <= 8) score = 80 + rand.nextInt(10);
            else score = 90 + rand.nextInt(11);
            scores.add(score);
        }
    }

    @Override
    public String toString() {
        return assignmentId + " - " + assignmentName + " (" + weight + "%)";
    }
}
