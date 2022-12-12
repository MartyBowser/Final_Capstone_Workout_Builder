package com.techelevator.dao;

import com.techelevator.model.Exercise;

import java.util.List;

public interface ExerciseDao {
    List<Exercise> findAll();

    Exercise getExerciseById(int exerciseId);

    Exercise findExerciseByName(String exerciseName);

    int findIdByExerciseName(String exerciseName);

    boolean create(String exerciseName, String description, int bodyGroupId, int userId, int expectedTime, int suggestedWeight, int numberOfReps);

    public void editExercise(String exerciseName, String description, int bodyGroupId, int exerciseId, int expectedTime, int suggestedWeight, int numberOfReps);

    public void deleteExercise(int exerciseId);

    List<Exercise> findAllGenerate(int[] ids, int timeNeeded);
}
