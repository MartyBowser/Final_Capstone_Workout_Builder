<template>
  <div >
      <div v-for="workout in $store.state.currentGenerated" v-bind:key="workout.workoutId">
      <a>Created Date: {{workout.dateCreated}}   Duration: {{workout.duration}}</a>
      
      <button>Mark Completed</button>
      </div>     
      </div>
</template>



<script>
import workout from '../services/Workout.js';
export default {
    data()
    {
        return{
            editWorkout:
            {
                workoutId:'',
                duration:'',
                dateCreated:'',
                userId:this.workout.userId,
                completed:''


            }
        }
    },

    name: 'workout-record',
    
 created()
 {
     this.getWorkouts();
 },
 methods:
 {
     getWorkouts()
    {
        workout.listWorkoutsGenerated(this.$store.state.user.id).then(response => {
            this.$store.commit("SET_CURRENTGENERATED", response.data)
        
        });

    },
    update(workout)
    {
        this.editWorkout.workoutId = workout.workoutId;
        this.editWorkout.duration = workout.duration;
        this.editWorkout.dateCreated = workout.dateCreated;
        this.editWorkout.completed = true;    
        
        workout.editWorkout(this.editWorkout).then((response) => {
              if (response.status == 200) {
                  this.getWorkouts();
                 /* this.$router.push({
                      path: '/',
                      query: {edit: 'success'}
                  })*/
              }
          })
    }
 }
}
</script>

<style>

</style>