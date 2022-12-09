<template >

  <div class="home" >
    <h1>Hi, {{$store.state.user.firstName}}! </h1>
    
    <p class="welcome">Health is a state of body. Wellness is a state of being. Key2Fit is here to guide you into positive wellness. </p>
    <p class="welcome">Start today with individual exercises, or build your own custom workout routine.
    </p>

    <!-- the 2 buttons bellow need to route to new workout and to workout history, they are NOT routed yet-->
    <button v-show="isUser" class="form-button-start-workout" v-on:click="createExercise">
        Start New Workout
      </button>
      <button v-show="isUser" class="form-button-history" v-on:click="createExercise">
        Your Workout History
      </button>
    <exercise-list />
     <button v-show="isUser" class="form-button-create-exercise" v-on:click="createExercise">
        Create Exercise
      </button>
      <button v-show="isUser" class="form-button-add-trainer" v-on:click="addTrainer">
        Add Trainer
      </button>

      <img class="home-page-logo" src="https://freesvg.org/img/1545424155.png">
       
  </div>
</template>

<script>
//import Exercise from '../components/Exercise.vue'
import ExerciseList from '../components/ExerciseList.vue'
export default {
  components: {  ExerciseList },
/**data(){
  return{
    items:["1","2"]
  }
},*/
  name: "home",
  methods: {createExercise()
  {this.$router.push('/exercise')
  },
  addTrainer(){
    this.$router.push('/addtrainer')
  }
  
  },
  computed:
  {
isUser(){
    if(this.$store.state.user.authorities[0].name==="ROLE_USER")
    {return false }
    else{
      return true}
    }
  }
};
</script>
