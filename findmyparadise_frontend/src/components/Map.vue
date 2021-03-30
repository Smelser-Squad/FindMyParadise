<template>
    <h1>Map</h1>
    <div id="map" ref="mapRef"></div>
    <p></p> <!-- nearby attractions -->
    <p></p>
    <p></p>
    <p></p>
</template>

<script>
import { onMounted, ref } from "vue";
import axios from "axios";
let listingID = 1;
export default {
  name: "Map",
  data() {
    return {
      dataObject: {},
    };
  },
  setup() {
    const mapRef = ref(null);
    onMounted(() => {
      axios
        .get(`http://localhost:8080/api/listing/${listingID}`)
        .then((res) => {
          console.log(res);
          let POI = [res.data.longitude, res.data.latitude];
          let lat = res.data.latitude.toString();
          let long = res.data.longitude.toString();
          let latFloatNum = parseFloat(lat);
          let longFloatNum = parseFloat(long);
          axios.get(`https://api.tomtom.com/search/2/nearbySearch/.json?lat=${latFloatNum}&lon=${longFloatNum}&key=ziBCBRJyocQkRJJD2WlhVIOaMvQ1agyK`)
          .then((nearbyObj) => {
            console.log(nearbyObj);
            console.log(nearbyObj.data.results[2].poi.name);
            console.log((nearbyObj.data.results[9].dist * 0.00062137119224).toFixed(2) + " mi");
          });
          const tt = window.tt;
          var map = tt.map({
            key: "ziBCBRJyocQkRJJD2WlhVIOaMvQ1agyK",
            container: mapRef.value,
            style: "tomtom://vector/1/basic-main",
            center: POI,
            zoom: 14,
          });
          map.addControl(new tt.FullscreenControl());
          map.addControl(new tt.NavigationControl());
          addMarker(map);
        });
    });
    function addMarker(map) {
      const tt = window.tt;
      axios
        .get(`http://localhost:8080/api/listing/${listingID}`)
        .then((res) => {
          var location = [res.data.longitude, res.data.latitude];
          console.log(res.data.latitude);
          console.log(res.data.longitude);
          var popupOffsets = {
            top: [0, 0],
            bottom: [0, -30],
            "bottom-right": [0, -30],
            "bottom-left": [0, -30],
            left: [25, -35],
            right: [-25, -35],
          };
          var marker = new tt.Marker().setLngLat(location).addTo(map);
          var popup = new tt.Popup({ offset: popupOffsets }).setHTML(
            res.data.name.toUpperCase()
          );
          marker.setPopup(popup).togglePopup();
        });
  }
  });
  return {
      mapRef,
    };
   },
};
</script>
<style>
#map {
  height: 200px;
  width: 300px;
}
</style>