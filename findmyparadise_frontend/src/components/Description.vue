<template>
    <div id="description">
        
    </div>
</template>

<script>
    export default {
        name: "Description"
        data() {
            return {
                dataObject: {},
            };
        },
        mounted() {
            axios.get(`http://localhost:8080/api/listing/${listingID}`).then((res) => {
            this.dataObject = res.data
            console.log(res.data);
    });
        }
    }
</script>