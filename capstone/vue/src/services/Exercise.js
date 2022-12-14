import axios from 'axios';
export default
{
    create(exercise) {
        return axios.post('/exercise', exercise)
      },

     listExercise()
     {
       return axios.get('/exercise')
     },

     edit(exercise) {
       return axios.put('/exercise', exercise)
     },

     deleteExercise(exerciseId) {
       return axios.delete(`/exercise/${exerciseId}` )
     },
     generateWorkout(workoutRequests){
       return axios.post('/getworkout', workoutRequests)
     },
     getExercisesFromWorkout(workoutId)
     {
      return axios.get(`/workout/${workoutId}`);
     },
     getExerciseById(exerciseId)
     {
      return axios.get(`/exercise/${exerciseId}`);
     },
}