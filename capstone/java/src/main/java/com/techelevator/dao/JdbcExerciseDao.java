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
    public boolean create(String exerciseName, String description, int bodyGroupId) {
        String insertUserSql = "insert into exercise (exerciseName,description,bodyGroupId) values (?,?,?)";

        return jdbcTemplate.update(insertUserSql, exerciseName, description, bodyGroupId) == 1;
    }

    private Exercise mapRowToExercise(SqlRowSet rs) {
        Exercise exercise = new Exercise();
        exercise.setExerciseId(rs.getInt("exercise_id"));
        exercise.setExerciseName(rs.getString("exercise_name"));
        exercise.setDescription(rs.getString("description"));
        exercise.setBodyGroupId(rs.getInt("body_group_id"));
        return exercise;
    }
}
