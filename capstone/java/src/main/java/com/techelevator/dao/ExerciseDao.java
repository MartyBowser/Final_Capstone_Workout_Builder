package com.techelevator.dao;

import com.techelevator.model.Exercise;

import java.util.List;

public interface ExerciseDao {
    List<Exercise> findAll();

    Exercise getExerciseById(int exerciseId);

    Exercise findExerciseByName(String exerciseName);

    int findIdByExerciseName(String exerciseName);

    boolean create(String exerciseName, String description, int bodyGroupId, int userId);

    public void editExercise(String exerciseName, String description, int bodyGroupId, int exerciseId);

    public void deleteExercise(int exerciseId);
}
