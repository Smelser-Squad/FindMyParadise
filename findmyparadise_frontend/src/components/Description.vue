<template>
  <div id="description">
    <h4>{{ dataObject.name }}</h4>
    <span v-if="dataObject.reviews != undefined"
      >{{ dataObject.reviews.length }} reviews -
      <u>{{ dataObject.address }}</u></span
    >
    <hr />
    <h5 v-if="dataObject.host != undefined" id="typeAndHost">
      {{ dataObject.type }} hosted by {{ dataObject.host.hostName }}
    </h5>
    <img v-if="dataObject.host != undefined" :src="dataObject.host.imageSrc" />
    <br />
    <span
      >{{ dataObject.maxGuests }} guests - {{ dataObject.bedrooms }} bedrooms -
      {{ dataObject.bathrooms }} bathrooms</span
    >
    <hr />
    <p>{{ dataObject.description }}</p>
    <span @click="toggleEmail"><u>Contact Host</u></span>
  </div>
</template>

<script>
import axios from "axios";

let listingID = 1;
export default {
  name: "Description",
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
  methods: {
    toggleEmail() {
      this.$emit("email");
    },
  },
};
</script>

<style scoped>
img {
  height: 50px;
  width: 50px;
  border-radius: 50%;
  display: inline;
  float: right;
}
#typeAndHost {
  display: inline;
}
</style>
