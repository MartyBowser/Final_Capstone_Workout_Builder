<template>
  <div >
      <div v-for="workout in $store.state.currentGenerated" v-bind:key="workout.workoutId">
      <h2 >{{workout.dateCreated}}</h2>
      </div>
      </div>
</template>



<script>
import workout from '../services/Workout.js';
export default {
    name: 'workout-record',
    
 created()
 {
     this.getWorkouts();
 },
 methods:
 {
     getWorkouts()
    {
        workout.listWorkoutsGenerated('2').then(response => {
            this.$store.commit("SET_CURRENTGENERATED", response.data)
        
        });

    }
 }
}
</script>

<style>

</style>