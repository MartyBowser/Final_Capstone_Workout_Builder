<template>
  <div>
      {{$store.state.currentGenerated[0].exerciseName}}
      </div>
</template>

<script>
import workout from "../services/Workout.js"
export default {
name: 'workoutGen',
created(){
this.getWorkouts();

},
methods:
{
    getWorkouts()
    {
        workout.listWorkoutsGenerated(this.$store.state.user.userId).then(response => {
            this.$store.commit("SET_EXERCISE", response.data)
        
        });

    }
}

}
</script>

<style>

</style>