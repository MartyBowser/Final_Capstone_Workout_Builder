package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.dao.ExerciseDao;
import com.techelevator.dao.WorkoutDao;
import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ExcerciseController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDao userDao;
    private ExerciseDao exerciseDao;
    private WorkoutDao workoutDao;

    public ExcerciseController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, ExerciseDao exerciseDao, WorkoutDao workoutDao, UserDao userDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.exerciseDao = exerciseDao;
        this.workoutDao = workoutDao;
        this.userDao = userDao;
    }


    @RequestMapping(value = "/exercise", method = RequestMethod.POST)
    public void createExercise(@Valid @RequestBody Exercise newExercise) {
        try {
            Exercise exercise = exerciseDao.findExerciseByName(newExercise.getExerciseName());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exercise Already Exists.");
        } catch (Exception e) {
            exerciseDao.create(newExercise.getExerciseName(), newExercise.getDescription(), newExercise.getBodyGroupId(), newExercise.getUserId(), newExercise.getExpectedTime(), newExercise.getSuggestedWeight(), newExercise.getNumberOfReps());
        }
    }

    @RequestMapping(value = "/exercise", method = RequestMethod.GET)
    public List<Exercise> getExercise() {
        List<Exercise> listOfExercise = new ArrayList<>();

        listOfExercise = exerciseDao.findAll();
        return listOfExercise;
    }

    @RequestMapping(value = "/exercise/{exerciseId}", method = RequestMethod.GET)
    public Exercise getExerciseById(int exerciseId) {
        Exercise exercise = new Exercise();

        exercise = exerciseDao.getExerciseById(exerciseId);
        return exercise;
    }
    @RequestMapping(value = "/getworkout", method = RequestMethod.POST)
    public List<Exercise> getGeneratedExercise(@RequestBody WorkoutRequests workoutRequests, Principal principal) {
        List<Exercise> listOfExercise = new ArrayList<>();

        listOfExercise = exerciseDao.findAllGenerate(workoutRequests.getSelectedBodyGroups(), workoutRequests.getTotalTime());

        int workoutId = workoutDao.create(LocalDate.now(), workoutRequests.getTotalTime(), userDao.findIdByUsername(principal.getName()));
        for(int i = 0; i< listOfExercise.size(); i++){
            workoutDao.createWorkoutExercise(workoutId, listOfExercise.get(i).getExerciseId());
        }
        for(int i = 0; i< listOfExercise.size(); i++){
            workoutDao.createWorkoutIdBodyGroupId(workoutId, listOfExercise.get(i).getBodyGroupId());
        }

            return listOfExercise;
    }



    //check if it already exists
    @RequestMapping(value = "/exercise", method = RequestMethod.PUT)
    public void editExercise(@Valid @RequestBody Exercise editingExercise) {
        exerciseDao.editExercise(editingExercise.getExerciseName(), editingExercise.getDescription(), editingExercise.getBodyGroupId(), editingExercise.getExerciseId(), editingExercise.getExpectedTime(), editingExercise.getSuggestedWeight(), editingExercise.getNumberOfReps());
    }

    @RequestMapping(value = "/exercise/{exerciseId}", method = RequestMethod.DELETE)
    public void deleteExercise(@PathVariable int exerciseId) {
        exerciseDao.deleteExercise(exerciseId);
    }


}
