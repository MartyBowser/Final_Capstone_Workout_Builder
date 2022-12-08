<template>
  <div>
   <table>
       <thead>
        <tr>
          <th>Exercise</th>
          <th>Description</th>
          <th>Body Group</th>
        </tr>
      </thead>
      <tbody>
          <tr v-for="exercise in $store.state.exercises" v-bind:key="exercise.exerciseId">
              <td>{{exercise.exerciseName}}</td>
              <td>{{exercise.description}}</td>
              <td>{{exercise.bodyGroupId}}</td>        
          </tr>        
      </tbody>
   </table>
  </div>
</template>

<script>
import exercise from "../services/Exercise.js";
export default {
name: 'exercise',
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

</style>