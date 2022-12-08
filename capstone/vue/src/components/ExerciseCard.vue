<template>
  <div class="card">
      <h2 class="exercise-title">{{exercise.exerciseName}}</h2>
    
    
    <h3 class="exercise-description">{{exercise.description}}</h3>

    <!--<button v-on:click="markRead(true)" v-if="!book.read" class="mark-read">Mark Read</button>
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
    border: 2px solid rgb(27, 26, 26);
    border-radius: 10px;
    color: black;
    margin: 20px;
    padding: 20px;
    background-color: white;
    box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);

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