<template>
  <div>
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
      <!-- <input
        type="text"
        name="imageSrc"
        placeholder="Upload Image"
        v-model="posts.imageSrc"
      /> -->

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
  </div>

  <h3>Review Details</h3>

  <div>
    <svg
      viewBox="0 0 1000 1000"
      role="presentation"
      aria-hidden="true"
      focusable="false"
      style="height: 14px; width: 14px; fill: red"
    >
      <path
        d="M972 380c9 28 2 50-20 67L725 619l87 280c11 39-18 75-54 75-12 0-23-4-33-12L499 790 273 962a58 58 0 0 1-78-12 50 50 0 0 1-8-51l86-278L46 447c-21-17-28-39-19-67 8-24 29-40 52-40h280l87-279c7-23 28-39 52-39 25 0 47 17 54 41l87 277h280c24 0 45 16 53 40z"
      ></path>
    </svg>
    <span> {{ overallRating }} ({{ list.length }} Reviews)</span>
  </div>

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
    <img :src="reviewer.imageSrc" />

    <h3>{{ reviewer.name }}</h3>
    <p>{{ reviewer.joinedDate }}</p>

    <br />
    <p>{{ reviewer.description }}</p>

    <button class="showBtn" @click="() => TogglePopup('buttonTrigger')">
      Show all Review Deatails
    </button>

    <Modal
      v-if="popupTriggers.buttonTrigger"
      :TogglePopup="() => TogglePopup('buttonTrigger')"
    >
      <h3>Reviews</h3>
      <br />
      <ul>
        <li v-for="reviewer in list" :key="reviewer">
          <img :src="reviewer.imageSrc" />

          {{ reviewer.name }}
          <br />
          {{ reviewer.joinedDate }}

          <br />
          <p>{{ reviewer.description }}</p>

          <hr />
        </li>
      </ul>
    </Modal>
  </div>
</template>

<script>
import axios from "axios";
import { ref } from "vue";
import Modal from "./Modal";
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
      .get("http://localhost:8080/api/reviewers")
      .then((res) => {
        console.log(res.data);
        this.list = res.data;
      })
      .catch((err) => Promise.reject(err));

    axios
      .get("http://localhost:8080/api/reviews")
      .then((res) => {
        console.log(res.data);
        this.reviewList = res.data;

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
</style>
