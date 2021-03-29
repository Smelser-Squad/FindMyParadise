<template>
  <h1>Map</h1>
  <div id="map" ref="mapRef"></div>
</template>

<script>
import { onMounted, ref } from "vue";
import axios from "axios";

let listingID = 2;

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
          let pointOfInterest = [res.data.longitude, res.data.latitude];
          const tt = window.tt;
          var map = tt.map({
            key: "ziBCBRJyocQkRJJD2WlhVIOaMvQ1agyK",
            container: mapRef.value,
            style: "tomtom://vector/1/basic-main",
            zoom: 14,
            center: pointOfInterest
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