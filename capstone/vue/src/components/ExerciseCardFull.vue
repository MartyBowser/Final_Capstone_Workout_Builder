<template>
  <div class="card">
    <h2 class="exercise-title">{{ exercise.exerciseName }}</h2>

    <h3 class="exercise-description">{{ exercise.description }}</h3>
    <!-- 
    <button v-on:click="markRead(true)" v-if="!book.read" class="mark-read">Mark Read</button>
    <button v-on:click="markRead(false)" v-if="book.read" class="mark-unread">Mark Unread</button> -->

    <a href="#" v-on:click.prevent="showForm = !showForm">{{
      showForm ? "Cancel edits" : "Edit exercise"
    }}</a>
    <a href="#" v-on:click.prevent="showForm = !showForm">{{
      showForm ? "Cancel edits" : "Edit exercise"
    }}</a>

    <form
      v-if="showForm === true"
      class="formCreateExercise"
      @submit.prevent="update"
    >
      <h1 class="h3 mb-3 font-weight-normal">Create Exercise</h1>
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
    <button v-on:click="deleteExercise" class="delete-exercise" >Delete Exercise</button>
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
         exerciseId: ''
     },
     showForm: false,
      CreationError: false,
      CreationErrorMsg: 'There were problems create exercise.'
};
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
.card {
  /*border: 2px solid rgb(27, 26, 26);
    border-radius: 10px;*/
  color: black;
  margin: 20px;
  padding: 20px;
  background-color: white;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
  width: 100%;
}

.card.read {
  background-color: lightgray;
}

.card .exercise-title {
  font-size: 1.5rem;
}

.card .exercise-description {
  font-size: 1rem;
}
</style>