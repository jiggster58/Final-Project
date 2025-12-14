package org.ryank;

import lombok.Data;
import java.util.ArrayList;
import java.util.Random;

@Data
public class Assignment {

    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private double average;

    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int studentCount) {
        this.assignmentId = "A" + String.format("%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();

        // Initialize scores with nulls
        for (int i = 0; i < studentCount; i++) {
            scores.add(null);
        }
    }

    public void calcAssignmentAvg() {
        int sum = 0;
        int count = 0;

        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }

        average = (count == 0) ? 0 : (double) sum / count;
    }

    public void generateRandomScore() {
        Random rand = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int bucket = rand.nextInt(11); // 0–10
            int score;

            if (bucket == 0) {
                score = rand.nextInt(60);
            } else if (bucket <= 2) {
                score = 60 + rand.nextInt(10);
            } else if (bucket <= 4) {
                score = 70 + rand.nextInt(10);
            } else if (bucket <= 8) {
                score = 80 + rand.nextInt(10);
            } else {
                score = 90 + rand.nextInt(11);
            }

            scores.set(i, score);
        }

        calcAssignmentAvg();
    }

    @Override
    public String toString() {
        return assignmentId + " - " + assignmentName + " (" + weight + "%)";
    }
}
