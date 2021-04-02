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


  <div v-for="reviewer in list.slice(0, 1)" v-bind:key="reviewer.reviewId">
    <p>Name: {{ reviewer.name }}</p>
    <p>Description: {{ reviewer.description }}</p>
    <p>Date: {{ reviewer.joinedDate }}</p>

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
          {{ reviewer.name }}
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
  name: "Review",
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
  },
};
</script>
