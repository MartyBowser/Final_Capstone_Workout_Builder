package com.techelevator.controller;

import com.techelevator.dao.ExerciseDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.WorkoutDao;
import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin
public class WorkoutController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private WorkoutDao workoutDao;
    private UserDao userDao;
    private ExerciseDao exerciseDao;
    

    public WorkoutController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, ExerciseDao exerciseDao, WorkoutDao workoutDao, UserDao userDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.workoutDao = workoutDao;
        this.userDao = userDao;
        this.exerciseDao = exerciseDao;
    }


    @RequestMapping(value = "/workout", method = RequestMethod.POST)
    public void createWorkout(@Valid @RequestBody Workout newWorkout, Principal principal) {

        try {
            Workout workout= workoutDao.getWorkoutById(newWorkout.getWorkoutId());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Workout Already Exists.");
        } catch (Exception e) {


            workoutDao.create(newWorkout.getDateCreated(), newWorkout.getDuration(), userDao.findIdByUsername(principal.getName()));
       }
    }

    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public List<Workout> getWorkout() {
        List<Workout> listOfWorkout = new ArrayList<>();

        listOfWorkout = workoutDao.findAll();
        return listOfWorkout;
    }

    @RequestMapping(value = "/workout/{workoutId}", method = RequestMethod.GET)
    public List<Integer> getExercisesByWorkoutId(@PathVariable int workoutId) {
        List<Integer> listOfExercise = new ArrayList<>();

        listOfExercise = exerciseDao.getExercisesByWorkoutId(workoutId);

        return listOfExercise;
    }

  
    @RequestMapping(value = "/Workout", method = RequestMethod.PUT)
    public void editWorkout(@Valid @RequestBody Workout editWorkoutIn) {
        workoutDao.editWorkout(editWorkoutIn.getWorkoutId(), editWorkoutIn.isCompleted(), editWorkoutIn.getDuration());
    }
    @RequestMapping(value = "/workout/{workoutId}", method = RequestMethod.DELETE)
    public void deleteWorkout(@PathVariable int workoutId) {
        workoutDao.deleteWorkout(workoutId);
    }

    @RequestMapping(value = "/workoutsGenerated/{userId}", method = RequestMethod.GET)
    public  List<Workout> getWorkoutsGenerated(@PathVariable int userId) {

        List<Workout> listOfWorkout = new ArrayList<>();
        listOfWorkout = workoutDao.getGeneratedWorkoutsByUserId(userId);
        return listOfWorkout;
    }

}
