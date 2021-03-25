<template>
  <header>
    <h1>{{ title }}</h1>
  </header>
  <body>
    <h3>Check-In</h3>

    <Calendar />
    <h3>Check-Out</h3>
    <Calendar />
    <h3>Guests</h3>
    <button class="btn" @click="OnClick()">Reserve</button>
  </body>
</template>
<script>
import Calendar from "./Calendar";

export default {
  name: "Reservation",
  props: {
    title: String,
  },

  components: {
    Calendar,
  },
  methods: {
    OnClick() {
      console.log("Reserve");
    },
  },
};
</script>
<style scoped>
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}
</style>
