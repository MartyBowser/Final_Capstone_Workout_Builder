package com.techelevator.model;

import java.time.LocalDate;

public class Workout {
    private int workoutId;

    private boolean completed = false;
    private int duration;
    private LocalDate dateCreated;

    public Workout(int workoutId, int duration) {
        this.workoutId = workoutId;
        this.duration = duration;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Workout() {
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }









    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
