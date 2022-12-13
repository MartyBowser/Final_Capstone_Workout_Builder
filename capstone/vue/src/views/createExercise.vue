<template>
 <div id="createExercise" class="createExercise">
    <form class="formCreateExercise" @submit.prevent="create">
      <h1 class="h3 mb-3 font-weight-normal">Create Exercise</h1>
      <p class="text-create-exercise">Create new exercises here and share with your clients.</p>
      <div class="alert alert-danger" role="alert" v-if="CreationError">
        {{ CreationErrorMsg }}
      </div>
      
      <input
        type="text"
        id="Exercise"
        class="form-control"
        placeholder="Exercise Name"
        v-model="exercise.exerciseName"
        required
      />
      <input
        type="text"
        id="description"
        class="form-control"
        placeholder="Exercise Description"
        v-model="exercise.description"
        required
      />
      <input
        type="number"
        id="expected-time"
        class="form-control"
        placeholder="Expected Time"
        v-model="exercise.expectedTime"
        required
      />
      <input
        type="number"
        id="suggested-weight"
        class="form-control"
        placeholder="Suggested Weight in lbs"
        v-model="exercise.suggestedWeight"
        required
      />
      <input
        type="number"
        id="number-of-reps"
        class="form-control"
        placeholder="Number of Reps"
        v-model="exercise.numberOfReps"
        required
      />
      
      <select  required  class="form-control" v-model="exercise.bodyGroupId" placeholder="Select muscle group">
<option selected value="0">Select muscle group focus</option>

    <option value="1">Cardio</option>
    <option value="2">Back</option>
    <option value="3">Leg</option>
    <option value="4">Arms</option>
    <option value="5">Abs</option>
    <option value="6">Full Body</option>
    </select>
     
      
      <button class="form-button-create-exercise-submit" type="submit">
        Submit
      </button>
        
      <div class = "have-an-account"> <router-link :to="{ name: 'home' }"><a> Go Back </a> </router-link> </div>
    </form>
  </div>
</template>

<script>
import exercise from '../services/Exercise.js';
export default {
name: 'createExercise',
  data() {
    return {
      exercise: {
        exerciseName: '',
        description: '',
         bodyGroupId: '0',
         userId: '',
         expectedTime: '',
         suggestedWeight: '',
         numberOfReps: ''
     },
      CreationError: false,
      CreationErrorMsg: 'There were problems create exercise.'
};
  },
  methods: {
    create() {
     if(this.exercise.bodyGroupId > 0){
      this.exercise.userId = this.$store.state.user.id;
      exercise
          .create(this.exercise)
          .then((response) => {
            if (response.status == 200) {
              this.$router.push({
                path: '/',
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
     }else {alert("Please select a valid body group")}  
    },
    clearErrors() {
      this.CreationError = false;
      this.CreationErrorMsg = 'There were problems creating this exercise.';
    },
    returnHome(){
      this.$router.push('/');
    }
  },
};


</script>

<style>

</style>