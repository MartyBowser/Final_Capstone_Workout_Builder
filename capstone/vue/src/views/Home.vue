<template>
  <div class="home">
    <h1>Hi {{$store.state.user.firstName}} </h1>
    <p>New Workout</p>
    <p>History/Progress</p>
    <p>Submitted exercises to go here<p>
      <li v-for="(item, index) in items" v-bind:key="index"> 
        {{item}} {{index}}
        </li>
    <p>Not sure what to do? Connect with one of our many trainers here.</p>

    <exercise/>
    
     <button v-show="isUser" class="form-button" v-on:click="createExercise">
        Create Exercise
      </button>
      <button v-show="isUser" class="form-button" v-on:click="addTrainer">
        Add Trainer
      </button>
  </div>
</template>

<script>

import Exercise from '../components/Exercise.vue'
export default {
  components: { Exercise },
data(){
  return{
    items:["1","2"]
  }
},
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
