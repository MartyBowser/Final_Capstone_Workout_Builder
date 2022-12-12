<template>
  <div class="exercise-container">
      <div class="card">
          <label>Cardio</label>
          <input v-on:change="cardioSelected" type="checkbox" name="checkbox" id="cardio" v-bind:value="1" v-model="workoutRequests.selectedBodyGroups" />

      <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in cardioExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
  </div>
    <div class="card">
        <label>Back</label>
        <input v-on:change="backSelected" type="checkbox" name="checkbox" id="back" v-bind:value="2" v-model="workoutRequests.selectedBodyGroups"/>
    <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in backExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
    </div>
    
  <div class="card">
      <label>Legs</label>
      <input v-on:change="legsSelected" type="checkbox" name="checkbox" id = "legs" v-bind:value="3" v-model="workoutRequests.selectedBodyGroups"/>
      <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in legsExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
  </div>
    <div class="card">
        <label>Arms</label>
        <input v-on:change="armsSelected" type="checkbox" name="checkbox" id= "arms" v-bind:value="4" v-model="workoutRequests.selectedBodyGroups"/>
      <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in armsExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
  </div>
  <div class="card">
      <label>Abs</label>
      <input v-on:change="absSelected" type="checkbox" name="checkbox" id= "abs" v-bind:value="5" v-model="workoutRequests.selectedBodyGroups"/>
      <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in absExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
  </div>
<div class="card">
      <label>Full Body</label>
     <input v-on:change="fullbodySelected" type="checkbox" name="checkbox" id="full-body" v-bind:value="6" v-model="workoutRequests.selectedBodyGroups"/>
      <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in fullbodyExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
  </div>
  <select  required  class="Form-WorkoutTime" v-model="workoutRequests.timeNeeded">
<option selected value="0">Select Work Length</option>

    <option value="1">15 Minutes</option>
    <option value="2">30 Minutes</option>
    <option value="3">45 Minutes</option>
    <option value="4">60 Minutes</option>
    </select>
  </div>
  
</template>

<script>
import ExerciseCard from './ExerciseCard.vue'
import exercise from "../services/Exercise.js";


export default {

    data()
    {
       return {
           exerciseSelectedCardio: false,
           exerciseSelectedBack: false,
           exerciseSelectedLegs: false,
           exerciseSelectedArms: false,
           exerciseSelectedAbs: false,
           exerciseSelectedFullBody: false,
           selectedWorkouts:[],
           workoutRequests:{
               selectedBodyGroups:[],
               timeNeeded:'0'
           } 
        }

    },
    computed: {
      cardioExercise() {
          return this.$store.state.exercises.filter(
              (exercise) => {
                  return (exercise.bodyGroupId == 1) 
              }
          )

      },

      backExercise() {
          return this.$store.state.exercises.filter(
              (exercise) => {
                  return (exercise.bodyGroupId == 2) 
              }
          )

      },
    legsExercise() {
          return this.$store.state.exercises.filter(
              (exercise) => {
                  return (exercise.bodyGroupId == 3) 
              }
          )

      },
      armsExercise() {
          return this.$store.state.exercises.filter(
              (exercise) => {
                  return (exercise.bodyGroupId == 4) 
              }
          )

      },
    absExercise() {
          return this.$store.state.exercises.filter(
              (exercise) => {
                  return (exercise.bodyGroupId == 5) 
              }
          )

      },
        fullbodyExercise() {
          return this.$store.state.exercises.filter(
              (exercise) => {
                  return (exercise.bodyGroupId == 6) 
              }
          )

      },

    },


    name: 'exercise-list',
    components: {
      ExerciseCard
    },
    created(){
this.getExercises();

}, 
methods:
{
    getExercises()
    {
        exercise.listExercise().then(response => {
            this.$store.commit("SET_EXERCISE", response.data)
        
        });

    },
    cardioSelected()
    {
        if(document.getElementById("cardio").checked)
           {
               this.exerciseSelectedCardio = true;
           }
           else
           {
               this.exerciseSelectedCardio = false;
           }

    },
    backSelected()
    {
        if(document.getElementById("back").checked)
           {
               this.exerciseSelectedBack = true;
           }
           else
           {
               this.exerciseSelectedBack = false;
           }

    },
    legsSelected()
    {
        if(document.getElementById("legs").checked)
           {
               this.exerciseSelectedLegs = true;
           }
           else
           {
               this.exerciseSelectedLegs = false;
           }

    },
    armsSelected()
    {
        if(document.getElementById("arms").checked)
           {
               this.exerciseSelectedArms = true;
           }
           else
           {
               this.exerciseSelectedArms = false;
           }

    },
    absSelected()
    {
        if(document.getElementById("abs").checked)
           {
               this.exerciseSelectedArms = true;
           }
           else
           {
               this.exerciseSelectedArms = false;
           }

    },
    fullbodySelected()
    {
        if(document.getElementById("full-body").checked)
           {
               this.exerciseSelectedFullBody = true;
           }
           else
           {
               this.exerciseSelectedFullBody = false;
           }

    },
}
}

</script>

<style>
.exercise-container {
    display:flex;
    justify-content:space-between;
    justify-content: space-evenly;
    flex-wrap: nowrap;
    overflow-x: auto;
   -webkit-overflow-scrolling: touch;
    padding-left: 200px;
    margin:auto;
   
}


</style>