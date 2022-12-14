package com.techelevator.dao;

import com.techelevator.model.Exercise;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcExerciseDao implements ExerciseDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcExerciseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByExerciseName(String exerciseName) {
        if (exerciseName == null) throw new IllegalArgumentException("Exercise name cannot be null");

        int exerciseId;
        try {
            exerciseId = jdbcTemplate.queryForObject("select exercise_id from exercise where exercise_name = ?", int.class, exerciseName);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Exercise " + exerciseName + " was not found.");
        }

        return exerciseId;
    }

    @Override
    public Exercise getExerciseById(int exerciseId) {
        String sql = "SELECT * FROM exercise WHERE exercise_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, exerciseId);
        if (results.next()) {
            return mapRowToExercise(results);
        } else {
            return null;
        }
    }
    @Override
    public List<Exercise> getExercisesByWorkoutId(int workoutId) {
        List<Exercise> exercises = new ArrayList<>();
        String sql = "SELECT * FROM exercise\n" +
                "JOIN workout_exercise ON workout_exercise.exercise_id = exercise.exercise_id\n" +
                "WHERE workout_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workoutId);
        while (results.next()) {
            exercises.add(mapRowToExercise(results));
          }
        return exercises;
        }

    @Override
    public List<Exercise> findAll() {
        List<Exercise> exercises = new ArrayList<>();
        String sql = "select * from exercise";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Exercise exercise = mapRowToExercise(results);
            exercises.add(exercise);
        }

        return exercises;
    }

    @Override
    public List<Exercise> findAllGenerate(int[] ids, int timeNeeded)
    {
      ArrayList<ArrayList<Exercise>> generatedList = new ArrayList<>();

       ArrayList<Exercise> exercises = new ArrayList<>();

        for(int i = 0; i < ids.length; i++)
        {
            String sql = "select * from exercise where body_group_id = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ids[i]);
            while (results.next()) {
                Exercise exercise = mapRowToExercise(results);
                exercises.add(exercise);

            }
            generatedList.add(exercises);
            exercises = new ArrayList<>();
        }

        ArrayList<Exercise> newexercises = new ArrayList<>();

        for(int i = 0; i < generatedList.size(); i++) {
            newexercises.add(generatedList.get(i).get(1));
        }
        return newexercises;
    }

    @Override
    public Exercise findExerciseByName(String exerciseName) {
        if (exerciseName == null) throw new IllegalArgumentException("Exercise name cannot be null");

        for (Exercise exercise : this.findAll()) {
            if (exercise.getExerciseName().equalsIgnoreCase(exerciseName)) {
                return exercise;
            }
        }
        throw new UsernameNotFoundException("Exercise " + exerciseName + " was not found.");
    }

    @Override
    public boolean create(String exerciseName, String description, int bodyGroupId, int userId, int expectedTime, int suggestedWeight, int numberOfReps) {
        String insertUserSql = "insert into exercise (exercise_name,description,body_group_id,user_id,expected_time,suggested_weight,number_of_reps) values (?,?,?,?,?,?,?)";

        return jdbcTemplate.update(insertUserSql, exerciseName, description, bodyGroupId, userId, expectedTime, suggestedWeight, numberOfReps) == 1;
    }

    @Override
    public void editExercise(String exerciseName, String description, int bodyGroupId, int exerciseId, int expectedTime, int suggestedWeight, int numberOfReps) {
        String insertUserSql = "UPDATE exercise SET exercise_name = ?, description = ?, body_group_id = ?, expected_time = ?, suggested_weight = ?, number_of_reps = ?" +
                "WHERE exercise_id = ?";

        jdbcTemplate.update(insertUserSql, exerciseName, description, bodyGroupId, exerciseId, expectedTime, suggestedWeight, numberOfReps);
    }

    @Override
    public void deleteExercise(int exerciseId) {
        String deleteUserSql = "DELETE from exercise Where exercise_id = ? ";

        jdbcTemplate.update(deleteUserSql, exerciseId);
    }



    private Exercise mapRowToExercise(SqlRowSet rs) {
        Exercise exercise = new Exercise();
        exercise.setExerciseId(rs.getInt("exercise_id"));
        exercise.setExerciseName(rs.getString("exercise_name"));
        exercise.setDescription(rs.getString("description"));
        exercise.setBodyGroupId(rs.getInt("body_group_id"));
        exercise.setUserId(rs.getInt("user_id"));
        exercise.setExpectedTime(rs.getInt("expected_time"));
        exercise.setSuggestedWeight(rs.getInt("suggested_weight"));
        exercise.setNumberOfReps(rs.getInt("number_of_reps"));
        return exercise;
    }
}
