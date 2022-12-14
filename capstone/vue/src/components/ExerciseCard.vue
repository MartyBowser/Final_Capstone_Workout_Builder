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


</style>