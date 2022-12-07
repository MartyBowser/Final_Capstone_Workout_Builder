<template>
 <div id="createExercise" class="createExercise">
    <form class="formCreateExercise" @submit.prevent="create">
      <h1 class="h3 mb-3 font-weight-normal">Create Exercise</h1>
      <div class="alert alert-danger" role="alert" v-if="CreationError">
        {{ CreationErrorMsg }}
      </div>
      
      <input
        type="text"
        id="Exercise"
        class="form-control"
        placeholder="Exercise Name"
        v-model="exercise.exercise_name"
        required
      />
      <input
        type="text"
        id="exercise_description"
        class="form-control"
        placeholder="Exercise Description"
        v-model="exercise.exercise_description"
        required
      />



      
      <select  required  class="form-control" v-model="exercise.body_group_id" placeholder="Select muscle group">
<option selected value="0">Select muscle group focus</option>

    <option value="1">Cardio</option>
    <option value="2">Back</option>
    <option value="3">Leg</option>
    <option value="4">Arms</option>
    <option value="5">Abs</option>
    </select>
     
      
      <button class="form-button" type="submit">
        Create Exercise
      </button>
        
      <div class = "have-an-account"> <router-link :to="{ name: 'home' }"><a> Go Back </a> </router-link> </div>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';
export default {
name: 'createExercise',
  data() {
    return {
      exercise: {
        body_group_id: '0',
        exercise_name: '',
        description: '',
     },
      CreationError: false,
      CreationErrorMsg: 'There were problems create exercise.'
};
  },
  methods: {
    create() {
     
        authService
          .create(this.exercise)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/exercise',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.CreationError = true;
            if (response.status === 400) {
              this.CreationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      
    },
    clearErrors() {
      this.CreationError = false;
      this.CreationErrorMsg = 'There were problems creating this exercise.';
    },
  },
};


</script>

<style>

</style>