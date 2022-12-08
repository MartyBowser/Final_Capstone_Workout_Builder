package com.techelevator.model;

import java.util.List;

public class Exercise {
    private int exerciseId;
    private String exerciseName;
    private String description;
    private int bodyGroupId;
    private int userId;

    public Exercise(int exerciseId, String exerciseName, String description, int bodyGroupId, int userId) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.description = description;
        this.bodyGroupId = bodyGroupId;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
