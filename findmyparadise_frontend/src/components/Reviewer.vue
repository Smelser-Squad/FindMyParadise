<template>
  <div>
    <button @click="addReview()"></button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Review",
  data() {
    return {
      reviewers: null,
    };
  },
  mounted() {
    axios
      .post("http://localhost:8080/api/addReviewer")
      .then((response) => {
        this.reviewers = console.log(response)
        // .catch(error => this.reviewers = [{name : 'No reviewer is found'}])
        .finally(() => console.log('Data oading complete')); 
        
      })
      .catch((err) => Promise.reject(err));
  },
};
</script>
