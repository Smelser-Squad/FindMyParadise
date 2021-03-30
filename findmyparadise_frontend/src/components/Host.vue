<template>
    <div id="host">
        <h1>{{ dataObject.name }}{{ hostId }}</h1>
    </div>

</template>

<script>
import axios from "axios";

let hostId = 1;
export default {
    name: "Host",
    data(){
        return {
            dataObject: {},
            overlay: false,
        };
    },
    mounted(){
        axios.get(`http://localhost:8080/api/host/${hostId}`).then((res) => {
            this.dataObject = res.data;
            console.log(res.data);
        });
    },
    methods: {
        
    }
}

</script>
