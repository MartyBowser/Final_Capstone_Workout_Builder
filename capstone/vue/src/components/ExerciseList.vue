<template>
  <div class="exercise-container">
      <div>
          <label>Cardio</label>
          <label><input type="checkbox" name="checkbox"></label>

      <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in cardioExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
  </div>
    <div>
        <label>Back</label>
        <label><input type="checkbox" name="checkbox"></label>
    <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in backExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
    </div>
    
  <div>
      <label>Legs</label>
      <label><input type="checkbox" name="checkbox"></label>
      <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in legsExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
  </div>
    <div>
        <label>Arms</label>
        <label><input type="checkbox" name="checkbox"></label>
      <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in armsExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
  </div>
  <div>
      <label>Abs</label>
      <label><input type="checkbox" name="checkbox"></label>
      <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in absExercise" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
  </div>

  </div>
</template>

<script>
import ExerciseCard from './ExerciseCard.vue'
import exercise from "../services/Exercise.js";


export default {
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

    }
}
}

</script>

<style>
.exercise-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: nowrap;
    overflow-x: auto;
   -webkit-overflow-scrolling: touch;
    padding-left: 200px;
    margin: 100px;
}
</style>