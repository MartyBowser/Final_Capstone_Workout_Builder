<template>
  <div class="pending-workout">
      <p>Good luck!!! {{$store.state.currentGenerated.length}} Workouts in your queue</p>
      <div v-for="currentWorkout in $store.state.currentGenerated" v-bind:key="currentWorkout.workoutId">
      <a>Created Date: {{currentWorkout.dateCreated}}   Duration: {{currentWorkout.duration}} </a>
       
       <a class= "view-ex-button" v-on:click.prevent="viewExercises(currentWorkout.workoutId)" href="#">View Exercises
     </a>

       <div v-if="currentWorkout.workoutId === selectedWorkoutId"><div v-for="exercise in selectedExercises" v-bind:key="exercise.exerciseId">{{exercise.exerciseName}}  Number Of Reps:{{exercise.numberOfReps}}  </div></div>
      <button class="workout-record-button" v-on:click.prevent="markWorkoutCompleted(currentWorkout)">Mark Completed</button>
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
            selectedWorkoutId:0,
            
        }
    },

    name: 'workout-record',
    
 created()
 {
     this.getWorkouts();
 },
 methods:
 {
     markWorkoutCompleted(currentWorkout)
     {
         currentWorkout.completed = true;
         workout.editWorkout(currentWorkout).then(response => {
             if(response.status == 200)
             {
                 this.getWorkouts();
                 workout.addCompletion().then( response =>{

                     if(response.status == 200)
                     {
                         workout.findCompletionCount().then(response =>{
                          if(response.status == 200)
                          {
                         this.$store.commit("SET_COMPLETEDCOUNT", response.data)
                         }
                          })
                     }
                 })
                 
                 
             }
         })

     },
     getWorkouts()
    {
        workout.listWorkoutsGenerated(this.$store.state.user.id, false).then(response => {
            this.$store.commit("SET_CURRENTGENERATED", response.data)
        
        });
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
        this.editWorkout.completed = true;
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