<template>
    <div> 
        <button @click="addReview()"> </button>
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
      .post("http://localhost:8080/api/addReviewer")
      .then((res) => {
        console.log(res.data);
      })
      .catch((err) => Promise.reject(err));
  },
  
};
</script>