<template>
  <form>
    <!-- <label>Reviewer Name</label>
        <input type="text" required v-model="name"> -->
  </form>
  <div>
    <li v-for="review in reviews" :key="review">
      Accuracy Rating :
      {{ review.accuracyRating }}
    </li>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Review",
  data() {
    return {
      reviews: null,
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/api/reviews")
      .then((res) => {
        // console.log(res.data);
        this.reviews = res.data;
      })
      .catch((err) => Promise.reject(err));
  },
};
</script>
