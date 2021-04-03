<template>
  <!-- <div>
    <form @submit="postData" method="post">
      <input
        type="text"
        name="name"
        placeholder="Reviewer Name"
        v-model="posts.name"
      />
      <br />
      <br />
      <input
        type="text"
        name="description"
        placeholder="Write Rating  Description"
        v-model="posts.description"
      />
      <br />
      <br />

      <form ref="uploadForm" @submit.prevent="submit">
        <input
          type="file"
          ref="uploadImage"
          @change="onImageUpload()"
          class="form-control"
          required
        />
        <input
          type="button"
          @click="startUpload"
          name="upload"
          value="Upload"
        />
      </form>
      <br />
      <br />

      <br />
      <button type="submit">Add Review</button>
      <br />
      <br />
    </form>
  </div> -->


  <div>
    <svg
      viewBox="0 0 1000 1000"
      role="presentation"
      aria-hidden="true"
      focusable="false"
      style="height: 22px; width: 22px; fill: red; margin-top:-12px;">
      <path
        d="M972 380c9 28 2 50-20 67L725 619l87 280c11 39-18 75-54 75-12 0-23-4-33-12L499 790 273 962a58 58 0 0 1-78-12 50 50 0 0 1-8-51l86-278L46 447c-21-17-28-39-19-67 8-24 29-40 52-40h280l87-279c7-23 28-39 52-39 25 0 47 17 54 41l87 277h280c24 0 45 16 53 40z"
      ></path>
      
    </svg> 
    <span class="avRatingView"> {{ overallRating }} ({{ reviewList.length }} Reviews)</span>
  </div>
<br>
  <div class="left">
    <p>Cleanliness {{ averageCleanliness }}</p>
    <p>Communication {{ averageCommunication }}</p>
    <p>Check-in {{ averageCheckIn }}</p>
  </div>

  <div class="right">
    <p>Accuracy {{ averageAccuracy }}</p>
    <p>Location {{ averageLocation }}</p>
    <p>Value {{ averageValue }}</p>
  </div>


  <div
    v-for="reviewer in list.slice(0, 1)"
    v-bind:key="reviewer.reviewId"
    class="revierInfo"
  >

  <div> 
        <div class="rightImage">
          <img :src="reviewer.reviewer.imageSrc" />
        </div> 
        <div class="leftInfo"> 
            <h3 class="name">{{ reviewer.reviewer.name }}</h3>
            <p>{{ reviewer.reviewer.joinedDate }}</p>
        </div> 
  </div>
    <br>
   
    <p style="float:left">{{ reviewer.reviewer.description }}</p>

    <button class="showBtn" @click="() => TogglePopup('buttonTrigger')">
      Show all {{ reviewList.length }} reviews
    </button>


    <Modal
      v-if="popupTriggers.buttonTrigger"
      :TogglePopup="() => TogglePopup('buttonTrigger')"
    >
<br> 
<br> 
    <div class="leftRating">
     <svg
      viewBox="0 0 1000 1000"
      role="presentation"
      aria-hidden="true"
      focusable="false"
      style="height: 30px; width: 30px; fill: red;  margin-top:-12px;">
      <path
        d="M972 380c9 28 2 50-20 67L725 619l87 280c11 39-18 75-54 75-12 0-23-4-33-12L499 790 273 962a58 58 0 0 1-78-12 50 50 0 0 1-8-51l86-278L46 447c-21-17-28-39-19-67 8-24 29-40 52-40h280l87-279c7-23 28-39 52-39 25 0 47 17 54 41l87 277h280c24 0 45 16 53 40z"
      ></path>
      
    </svg> 
    <span class="avRatingViewDialog"> {{ overallRating }} ({{ reviewList.length }} Reviews)</span>
  </div>

  <div class="rightSearch">
    
  
      <div class="row">
                    <div class="row">
                    <div class="search-wrapper panel-heading col-sm-12">
                      <label> 
                        <input class="form-control" type="text" v-model="search" placeholder="Review Search" />
                      </label>
                    </div>                        
                     </div>
                     
                </div>
                </div>
<br>
<br>
<br>
<br>

<div class="ratingDialog"> 
  <p>Cleanliness {{ averageCleanliness }}</p>
    <p>Communication {{ averageCommunication }}</p>
    <p>Check-in {{ averageCheckIn }}</p>
    <p>Accuracy {{ averageAccuracy }}</p>
    <p>Location {{ averageLocation }}</p>
    <p>Value {{ averageValue }}</p>
</div>

      <br />
      <ul>
        <lu v-for="reviewer in filteredReviews" :key="reviewer">
          <div> 
              <div class="rightImageDialog">
              <img :src="reviewer.reviewer.imageSrc" />
              </div> 
              <div class="leftInfoDialog"> 
              <h3 class="name">{{ reviewer.reviewer.name }}</h3> 
              <p>{{ reviewer.reviewer.joinedDate }}</p>
          </div> 
         

          <br>
          </div>
           <p style="float:left">{{ reviewer.reviewer.description }}</p>
<br>
<br>
<br><br>
<br><br>
          <hr />
        </lu>
      </ul>
    </Modal>
  </div>
</template>

<script>
import axios from "axios";
import { ref } from "vue";
import Modal from "./Modal";
let listingID = 1;

