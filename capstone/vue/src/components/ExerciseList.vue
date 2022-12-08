<template>
  <div class="exercise-container">
      <exercise-card v-for="exercise in $store.state.exercises"
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card>
  </div>
</template>

<script>
import ExerciseCard from './ExerciseCard.vue'
import exercise from "../services/Exercise.js";


export default {
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
}
</style>