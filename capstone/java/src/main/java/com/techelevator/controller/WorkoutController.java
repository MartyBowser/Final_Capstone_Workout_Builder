package com.techelevator.controller;

import com.techelevator.dao.ExerciseDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.WorkoutDao;
import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin
public class WorkoutController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private WorkoutDao workoutDao;
    

    public WorkoutController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, ExerciseDao exerciseDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.workoutDao = workoutDao;
    }


    @RequestMapping(value = "/workout", method = RequestMethod.POST)
    public void createWorkout(@Valid @RequestBody Workout newWorkout) {
        try {
            Workout workout= workoutDao.findWorkoutByName(newWorkout.getWorkoutName());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Workout Already Exists.");
        } catch (Exception e) {
            workoutDao.create(newWorkout.getWorkoutName(), newWorkout.getExerciseId(), newWorkout.getBodyGroupId(), newWorkout.getSets(), newWorkout.getReps(), newWorkout.getDuration());
        }
    }

    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public List<Workout> getWorkout() {
        List<Workout> listOfWorkout = new ArrayList<>();

        listOfWorkout = workoutDao.findAll();
        return listOfWorkout;
    }

    //check if it already exists
    @RequestMapping(value = "/Workout", method = RequestMethod.PUT)
    public void editWorkout(@Valid @RequestBody Workout editingWorkout) {
        workoutDao.editWorkout(editingWorkout.getWorkoutId(), editingWorkout.getWorkoutName(), editingWorkout.getExerciseId(), editingWorkout.getBodyGroupId(), editingWorkout.getSets(),editingWorkout.getReps(), editingWorkout.getDuration());
    }
    @RequestMapping(value = "/workout/{workoutId}", method = RequestMethod.DELETE)
    public void deleteWorkout(@PathVariable int workoutId) {
        workoutDao.deleteWorkout(workoutId);
    }

}
