<template>
    <div id="description">
        <h4>{{dataObject.name}}</h4>
        <span v-if="dataObject.reviews != undefined">{{dataObject.reviews.length}} reviews - <u>{{dataObject.address}}</u></span>
        <h5 v-if="dataObject.host != undefined">{{dataObject.type}} hosted by {{dataObject.host.hostName}}</h5>
        <span>{{dataObject.maxGuests}} guests - {{dataObject.bedrooms}} bedrooms - {{dataObject.bathrooms}} bathrooms</span>
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
</style>