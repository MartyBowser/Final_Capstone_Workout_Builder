package com.techelevator.dao;

import com.techelevator.model.Completion;
import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;

import java.time.LocalDate;
import java.util.List;

public interface WorkoutDao {
    List<Workout> findAll();

    Workout getWorkoutById(int workoutId);

   // Workout findWorkoutByName(String workoutName);

    //int findIdByWorkoutName(String workoutName);
    List<Workout> getGeneratedWorkoutsByUserId(int workoutId, boolean completed);

    List<Workout> getExerciseInWorkout(int workoutId);

    int create(LocalDate dateCreated, int duration, int userId);

    void editWorkout(int workoutId, boolean completed, int duration);

    void deleteWorkout(int workoutId);

    boolean createWorkoutIdBodyGroupId(int workoutId, int bodyGroupId);

    boolean createWorkoutExercise(int workoutId, int exerciseId);

    void addCompletion();

    int findCompletionCount();
}
