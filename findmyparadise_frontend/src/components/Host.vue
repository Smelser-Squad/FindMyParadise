<template>
  <div id="host">
    {{hostName}}
    <!-- <img :src="dataObject.host.imageSrc" />
    <div class="picInfo">
      <h5>Hosted by {{ dataObject.host.hostName }}</h5>
      <br />
      <p>joined {{ dataObject.host.joinDate }}</p>
    </div>
    <div class="moreHostInfo">
      <span>{{ dataObject.host.totalReviews }} Reviews </span>
      <span v-if="dataObject.host.verified != undefined">Identity Verified</span>
    </div>
    <div class="responseInfo">
      <span>Response Rate: {{ dataObject.host.responseRate }}%</span>
      <br />
      <span>Response Time: {{ dataObject.host.responseTime }}</span>
    </div>
    <div class="transferWarning">
      <span
        >To protect your payment, never fransfer money or communicate outside of
        the find my paradise website</span>
    </div> -->
  </div>
</template>

<script>
import axios from "axios";

let listingID = 1;
export default {
  name: "Host",
  data() {
    return {
      hostName : String,
      dataObject: {},
      overlay: false,
    };
  },
  mounted() {
    axios.get(`http://localhost:8080/api/listing/${listingID}`).then((res) => {
      this.dataObject = res.data;
      this.hostName = res.data.host.hostName;
      console.log(this.hostName);
      console.log(this.dataObject);
      console.log(res.data);
    });
  },
  methods: {},
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
