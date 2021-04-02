<template>
  <div id="host">
    <img :src="imageSource" />
    <div class="picInfo">
      <h5>Hosted by {{ hostName }}</h5>
      <br />
      <p class="joinInfo">joined {{ joinDate }}</p>
    </div>
    <div class="moreHostInfo">
      <span>{{ totalReviews }} Reviews  </span>
      <svg
        viewBox="0 0 1000 1000"
        role="presentation"
        aria-hidden="true"
        focusable="false"
        style="height: 14px; width: 14px; fill: red">
      <path
        d="M972 380c9 28 2 50-20 67L725 619l87 280c11 39-18 75-54 75-12 0-23-4-33-12L499 790 273 962a58 58 0 0 1-78-12 50 50 0 0 1-8-51l86-278L46 447c-21-17-28-39-19-67 8-24 29-40 52-40h280l87-279c7-23 28-39 52-39 25 0 47 17 54 41l87 277h280c24 0 45 16 53 40z"
      ></path>
      
    </svg>
      <span v-if=" verified != undefined">  Identity Verified  </span>
      <svg 
        xmlns="http://www.w3.org/2000/svg" 
        width="24" 
        height="24" 
        viewBox="0 0 24 24"
        style="height: 14px; width: 14px; fill: red">
        <path d="M12 0c-3.371 2.866-5.484 3-9 3v11.535c0 4.603 3.203 5.804 9 9.465 5.797-3.661 9-4.862 9-9.465v-11.535c-3.516 0-5.629-.134-9-3zm-.548 15l-3.452-3.362 1.237-1.239 2.215 2.123 4.382-4.475 1.238 1.238-5.62 5.715z"/>
      </svg>
    </div>
    <div class="responseInfo">
      <span>Response Rate: {{ responseRate }}%</span>
      <br />
      <span>Response Time: {{ responseTime }}</span>
    </div>
  </div>
  <div class="transferWarning">
      <svg 
        xmlns="http://www.w3.org/2000/svg" 
        width="24" 
        height="24" 
        viewBox="0 0 24 24"
        style="height: 14px; width: 14px">
        <path d="M10 16c0-1.104.896-2 2-2s2 .896 2 2c0 .738-.404 1.376-1 1.723v2.277h-2v-2.277c-.596-.347-1-.985-1-1.723zm11-6v14h-18v-14h3v-4c0-3.313 2.687-6 6-6s6 2.687 6 6v4h3zm-13 0h8v-4c0-2.206-1.795-4-4-4s-4 1.794-4 4v4zm11 2h-14v10h14v-10z"/>
      </svg>
      <span
        >To protect your payment, never transfer money or communicate outside of
        the find my paradise website</span>
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
      totalReviews : Number,
      superHost : Boolean,
      verified : Boolean,
      responseTime : String,
      responseRate : Number,
      joinDate : String,
      email : String,
      imageSource : String,
      dataObject: {},
      overlay: false,
    };
  },
  mounted() {
    axios.get(`http://localhost:8080/api/listing/${listingID}`).then((res) => {
      this.dataObject = res.data;
      this.hostName = res.data.host.hostName;
      this.totalReviews = res.data.host.totalReviews;
      this.superHost = res.data.host.superHost;
      this.verified = res.data.host.verified;
      this.responseTime = res.data.host.responseTime;
      this.responseRate = res.data.host.responseRate;
      this.joinDate = res.data.host.joinDate;
      this.email = res.data.host.email;
      this.imageSource = res.data.host.imageSrc;

      console.log(this.joinDate);
      console.log(this.imageSource);
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
  position: absolute;
  bottom: 10%;
  left: 10px;
}

.moreHostInfo{
  margin-top: 20px;
}

.responseInfo{
  margin-top: 20px;
}

.joinInfo {
  color: gray;
}
</style>
