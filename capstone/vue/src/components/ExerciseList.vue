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

export default {
    name: 'exercise-list',
    components: {
      ExerciseCard
    }
}

</script>

<style>
.exercise-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: fixed;
    
}
</style>