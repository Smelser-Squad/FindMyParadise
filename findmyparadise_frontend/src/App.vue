<template>
  <div id="AppBody">
    <div class="container">
      <reservation title="Reservation"></reservation>
    </div>
    <div class="container">
      <amenities title="Amenities"></amenities>
    </div>
    <div class="container">
      <calendar title="Calendar"></calendar>
    </div>
    <div class="container">
      <Map />
    </div>
    <div class="scrollContainer">
      <more-places></more-places>
    </div>
    <div class="container">
      <description title="Description"></description>
    </div>
    <div class="reviewContainer">
      <review title="Review"></review>
    </div>
    <div class="reviewerContainer"> 
      <reviewer> </reviewer>
    </div>
    <div class="container">
      <host></host>
    </div>
  </div>
</template>

<script>

import MorePlaces from "./components/MorePlaces";
import Reservation from "./components/Reservation";
import Map from "./components/Map";
import Calendar from "./components/Calendar.vue";
import Description from "./components/Description";

import Review from "./components/Review"
import Reviewer from "./components/Reviewer"

import Amenities from "./components/Amenities.vue";

import Host from "./components/Host.vue";


export default {
  name: "App",
  components: {
   Reservation,
    Map,
    Calendar,
    MorePlaces,

    Description,
    Review,
    Reviewer,

    Amenities,
    Host


  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400&display=swap");
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
}
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
body {
  font-family: "Poppins", sans-serif;
}
.container {
  max-width: 500px;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid gray;
  padding: 30px;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
}
.btn {
  display: inline-block;
  background: rgb(209, 60, 110);
  color: #fff;
  border: none;
  padding: 10px 20px;
  margin: 5px;
  border-radius: 5px;
  cursor: pointer;
  text-decoration: none;
  font-size: 15px;
  font-family: inherit;
}
.btn:focus {
  outline: none;
}
.btn:active {
  transform: scale(0.98);
}
.btn-block {
  display: block;
  width: 100%;
}
.scrollContainer {
  max-width: 1200px;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid gray;
  padding: 30px;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
}
.datePicker {
  display: inline;
}

.reviewContainer {
  max-width: 500px;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid gray;
  padding: 30px;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
}

.reviewerContainer {
  max-width: 500px;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid gray;
  padding: 30px;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
}
</style>