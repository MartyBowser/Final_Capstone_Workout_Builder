package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;

import java.time.LocalDate;
import java.util.List;

public interface WorkoutDao {
    List<Workout> findAll();

    Workout getWorkoutById(int workoutId);

    Workout findWorkoutByName(String workoutName);

    int findIdByWorkoutName(String workoutName);

    boolean create(LocalDate dateCreated, int duration);

    public void editWorkout(int workoutId, String workoutName, int exerciseId, int bodyGroupId, int sets, int reps, int duration);

    public void deleteWorkout(int workoutId);
}
