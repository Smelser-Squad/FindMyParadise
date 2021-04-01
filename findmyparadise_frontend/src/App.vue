<template>
  <div id="AppBody">

    <div class="header">
      <h1 data-text="Find Your Paradise">Find Your Paradise</h1>
    </div>
    <br>

    <div class="imgContainer">
      <GalleryMini />
    </div>
    <div class="container">

      <reservation title="Reservation"></reservation>
    </div>
    <div class="container">
      <amenities title="Amenities"></amenities>
    </div>
    <div class="container">
      <DateRangePicker @DatePick="Change" />
    </div>
    <div class="mapContainer">
      <Map />
    </div>
    <div class="scrollContainer">
      <more-places></more-places>
    </div>
    <div class="container">
      <description title="Description" @email="toggleEmail"> </description>
    </div>
    <div class="reviewContainer">
      <review></review>
    </div>
    <div class="reviewerContainer">
      <reviewer> </reviewer>
    </div>

    <div class="container">
      <host @email="toggleEmail"></host>
    </div>
    <div class="scrollContainer">
      <events title="Events"></events>
    </div>
    <email
      v-if="emailTrigger && host != undefined"
      :toggleEmail="() => toggleEmail()"
      :host="host"
    >
    </email>
  </div>
</template>

<script>
import MorePlaces from "./components/MorePlaces.vue";
import Reservation from "./components/Reservation.vue";
import Map from "./components/Map.vue";
import Description from "./components/Description";

import Amenities from "./components/Amenities.vue";

import Review from "./components/Review";
import Reviewer from "./components/Reviewer";
import Events from "./components/Events";
import DateRangePicker from "./components/DateRangePicker.vue";
import Email from "./components/Email";


import GalleryMini from "./components/GalleryMini.vue";


import Host from "./components/Host.vue";


export default {
  name: "App",
  components: {
    Reservation,
    Map,
    MorePlaces,
    Description,
    Amenities,
    Review,
    Reviewer,
    Host,
    DateRangePicker,
     GalleryMini,
    Events,
    Email,
  },


   
   
  

  methods: {
    Change(event) {
      console.log(event);
    },
    toggleEmail(host) {
      this.emailTrigger = !this.emailTrigger;
      this.host = host;
    },
  },


  data() {
    return {
      emailTrigger: false,
      host: {},
    };
  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400&display=swap");
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
body {
  font-family: "Poppins", sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: whitesmoke;
  background-attachment: fixed;
}
.header {
  margin: auto;
  text-align: center;
  position: relative;
  text-align: center;
  margin-top: 30px;
  margin-bottom: 45px;
  -webkit-box-reflect: -28px below linear-gradient(transparent, #0002);
}
.header div {
  margin: auto;
  text-align: center;
}
.header h1 {
  font-size: 6vw;
  font-style: italic;
  background-image: linear-gradient(
    to right,
    #e2204c,
    #f04e39,
    #f67526,
    #f39911,
    #eabc12
  );
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
.header h1::after {
  content: attr(data-text);
  position: absolute;
  margin-left: 4.5%;
  top: 0;
  left: 0;
  /* Change the position of transformed element */
  transform-origin: bottom;
  /*  Rotates around x-axis */
  transform: rotateX(180deg);
  line-height: 0.85em;
  /* linear-gradient defined by up,down,left ,right ,diagonal */
  background-image: linear-gradient(
    to right,
    #e2204c,
    #f04e39,
    #f67526,
    #f39911,
    #eabc12
  );
  -webkit-background-clip: text;
  color: transparent;
  opacity: 0.1;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
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
.reservationContainer {
  max-width: 800px;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid gray;
  padding: 30px;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
}
.reservationContainer div, h2, h5 {
  margin: auto;
  text-align: center;
}
.mapContainer {
  max-width: 600px;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid gray;
  padding: 30px;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
}
.mapContainer div {
  margin: auto;
  text-align: center;
}
.mapContainer p {
  text-align: left;
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
#mapLine {
  margin: 0;
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

.imgContainer{
  max-width: 1300px;
  margin: 30px auto;
  object-fit: fill;
  max-height: 500px;
  border-radius: 10px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
  overflow: hidden;
}
</style>

