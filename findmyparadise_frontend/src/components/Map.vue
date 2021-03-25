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
  </div>
</template>

<script>
// let id = 1;

// let baseURL = "http://localhost:8080/api";

// import $ from "jquery";

// $.get(

//   `${baseURL}/getListingAddress/${id}`,
//   function(data, textStatus, jqXHR)
//   {
//     let thisAddress = data[0].address;
//   }

// )

export default {
  name: "Map",
};
</script>

<style scoped>
h1 {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}
</style>
