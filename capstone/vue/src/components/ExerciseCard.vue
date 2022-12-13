<template>
  <div class="card">
      <h2 class="exercise-title">{{exercise.exerciseName}}</h2>
    
    
   <!-- <h3 class="exercise-description">{{exercise.description}}</h3>

    <button v-on:click="markRead(true)" v-if="!book.read" class="mark-read">Mark Read</button>
    <button v-on:click="markRead(false)" v-if="book.read" class="mark-unread">Mark Unread</button> -->  
    
  </div>
</template>

<script>
export default {
    name: 'exercise-card',
    props: ["exercise"],
    

}
</script>

<style>
.card {
    /*border: 2px solid rgb(27, 26, 26);
    border-radius: 10px;*/
    color: #4CAF50;
    font-family: "Roboto", sans-serif;
    text-align: center;
    font-size: 15px;
    margin: 5%;
    padding: 10%;
    background-color: white;
    box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    align-items: center;

}

.card.read {
    background-color: lightgray;
}

.card .exercise-title {
    color: #4CAF50;
    text-align: center;
    font-family: "Roboto", sans-serif;
    text-transform: uppercase;
    outline: 50px;
    font-size: 15px;
    -webkit-transition: all 0.3 ease;
    transition: all 0.3 ease;
    cursor: pointer;
    outline-color: #f2f2f2;
    margin: 0 auto;
    display: block;
    align-items: center;
}

.card .exercise-description {
    color:  #4CAF50;;
    text-align: center;
    font-family: "Roboto", sans-serif;
    font-size: 15px;
    
}
</style>