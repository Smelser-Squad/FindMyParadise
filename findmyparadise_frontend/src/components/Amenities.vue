<template slot-scope="{amenities}">
    <div id="Amenities">
        <ul>
            <li v-for="amenity in amenities" :key="amenity">
                {{amenity.amenityName}}
            </li>
        </ul>
    </div>
</template>

<script>
    import axios from 'axios';
    export default {
        name: "Amenities",
        data() {
            return {
                amenities: [],
                amenityName: ""
            }
        },
        mounted() {
            axios
                .get("http://localhost:8080/api/amenities")
                .then((res) => {
                    console.log(res.data);
                    this.amenities = res.data;
                })
                .catch((err) => Promise.reject(err));
        }
    }
</script>
