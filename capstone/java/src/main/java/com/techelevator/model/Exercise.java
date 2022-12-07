package com.techelevator.model;

import java.util.List;

public class Exercise {
    private int exerciseId;
    private String exerciseName;
    private String description;
    private int bodyGroupId;

    public Exercise(int exerciseId, String exerciseName, String description, int bodyGroupId) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.description = description;
        this.bodyGroupId = bodyGroupId;
    }
    public Exercise() {

    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBodyGroupId() {
        return bodyGroupId;
    }

    public void setBodyGroupId(int bodyGroupId) {
        this.bodyGroupId = bodyGroupId;
    }

}
