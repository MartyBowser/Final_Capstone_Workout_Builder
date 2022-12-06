<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }"><a> Home </a> </router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"><a> Logout </a> </router-link>
    </div>
    <router-view />
  </div>
</template>
