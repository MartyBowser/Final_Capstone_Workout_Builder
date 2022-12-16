<template>
<div>
  <div class="card-full">
    <h2 class="exercise-title">{{ exercise.exerciseName }}</h2>
    <h3 class="exercise-description">{{ exercise.description }}</h3>
    <h3 class="exercise-expected-time">Time: {{ exercise.expectedTime }} Mins</h3>
    <h3 class="exercise-suggested-time">Weight: {{ exercise.suggestedWeight }} lbs</h3>
    <h3 class="exercise-number-of-reps"># of Reps: {{ exercise.numberOfReps}}</h3>
    
    <!-- 
    <button v-on:click="markRead(true)" v-if="!book.read" class="mark-read">Mark Read</button>
    <button v-on:click="markRead(false)" v-if="book.read" class="mark-unread">Mark Unread</button> -->

    <form
      v-if="showForm === true"
      class="formCreateExercise"
      @submit.prevent="update"
    >
      <h1 class="h3 mb-3 font-weight-normal">Edit Exercise</h1>
      <div class="alert alert-danger" role="alert" v-if="CreationError">
        {{ CreationErrorMsg }}
      </div>

      <input
        type="text"
        id="Exercise"
        class="form-control"
        v-bind:placeholder="exercise.exerciseName"
        v-model="editingExercise.exerciseName"
        required
      />
      <input
        type="text"
        id="description"
        class="form-control"
        v-bind:placeholder="exercise.description"
        v-model="editingExercise.description"
        required
      />
        <input
        type="number"
        id="expected-time"
        class="form-control"
        v-bind:placeholder="exercise.expectedTime"
        v-model="editingExercise.expectedTime"
        required
      />
        <input
        type="number"
        id="suggested-weight"
        class="form-control"
        v-bind:placeholder="exercise.suggestedWeight"
        v-model="editingExercise.suggestedWeight"
        required
      />
 <input
        type="number"
        id="reps"
        class="form-control"
        v-bind:placeholder="exercise.numberOfReps"
        v-model="editingExercise.numberOfReps"
        required
      />


      <select
        required
        class="form-control"
        v-model="editingExercise.bodyGroupId"
        placeholder="Select muscle group"
      >
        <option selected value="0">Select muscle group focus</option>

        <option value="1">Cardio</option>
        <option value="2">Back</option>
        <option value="3">Leg</option>
        <option value="4">Arms</option>
        <option value="5">Abs</option>
      </select>

      <button class="form-button" type="submit">Submit</button>
      
    </form>
    <button v-show="isCanEdit" v-on:click="deleteExercise" class="delete-exercise" >Delete Exercise</button>
    <p> </p>
    <a class = "edit-button-exercise" href="#" v-show="isCanEdit" v-on:click.prevent="showForm = !showForm">{{
      showForm ? "Cancel Edits" : "Edit Exercise"
    }}</a>
  </div>
  </div>
</template>

<script>

import exercise from '../services/Exercise.js';
export default {
    name: 'exercise-card-full',
    props: ["exercise"],

      data() {
    return {
      editingExercise: {
          
        exerciseName: '',
        description: '',
         bodyGroupId: '0',
         exerciseId: '',
         expectedTime: '',
         suggestedWeight: '',
         numberOfReps: '',
         userId: this.exercise.userId,
     },
     showForm: false,
      CreationError: false,
      CreationErrorMsg: 'There were problems create exercise.'
};
  },
  computed:{
    
    isCanEdit()
    {
      if(this.$store.state.user.authorities[0].name==="ROLE_ADMIN" || this.$store.state.user.id === this.editingExercise.userId)
        {
          return true;
        }
        else
        {
          return false;
        }
    }

  },
  methods: {
      update() {
        this.editingExercise.exerciseId = this.exercise.exerciseId
          exercise.edit(this.editingExercise)
          .then((response) => {
              if (response.status == 200) {
                 this.$router.push({
                      path: '/',
                      query: {edit: 'success'}
                  })
              }
          })
      },
      getExercises()
    {
        exercise.listExercise().then(response => {
            this.$store.commit("SET_EXERCISE", response.data)
        
        });

    },
    deleteExercise() {
    this.editingExercise.exerciseId = this.exercise.exerciseId
    exercise.deleteExercise(this.editingExercise.exerciseId).then((response) =>
    {
      if(response.status == 200) {
        this.$router.push('/');
      }
    }
  ) 
  }
  }

  
    

}
</script>

<style>

</style>