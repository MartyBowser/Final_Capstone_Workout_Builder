package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkoutDao implements WorkoutDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcWorkoutDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /*
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

     */
       @Override
        public boolean createWorkoutIdBodyGroupId(int workoutId, int bodyGroupId){
           String insertUserSql = "INSERT INTO workout_body_group (workout_id, body_group_id) VALUES (?, ?);";

           return jdbcTemplate.update(insertUserSql, workoutId, bodyGroupId) == 1;
       }

       @Override
       public boolean createWorkoutExercise(int workoutId, int exerciseId){
           String insertUserSql = "INSERT INTO workout_exercise (workout_id, exercise_id) VALUES (?, ?)";

           return jdbcTemplate.update(insertUserSql, workoutId, exerciseId) == 1;
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
    public  List<Workout> getGeneratedWorkoutsByUserId(int userId) {
                  List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT * FROM workout WHERE user_id = ? AND completed = false";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Workout workout = mapRowToWorkout(results);
            workouts.add(workout);
        }
        return workouts;
    }
    @Override
    public  List<Workout> getExerciseInWorkout(int workoutId) {
           List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT exercise FROM workout_exercise WHERE workout_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workoutId);
        while (results.next()) {
            Workout workout = mapRowToWorkout(results);
            workouts.add(workout);
        }
        return workouts;
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

    /*
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

     */

    @Override
    public int create(LocalDate dateCreated, int duration, int userId) {
        String insertUserSql = "insert into workout (completed, date_created, duration, user_id) values (false,?,?, ?) returning workout_id";

        return jdbcTemplate.queryForObject(insertUserSql, int.class, dateCreated, duration, userId );
    }

    @Override
    public void editWorkout(int workoutId, boolean completed, int duration) {
        String insertUserSql = "UPDATE workout SET workout_name = ?, exercise_id = ?, body_group_id = ?, completed = ?, duration = ?"  +
                "WHERE workout_id = ?";

        jdbcTemplate.update(insertUserSql, completed, duration);
    }

    @Override
    public void deleteWorkout(int workoutId) {
        String deleteUserSql = "DELETE from workout Where workout_id = ? ";

        jdbcTemplate.update(deleteUserSql, workoutId);
    }



    private Workout mapRowToWorkout(SqlRowSet rs) {
        Workout workout = new Workout();
        workout.setWorkoutId(rs.getInt("workout_id"));
        workout.setCompleted(rs.getBoolean("completed"));
        workout.setDuration(rs.getInt("duration"));
        LocalDate createdDate = rs.getDate("date_created").toLocalDate();
        workout.setDateCreated(createdDate);
        return workout;
    }
}
