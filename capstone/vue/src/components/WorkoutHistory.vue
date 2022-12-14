<template>
  <div >
      <div v-for="currentWorkout in $store.state.currentHistory" v-bind:key="currentWorkout.workoutId">
      <a>Created Date: {{currentWorkout.dateCreated}}   Duration: {{currentWorkout.duration}} </a>
       
       <a v-on:click.prevent="viewExercises(currentWorkout.workoutId)" href="#">View Exercises</a>

       <div v-if="currentWorkout.workoutId === selectedWorkoutId"><div v-for="exercise in selectedExercises" v-bind:key="exercise.exerciseId">{{exercise.exerciseName}}  Number Of Reps:{{exercise.numberOfReps}}  </div></div>
      <button v-on:click.prevent="retakeWorkout(currentWorkout)">Move to Queue</button>
      </div>     
      </div>
</template>



<script>
import workout from '../services/Workout.js';
import exercise from '../services/Exercise.js'
export default {
    data()
    {
        return{
            editWorkout:
            {
                workoutId:'',
                duration:'',
                dateCreated:'',
                userId:'0',
                completed:''


            },
            selectedExercises:[],
            selectedWorkoutId:0
        }
    },

    name: 'workout-history',
    
 created()
 {
     this.getWorkouts();
 },
 methods:
 {
     retakeWorkout(currentWorkout)
     {
         currentWorkout.completed = false;
         workout.editWorkout(currentWorkout).then(response => {
             if(response.status == 200)
             {
                 this.getWorkouts();
             }
         })

     },
     getWorkouts()
    {
        workout.listWorkoutsGenerated(this.$store.state.user.id, true).then(response => {
            this.$store.commit("SET_CURRENTHISTORY", response.data)
        
        });

    },
    viewExercises(workoutId){

        this.selectedWorkoutId = workoutId;

    exercise.getExercisesFromWorkout(workoutId).then(response=> {
        if(response.status == 200)
        {
          this.selectedExercises = response.data;
        }

    })
        
    },
    update(workout)
    {
        this.editWorkout.workoutId = workout.workoutId;
        this.editWorkout.duration = workout.duration;
        this.editWorkout.dateCreated = workout.dateCreated;
        this.editWorkout.completed = false;
        this.editWorkout.userId = workout.userId;    
        
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