<template>
  <div>
   <tbody>
          <tr v-for="exercise in $store.state.newGenerated" v-bind:key="exercise.exerciseId">
              <td>{{exercise.exerciseName}}</td>
              <td>{{exercise.description}}</td>
              <td>{{exercise.bodyGroupId}}</td>        
          </tr>        
      </tbody>
  </div>
</template>

<script>

export default {
    name:"generatedWorkout"

}
</script>

<style>

</style>