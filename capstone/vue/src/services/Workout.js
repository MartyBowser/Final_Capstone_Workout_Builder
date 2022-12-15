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

     editWorkout(workout) {
       return axios.put('/workout', workout)
     },

     deleteExercise(workoutId) {
       return axios.delete(`/exercise/${workoutId}` )
     },

     listWorkoutsGenerated(id, completed) {
      return axios.get(`/workoutsGenerated/${id}/completed=${completed}`)
    },
    addCompletion()
    {
      return axios.post('/completion')
    },
    
    findCompletionCount()
    {
      return axios.get('/completion')
    }
}