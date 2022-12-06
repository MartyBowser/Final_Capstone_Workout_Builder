package com.techelevator.model;

import java.util.List;

public class Exercise {
    private int exerciseId;
    private String exerciseName;
    private String description;
    private int body_group_id;

    public Exercise(int exerciseId, String exerciseName, String description, int body_group_id) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.description = description;
        this.body_group_id = body_group_id;
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

    public int getBody_group_id() {
        return body_group_id;
    }

    public void setBody_group_id(int body_group_id) {
        this.body_group_id = body_group_id;
    }

}
