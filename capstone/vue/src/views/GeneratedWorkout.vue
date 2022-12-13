<template>
  <div>
        <exercise-card-full v-for="exercise in $store.state.newGenerated" v-bind:key="exercise.exerciseId" v-bind:exercise="exercise"/>
  </div>
</template>



<script>
import ExerciseCardFull from '../components/ExerciseCardFull.vue'
export default {
    components: { ExerciseCardFull },
    name:"generatedWorkout"

}
</script>

<style>

</style>