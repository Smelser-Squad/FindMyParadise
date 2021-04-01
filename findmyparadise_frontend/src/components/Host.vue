<template>
  <div id="host">
    <img :src="dataObject.imageSrc" />
    <div class="picInfo">
      <h5>Hosted by {{ dataObject.hostName }}</h5>
      <br />
      <p>joined {{ dataObject.joinDate }}</p>
    </div>
    <div class="moreHostInfo">
      <span>{{ dataObject.totalReviews }} Reviews </span>
      <span v-if="dataObject.verified != undefined">Identity Verified</span>
    </div>
    <div class="responseInfo">
      <span>Response Rate: {{ dataObject.responseRate }}%</span>
      <br />
      <span>Response Time: {{ dataObject.responseTime }}</span>
    </div>
    <div class="transferWarning">
      <span
        >To protect your payment, never fransfer money or communicate outside of
        the find my paradise website</span
      >
    </div>
    <div class="contactHost">
      <button @click="toggleEmail">Contact Host</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

let hostId = 1;
export default {
  name: "Host",
  data() {
    return {
      dataObject: {},
      overlay: false,
    };
  },
  mounted() {
    axios.get(`http://localhost:8080/api/host/${hostId}`).then((res) => {
      this.dataObject = res.data;
      console.log(res.data);
    });
  },
  methods: {
    toggleEmail() {
      this.$emit("email", this.dataObject);
    },
  },
};
</script>

<style scoped>
img {
  height: 50px;
  width: 50px;
  border-radius: 50%;
  margin-right: 20px;
  display: inline;
  vertical-align: top;
}

h5 {
  display: inline;
}
p {
  display: inline;
}

.picInfo {
  display: inline-block;
}

.transferWarning {
  font-size: 10px;
}
</style>
