<template>
  <div class="exercise-container">
      <router-link v-bind:to="{name:'exerciseDetail', params:{id:exercise.exerciseId}}" v-for="exercise in $store.state.exercises" v-bind:key="exercise.exerciseId" ><exercise-card 
            v-bind:key="exercise.exerciseId"
            v-bind:exercise="exercise"

      ></exercise-card></router-link>
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
    padding-left: 200px;
    margin: 100px;
}
</style>