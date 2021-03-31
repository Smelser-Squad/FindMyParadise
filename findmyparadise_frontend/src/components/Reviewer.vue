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
        placeholder="Write Rating Description"
        v-model="posts.description"
      />
      <br />
      <br />
      <input
        type="text"
        name="imageSrc"
        placeholder="Upload Image"
        v-model="posts.imageSrc"
      />
      <br />
      <br />

      <date-picker
        class="datePicker"
        v-model="posts.joinedDate"
        lang="en"
        type="date"
        format="MM-dd-YYYY"
      ></date-picker>

      <button type="submit">Add Review</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import DatePicker from "vue3-datepicker";

export default {
  name: "Review",
  components: {
    DatePicker,
  },
  data() {
    return {
      posts: {
        name: null,
        imageSrc: null,
        description: null,
        joinedDate: null,
      },
    };
  },
  methods: {
    postData(e) {
      axios
        .post("http://localhost:8080/api/addReviewer", this.posts)
        .then((result) => {
          // console.log(result);
          console.warn(result);
        });
      e.preventDefault();
    },
  },

  // mounted() {
  //   axios
  //     .post("http://localhost:8080/api/addReviewer")
  //     .then((response) => {
  //       this.reviewers = console.log(response)
  //       .finally(() => console.log('Data oading complete'));

  //     })
  //     .catch((err) => Promise.reject(err));
  // },
};
</script>
