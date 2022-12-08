package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.dao.ExerciseDao;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ExcerciseController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDao userDao;
    private ExerciseDao exerciseDao;

    public ExcerciseController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, ExerciseDao exerciseDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.exerciseDao = exerciseDao;
    }


    @RequestMapping(value = "/exercise", method = RequestMethod.POST)
    public void createExercise(@Valid @RequestBody Exercise newExercise) {
        try {
            Exercise exercise = exerciseDao.findExerciseByName(newExercise.getExerciseName());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exercise Already Exists.");
        } catch (Exception e) {
            exerciseDao.create(newExercise.getExerciseName(), newExercise.getDescription(), newExercise.getBodyGroupId(), newExercise.getUserId());
        }
    }

    @RequestMapping(value = "/exercise", method = RequestMethod.GET)
    public List<Exercise> getExercise() {
        List<Exercise> listOfExercise = new ArrayList<>();

        listOfExercise = exerciseDao.findAll();
        return listOfExercise;
    }

    //check if it already exists
    @RequestMapping(value = "/exercise", method = RequestMethod.PUT)
    public void editExercise(@Valid @RequestBody Exercise editingExercise) {
        exerciseDao.editExercise(editingExercise.getExerciseName(), editingExercise.getDescription(), editingExercise.getBodyGroupId(), editingExercise.getExerciseId());
    }

}
