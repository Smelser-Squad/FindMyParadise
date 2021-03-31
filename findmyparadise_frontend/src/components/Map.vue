<template>
  <h1>Map</h1>
  <div id="map" ref="mapRef"></div>
  <p id="mapLine">{{ dataName1 + " : " + dataDist1 }}</p>
  <p id="mapLine">{{ dataName2 + " : " + dataDist2 }}</p>
  <p id="mapLine">{{ dataName3 + " : " + dataDist3 }}</p>
  <p id="mapLine">{{ dataName4 + " : " + dataDist4 }}</p>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";
let listingID = 2;
export default {
  name: "Map",
  props: {
    locationName: {
      type: String,
    },
    locationDist: {
      type: String,
    },
  },
  setup(props) {
    const dataName1 = ref(props.locationName);
    const dataName2 = ref(props.locationName);
    const dataName3 = ref(props.locationName);
    const dataName4 = ref(props.locationName);
    const dataDist1 = ref(props.locationDist);
    const dataDist2 = ref(props.locationDist);
    const dataDist3 = ref(props.locationDist);
    const dataDist4 = ref(props.locationDist);
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
          axios
            .get(
              `https://api.tomtom.com/search/2/nearbySearch/.json?lat=${latFloatNum}&lon=${longFloatNum}&key=ziBCBRJyocQkRJJD2WlhVIOaMvQ1agyK`
            )
            .then((nearbyObj) => {
              dataName1.value = nearbyObj.data.results[3].poi.name + " ";
              dataName2.value = nearbyObj.data.results[5].poi.name + " ";
              dataName3.value = nearbyObj.data.results[7].poi.name + " ";
              dataName4.value = nearbyObj.data.results[9].poi.name + " ";
              dataDist1.value =
                (nearbyObj.data.results[3].dist * 0.00062137119224).toFixed(2) +
                " mi";
              dataDist2.value =
                (nearbyObj.data.results[5].dist * 0.00062137119224).toFixed(2) +
                " mi";
              dataDist3.value =
                (nearbyObj.data.results[7].dist * 0.00062137119224).toFixed(2) +
                " mi";
              dataDist4.value =
                (nearbyObj.data.results[9].dist * 0.00062137119224).toFixed(2) +
                " mi";
              // console.log(nearbyObj);
              // console.log(nearbyObj.data.results[3].poi.name);
              // console.log(
              //   (nearbyObj.data.results[9].dist * 0.00062137119224).toFixed(2) +
              //     " mi"
              // );
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
    return {
      mapRef,
      dataName1,
      dataName2,
      dataName3,
      dataName4,
      dataDist1,
      dataDist2,
      dataDist3,
      dataDist4,
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
