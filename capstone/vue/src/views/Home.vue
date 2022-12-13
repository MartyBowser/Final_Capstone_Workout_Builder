<template >

  <div class="home" >
<<<<<<< HEAD
    <h1 class="user-greetings">Hi, {{$store.state.user.firstName}}! </h1>
=======
    <h1>Hi, {{$store.state.user.firstName}}! </h1>
   
>>>>>>> f3f47f5c97174374ab665adf2a80b09199a9f2db
    
    <p class="welcome">Health is a state of body. Wellness is a state of being. Key2Fit is here to guide you into positive wellness. Start today with individual exercises, or build your own custom workout routine.</p>
<div class="button-div">
     <!-- <p class="welcome">Please select your focus area and the time for workout.</p>
        <button disabled id="generate-workout" v-show="isUser||isTrainer||isAdmin" class="form-button-start-workout" v-on:click="createExercise">
        Generate Workout
      </button> -->
    
     <button v-show="isTrainer||isAdmin" class="form-button-create-exercise" v-on:click="createExercise">
        Create Exercise
      </button>
      <p> </p>
      <button v-show="isAdmin" class="form-button-add-trainer" v-on:click="addTrainer">
        Add Trainer
      </button>
      <p> </p>
      <button v-show="isUser||isTrainer||isAdmin" class="form-button-history" v-on:click="createExercise">
        Your Workout History
      </button>
      <p> </p>
       </div>
    <!-- the 2 buttons bellow need to route to new workout and to workout history, they are NOT routed yet-->

    <exercise-list class="exercise-list" />
   

      <!--<img class="home-page-logo" src="https://freesvg.org/img/1545424155.png"> -->
       
  </div>
</template>

<script>

import ExerciseList from '../components/ExerciseList.vue';

export default {
  components: {  ExerciseList },
  name: "home",
  methods: {
  createExercise()
  {this.$router.push('/exercise')
  },
  addTrainer(){
    this.$router.push('/addtrainer')
  },
    
  },
  computed:
  {
isUser(){
    if(this.$store.state.user.authorities[0].name==="ROLE_USER")
    {return true }
    else{
      return false}
    },
isTrainer(){
    if(this.$store.state.user.authorities[0].name==="ROLE_TRAINER")
    {return true }
    else{
      return false}
    }, 
isAdmin(){
    if(this.$store.state.user.authorities[0].name==="ROLE_ADMIN")
    {return true }
    else{
      return false}
    },     
    
  }
  
};
</script>
