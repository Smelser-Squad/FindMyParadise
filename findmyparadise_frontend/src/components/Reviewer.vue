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
        <input type="file" ref="uploadImage" @change="onImageUpload()" class="form-control" required>
        <input type="button" @click="startUpload" name="upload" value="Upload" />
      </form>
      <br />
      <br />

      <!-- <date-picker
        class="datePicker"
        v-model="posts.joinedDate"
        lang="en"
        type="date"
        format="MM-dd-YYYY"
      ></date-picker> -->

      <br/> 
      <button type="submit">Add Review</button>
      <br/> 
      <br/> 
    </form>
  </div>
 
  <h3>Review Details</h3>
  <div v-for="reviewer in list" v-bind:key="reviewer.reviewId"> 
    <p> Name: {{reviewer.name}}</p>
    <p> Description: {{reviewer.description}}</p>
    <p> Date: {{reviewer.joinedDate}} </p>

  </div>
 
</template>

<script>
import axios from "axios";

export default {
  name: "Review",
  
  data() {
    return {
      posts: {
        name: null,
        imageSrc: null,
        description: null,
      },
      list: undefined, 
      formData : null, 
    };
  },
 
// reviewData(){
//     return {
//       list: undefined
//     }
//   },

//  fileUploadData: ()=> ({
//     formData: null
//   }),
  


  methods: {
    postData(e) {
      axios
        .post("http://localhost:8080/api/addReviewer", this.posts)
        .then((result) => {
          console.warn(result);
        });
      e.preventDefault();
    },

    onImageUpload(){
    let file = this.$refs.uploadImage.files[0];
    this.formData = new FormData(); 
    this.formData.append("file", file); 
  },

  startUpload(){
    axios({
      url: 'http://localhost:8080/api/upload',
      method: 'POST',
      data: this.formData,
      headers: {
        Accept: 'application/json',
        'Content-Type': 'multipart/form-data'
      },
    }).then(response => {
      console.log(response)
    });
    

  }
  },

 
    mounted() {
    axios
      .get("http://localhost:8080/api/reviewers")
      .then((res) => {
        console.log(res.data);
        this.list = res.data;
      })
      .catch((err) => Promise.reject(err));
  }

  
  
 
};
</script>
