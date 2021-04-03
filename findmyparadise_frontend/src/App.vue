<template>
  <div id="AppBody">
    <div class="masterContainer">
      <div class="header">
        <img src="./assets/fyplogo.png" />
      </div>
      <div class="imgContainer">
        <GalleryMini />
      </div>
      <div class="reservationContainer">
        <Reservation
          title="Reservation"
          :dateStart="range.start"
          :dateEnd="range.end"
        />
      </div>
      <hr class="light" />
      <br />
      <div class="amenitiesContainer">
        <amenities title="Amenities"></amenities>
      </div>
      <hr class="light" />
      <div class="calenderContainer">
        <h4 id="dateHeader">Select Date Range</h4>
        <DateRangePicker @datePick="transferDates($event)" />
      </div>
      <hr class="light" />
      <div class="mapContainer">
        <Map />
      </div>
      <hr class="light" />
      <br />
      <div class="grid-container">
        <div class="container">
          <description title="Description" @email="toggleEmail"> </description>
        </div>
        <div class="container">
          <review></review>
        </div>
        <div class="hostContainer">
          <host></host>
        </div>
      </div>
      <br>
      <hr class="light">
      <br>
      <div class="scrollContainer">
        <more-places></more-places>
      </div>
      <div class="scrollContainer">
        <events title="Events"></events>
      </div>
      <div class="scrollContainer">
        <information></information>
      </div>
      <email
        v-if="emailTrigger && host != undefined"
        :toggleEmail="() => toggleEmail()"
        :host="host"
      >
      </email>
    </div>
  </div>
</template>

<script>
import MorePlaces from "./components/MorePlaces.vue";
import Reservation from "./components/Reservation.vue";
import Map from "./components/Map.vue";
import Description from "./components/Description";
import Amenities from "./components/Amenities.vue";
import Review from "./components/Review";
import Events from "./components/Events";
import DateRangePicker from "./components/DateRangePicker.vue";
import Email from "./components/Email";
import GalleryMini from "./components/GalleryMini.vue";
import Host from "./components/Host.vue";
import Information from "./components/Information.vue";

export default {
  name: "App",
  components: {
    Reservation,
    Map,
    MorePlaces,
    Description,
    Amenities,
    Review,
    Host,
    DateRangePicker,
    GalleryMini,
    Events,
    Email,
    Information,
  },
  methods: {
    Change(event) {
      console.log(event);
    },
    toggleEmail(host) {
      this.emailTrigger = !this.emailTrigger;
      this.host = host;
    },
    transferDates(range) {
      this.range = range;
      console.log(this.range.start);
      console.log(this.range.end);
    },
    transferDays(num) {
      this.days = num;
      console.log(this.days);
    },
  },
  data() {
    return {
      emailTrigger: false,
      host: {},
      range: {
        start: new Date(),
        end: new Date(),
      },

      days: "",
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
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-image: linear-gradient(
    to right top,
    #000000,
    #311921,
    #5d2a3d,
    #8e3b5c,
    #c14d7d
  );
  background-attachment: fixed;
}
.header {
  margin: auto;
  text-align: center;
  position: relative;
  -webkit-box-reflect: -28px below linear-gradient(transparent, #0002);
}
.header img {
  padding-bottom: 20px;
}
.header div {
  margin: auto;
  text-align: center;
  margin-bottom: 20%;
}
.header h1 {
  font-size: 6vw;
  font-style: italic;
  background-image: linear-gradient(
    to right,
    #e2204c,
    #f04e39,
    #f67526,
    rgb(252, 118, 140),
    hotpink
  );
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
.header h1::after {
  content: attr(data-text);
  position: absolute;
  margin-left: 20.5%;
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
    rgb(252, 118, 140),
    hotpink
  );
  -webkit-background-clip: text;
  color: transparent;
  opacity: 0.1;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
}
.vc-pane-container {
  border: 2px solid black;
  border-color: black;
  background-color: white;
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
.masterContainer {
  max-width: 90%;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid gray;
  background: whitesmoke;
  opacity: 0.92;
  padding: 30px;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
}
.amenitiesContainer h3 {
  margin: auto;
  text-align: center;
}
/* .masterContainer div,
h2,
h5 {
  margin: auto;
  text-align: center;
} */
.reservationContainer div,
h2,
h5 {
  margin: auto;
  text-align: center;
}
.mapContainer {
  max-width: 80%;
  margin: 30px auto;
  overflow: hidden;
  min-height: 300px;
  /* border: 1px solid gray; */
  background: whitesmoke;
  padding: 30px;
  /* border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px; */
}
.calenderContainer {
  max-width: 80%;
  margin: 30px auto;
  text-align: center;
  overflow: auto;
  min-height: 300px;
  /* border: 1px solid gray; */
  background: whitesmoke;
  padding: 30px;
  /* border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px; */
}
.reservationContainer {
  max-width: 95%;
  margin: 30px auto;
  overflow: hidden;
  max-height: 725px;
  min-height: 200px;
  /* border: 1px solid gray; */
  padding: 30px;
  /* border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px; */
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
  margin: auto;
  text-align: left;
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
.grid-container {
  display: grid;
  grid-column-start: 1;
  grid-column-end: 3;
}
/* .reviewContainer {
  max-width: 500px;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid gray;
  padding: 30px;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
  float: left;
}
.descContainer {
  max-width: 500px;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid gray;
  padding: 30px;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
  float: right;
} */
.imgContainer {
  max-width: 100%;
  margin: 30px auto;
  object-fit: fill;
  max-height: 400px;
  border-radius: 10px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
  overflow: auto;
}
.amenitiesContainer {
  max-width: 80%;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  padding: 30px;
  /* border: 1px solid gray;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px; */
}
#dateHeader {
  margin: auto;
  text-align: center;
}
.hostContainer {
  max-width: 500px;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid gray;
  padding: 30px;
  border-radius: 5px;
  box-shadow: rgb(0 0 0 / 12%) 0px 6px 16px;
  position: relative;
}
.light {
  margin: auto;
  text-align: center;
  width: 80%;
}
</style>
