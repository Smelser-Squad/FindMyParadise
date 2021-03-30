<template>
    <div id="description" v-if="dataObject != {}">
        <h4>{{dataObject.name}}</h4>
        <p v-if="dataObject.reviews != undefined">{{dataObject.reviews.length}} reviews - <u>{{dataObject.address}}</u></p>
        <hr />
        <h5 style="display: inline" v-if="dataObject.host != undefined">{{dataObject.type}} hosted by {{dataObject.host.hostName}}</h5>
        <img class="host_img" v-if="dataObject.host != undefined" :src="dataObject.host.imageSrc">
        <p>{{dataObject.maxGuests}} guests - {{dataObject.bedrooms}} bedrooms - {{dataObject.bathrooms}} bathrooms</p>
        <hr />
        <p>{{dataObject.description}}</p>
        <span @click="showEmail()"><u>Contact Host</u></span>
    </div>
</template>

<script>
    import axios from 'axios';
    let listingID = 1;
    export default {
        name: "Description",
        data() {
            return {
                dataObject: {},
                overlay: false
            };
        },
        mounted() {
            axios.get(`http://localhost:8080/api/listing/${listingID}`).then((res) => {
                this.dataObject = res.data;
                console.log(res.data);
            });
        },
        methods: {
            showEmail() {
                this.overlay = !this.overlay;
                console.log(this.overlay);
            }
        }
    }
</script>

<style scoped>
    img {
        height: 50px;
        width: 50px;
        border-radius: 50%;
        display: inline;
        float: right;
    }
</style>