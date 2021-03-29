<template>
  <div class="map">
    <h1>Map</h1>
    <iframe
      width="300"
      height="200"
      frameborder="0"
      scrolling="no"
      marginheight="0"
      marginwidth="0"
      id="gmap_canvas"
      src="https://maps.google.com/maps?width=300&amp;height=200&amp;hl=en&amp;q=2%20College%20Hill%20Westminster+(Example%20Map)&amp;t=&amp;z=16&amp;ie=UTF8&amp;iwloc=B&amp;output=embed"
    ></iframe>
    <h3>{{ dataObject }}</h3>
  </div>
</template>

<script>
import axios from "axios";
let listingID = 1;

//  let thisLocation= axios.get(`http://localhost:8080/api/listing/${listingID}`)
//   .then(function (response) {
//     // handle success
//     console.log(response);
//   })
// .catch(function (error) {
//   // handle error
//   console.log(error);
// })
// .then(function () {
//   // always executed
// });

//  thisLocation;

// let locLatitude = thisLocation[0].latitude;

// let locLongitude = thisLocation[0].longitude;

export default {
  name: "Map",
  data() {
    return {
      dataObject: {},
    };
  },
  mounted() {
    axios.get(`http://localhost:8080/api/listing/${listingID}`).then((res) => {
      this.dataObject = res.data;
      console.log(res.data);
    });
  },
};
</script>

<style scoped>
h1 {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}
</style>
