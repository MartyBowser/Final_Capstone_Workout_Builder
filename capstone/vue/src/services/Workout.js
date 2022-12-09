import axios from 'axios';
export default
{
    create(workout) {
        return axios.post('/workout', workout)
      },

     listWorkout()
     {
       return axios.get('/workout')
     },

     edit(workout) {
       return axios.put('/workout', workout)
     },

     deleteExercise(workoutId) {
       return axios.delete(`/exercise/${workoutId}` )
     }
}