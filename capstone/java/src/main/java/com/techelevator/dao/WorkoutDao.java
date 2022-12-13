package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;

import java.time.LocalDate;
import java.util.List;

public interface WorkoutDao {
    List<Workout> findAll();

    Workout getWorkoutById(int workoutId);

   // Workout findWorkoutByName(String workoutName);

    //int findIdByWorkoutName(String workoutName);

    int create(LocalDate dateCreated, int duration);

    public void editWorkout(int workoutId, boolean completed, int duration);

    public void deleteWorkout(int workoutId);

    boolean createWorkoutIdBodyGroupId(int workoutId, int bodyGroupId);

    boolean createWorkoutExercise(int workoutId, int exerciseId);
}
