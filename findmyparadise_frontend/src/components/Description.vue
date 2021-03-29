<template>
    <div id="description">
        <span>Hello World!</span>
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
            };
        },
        mounted() {
            axios.get(`http://localhost:8080/api/listing/${listingID}`).then((res) => {
            this.dataObject = res.data;
            console.log(res.data);
    });
        }
    }
</script>

<style scoped>

</style>