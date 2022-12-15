<template>
  <div>
  <h1>Logout</h1>
  <img class="closinglogo" src="https://freesvg.org/img/1545424155.png">
  </div>
</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>
