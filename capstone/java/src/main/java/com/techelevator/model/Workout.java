package com.techelevator.model;

import java.time.LocalDate;

public class Workout {
    private int workoutId;
    private int exerciseId;
    private int bodyGroupId;
    private String workoutName;
    private int sets;
    private int reps;
    private int duration;
    private LocalDate dateCreated;

    public Workout(int workoutId, int exerciseId, int bodyGroupId, String workoutName, int sets, int reps, int duration) {
        this.workoutId = workoutId;
        this.exerciseId = exerciseId;
        this.bodyGroupId = bodyGroupId;
        this.workoutName = workoutName;
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Workout(LocalDate dateCreated, int duration) {
        this.dateCreated = dateCreated;
        this.duration = duration;
    }

    public Workout() {
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getBodyGroupId() {
        return bodyGroupId;
    }

    public void setBodyGroupId(int bodyGroupId) {
        this.bodyGroupId = bodyGroupId;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
