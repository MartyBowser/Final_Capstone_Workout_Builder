<template>
  <div class="details-exercise">
      <exercise-card-full v-bind:exercise="exercise" />
  </div>
</template>

<script>
import ExerciseCardFull from '../components/ExerciseCardFull.vue'

export default {
  components: { ExerciseCardFull },
  computed: {
      exercise() {
      return this.$store.state.exercises.find(
          (exercise) => {
      return exercise.exerciseId === this.$route.params.id

      }
      )
      }
  }
}
</script>
<style>
</style>