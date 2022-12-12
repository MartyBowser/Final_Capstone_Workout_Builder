package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcWorkoutDao implements WorkoutDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcWorkoutDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByWorkoutName(String workoutName) {
        if (workoutName == null) throw new IllegalArgumentException("workout name cannot be null");

        int workoutId;
        try {
            workoutId = jdbcTemplate.queryForObject("select workout_id from workout where workout_name = ?", int.class, workoutName);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Workout " + workoutName + " was not found.");
        }

        return workoutId;
    }

    @Override
    public  Workout getWorkoutById(int workoutId) {
        String sql = "SELECT * FROM workout WHERE workout_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workoutId);
        if (results.next()) {
            return mapRowToWorkout(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Workout> findAll() {
        List<Workout> workouts = new ArrayList<>();
        String sql = "select * from workout";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Workout workout = mapRowToWorkout(results);
            workouts.add(workout);
        }

        return workouts;
    }

    @Override
    public Workout findWorkoutByName(String workoutName) {
        if (workoutName == null) throw new IllegalArgumentException("Workout name cannot be null");

        for (Workout workout : this.findAll()) {
            if (workout.getWorkoutName().equalsIgnoreCase(workoutName)) {
                return workout;
            }
        }
        throw new UsernameNotFoundException("Workout " + workoutName + " was not found.");
    }

    @Override
    public boolean create(LocalDate dateCreated, int duration) {
        String insertUserSql = "insert into workout (date_created, duration) values (?,?)";

        return jdbcTemplate.update(insertUserSql, dateCreated, duration) == 1;
    }

    @Override
    public void editWorkout(int workoutId, String workoutName, int exerciseId, int bodyGroupId, int sets, int reps, int duration) {
        String insertUserSql = "UPDATE workout SET workout_name = ?, exercise_id = ?, body_group_id = ?, sets = ?, reps = ?, duration = ?"  +
                "WHERE workout_id = ?";

        jdbcTemplate.update(insertUserSql, workoutName, exerciseId, bodyGroupId, sets, reps, duration);
    }

    @Override
    public void deleteWorkout(int workoutId) {
        String deleteUserSql = "DELETE from workout Where workout_id = ? ";

        jdbcTemplate.update(deleteUserSql, workoutId);
    }



    private Workout mapRowToWorkout(SqlRowSet rs) {
        Workout workout = new Workout();
        workout.setWorkoutId(rs.getInt("workout_id"));
        workout.setExerciseId(rs.getInt("exercise_id"));
        workout.setWorkoutName(rs.getString("workout_name"));
        workout.setBodyGroupId(rs.getInt("body_group_id"));
        workout.setSets(rs.getInt("sets"));
        workout.setReps(rs.getInt("reps"));
        workout.setDuration(rs.getInt("duration"));
        return workout;
    }
}
