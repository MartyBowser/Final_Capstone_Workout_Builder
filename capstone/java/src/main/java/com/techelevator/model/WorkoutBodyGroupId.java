package com.techelevator.model;

public class WorkoutBodyGroupId {
    private int bodyGroupId;
    private String workoutId;

    public WorkoutBodyGroupId(int bodyGroupId, String workoutId) {
        this.bodyGroupId = bodyGroupId;
        this.workoutId = workoutId;
    }

    public int getBodyGroupId() {
        return bodyGroupId;
    }

    public void setBodyGroupId(int bodyGroupId) {
        this.bodyGroupId = bodyGroupId;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }
}
