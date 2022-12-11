package com.techelevator.model;

import java.util.List;

public class Exercise {
    private int exerciseId;
    private String exerciseName;
    private String description;
    private int bodyGroupId;
    private int userId;
    private int expectedTime;
    private int suggestedWeight;
    private int numberOfReps;


    public Exercise(int exerciseId, String exerciseName, String description, int bodyGroupId, int userId, int expectedTime, int suggestedWeight, int numberOfReps) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.description = description;
        this.bodyGroupId = bodyGroupId;
        this.userId = userId;
        this.expectedTime = expectedTime;
        this.suggestedWeight = suggestedWeight;
        this.numberOfReps = numberOfReps;
    }

    public Exercise() {}

    public int getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(int expectedTime) {
        this.expectedTime = expectedTime;
    }

    public int getSuggestedWeight() {
        return suggestedWeight;
    }

    public void setSuggestedWeight(int suggestedWeight) {
        this.suggestedWeight = suggestedWeight;
    }

    public int getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(int numberOfReps) {
        this.numberOfReps = numberOfReps;
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
