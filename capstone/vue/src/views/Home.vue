<template>
  <div class="home">
    <h1>Hi {{$store.state.user.firstName}} </h1>
    <p>New Workout</p>
    <p>History/Progress</p>
    <p>Not sure what to do? Connect with one of our many trainers here.</p>
     <button class="form-button" v-on:click="createExercise">
        Create Exercise
      </button>
      <button class="form-button" v-on:click="addTrainer">
        Add Trainer
      </button>
  </div>
</template>

<script>
export default {
  name: "home",
  methods: {createExercise()
  {this.$router.push('/exercise')},
  addTrainer(){
    this.$router.push('/addtrainer')
    

  },
  }

};
</script>
