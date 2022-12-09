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

     delete(exerciseId) {
       return axios.delete(`/exercise/${exerciseId}` )
     }
}