export default {
  name: "Reviewer",
  components: { Modal },

  setup() {
    const popupTriggers = ref({
      buttonTrigger: false,
    });

    const TogglePopup = (trigger) => {
      popupTriggers.value[trigger] = !popupTriggers.value[trigger];
    };

    return {
      Modal,
      popupTriggers,
      TogglePopup,
    };
  },
  data() {
    return {
      posts: {
        name: null,
        imageSrc: null,
        description: null,
      },
      list: [],
      formData: null,
      reviewList: [],
      overallRating: 0,
      averageCleanliness: 0,
      averageCommunication: 0,
      averageCheckIn: 0,
      averageAccuracy: 0,
      averageLocation: 0,
      averageValue: 0,
      search: ''
    };
  },

  methods: {
    postData(e) {
      axios
        .post("http://localhost:8080/api/addReviewer", this.posts)
        .then((result) => {
          console.warn(result);
        });
      e.preventDefault();
    },

    onImageUpload() {
      let file = this.$refs.uploadImage.files[0];
      this.formData = new FormData();
      this.formData.append("file", file);
    },

    startUpload() {
      axios({
        url: "http://localhost:8080/api/upload",
        method: "POST",
        data: this.formData,
        headers: {
          Accept: "application/json",
          "Content-Type": "multipart/form-data",
        },
      }).then((response) => {
        console.log(response);
      });
    },
  },

  mounted() {
    axios
      .get(`http://localhost:8080/api/listing/${listingID}`)
      .then((res) => {
        this.list = res.data.reviews;
      })
      .catch((err) => Promise.reject(err));

    axios
      .get(`http://localhost:8080/api/listing/${listingID}`)
      .then((res) => {
        this.reviewList = res.data.reviews;

        const totalRatings = this.reviewList.reduce(
          (acc, { rating }) => (acc += Number(rating)),
          0
        );
        this.overallRating = totalRatings / this.reviewList.length;

        const totalCleanlinessRt = this.reviewList.reduce(
          (acc, { cleanlinessRating }) => (acc += Number(cleanlinessRating)),
          0
        );
        this.averageCleanliness = totalCleanlinessRt / this.reviewList.length;

        const totalCommunicationRt = this.reviewList.reduce(
          (acc, { communicationRating }) =>
            (acc += Number(communicationRating)),
          0
        );
        this.averageCommunication =
          totalCommunicationRt / this.reviewList.length;

        const totalCheckInRt = this.reviewList.reduce(
          (acc, { checkInRating }) => (acc += Number(checkInRating)),
          0
        );
        this.averageCheckIn = totalCheckInRt / this.reviewList.length;

        const totalAccuracyRt = this.reviewList.reduce(
          (acc, { accuracyRating }) => (acc += Number(accuracyRating)),
          0
        );
        this.averageAccuracy = totalAccuracyRt / this.reviewList.length;

        const totalLocationRt = this.reviewList.reduce(
          (acc, { locationRating }) => (acc += Number(locationRating)),
          0
        );
        this.averageLocation = totalLocationRt / this.reviewList.length;

        const totalValueRt = this.reviewList.reduce(
          (acc, { valueRating }) => (acc += Number(valueRating)),
          0
        );
        this.averageValue = totalValueRt / this.reviewList.length;
      })
      .catch((err) => Promise.reject(err));
  },
  

  computed: {
    filteredReviews (){
    if(this.search){
      return this.list.filter((item)=>{
        return item.reviewer.description.includes(this.search);
      })
      }else{
        return this.list;
      }
    }
  }
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

.reviewerInfo {
  display: inline-block;
}

.left,
.right {
  width: 50%;
  float: left;
}

.rightImage,
.leftInfo{
  width: 20%;
  float: left;
}

.leftRating{
float: left;
    margin-right: 17px;
}

.rightSearch{
    float: right;

}

.rightImageDialog,
.leftInfoDialog{
width: 10%;
  float: left;
}
.avRatingView{
  font-weight: bold;
  font-size: 25px;
  margin-left:0.5em;
  
}

.avRatingViewDialog{
  font-weight: bold;
  font-size: 30px;
  margin-left:0.5em;
}

label {
  position: relative;
}

label:before {
  content: "";
  position: absolute;
  left: 10px;
  top: 0;
  bottom: 0;
  width: 20px;
  background: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='25' height='25' viewBox='0 0 25 25' fill-rule='evenodd'%3E%3Cpath d='M16.036 18.455l2.404-2.405 5.586 5.587-2.404 2.404zM8.5 2C12.1 2 15 4.9 15 8.5S12.1 15 8.5 15 2 12.1 2 8.5 4.9 2 8.5 2zm0-2C3.8 0 0 3.8 0 8.5S3.8 17 8.5 17 17 13.2 17 8.5 13.2 0 8.5 0zM15 16a1 1 0 1 1 2 0 1 1 0 1 1-2 0'%3E%3C/path%3E%3C/svg%3E") center / contain no-repeat;
}

input {
  padding: 10px 150px;
}
.name{
  font-size: 1.3rem;

}
/* .showBtn{
  float:left;
  width: 200px; 
  height: 50px;
} */
.showBtn {
  border-radius: 12px;
  background-color: white;
  padding: 10px;
  border: 1px solid;
    float:left;

  width: 200px; 
  height: 50px;
}
.showBtn:hover {
  background-color: #d0e7ee;
}


.ratingDialog {
    box-sizing: border-box;
    text-align: center;
}
</style>
