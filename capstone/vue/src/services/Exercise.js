import axios from 'axios';
export default
{
    create(exercise) {
        return axios.post('/exercise', exercise)
      },

     listExercise()
     {
       return axios.get('/exercise')
     }
}