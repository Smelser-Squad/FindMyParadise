<template>
    Things to Know
    <div id="thingsToKnow">
        <div id="houseRules">
            House rules
        </div>
        <div id="healthAndSafety">
            Health and Safety
        </div>
        <div id="cancellation">
            Cancellation policy
        </div>
    </div>
</template>

<script>
import axios from "axios";

let listingID = 1;
export default {
    data() {
        
    },
    mounted(){
        axios.get(`http://localhost:8080/api/listing/${listingID}`).then((res) => {
            this.dataObject = res.data;
        })
    },
    methods : {

    }
}
</script>

<style scoped>

#thingsToKnow {
    width: 100%;
    height: 100%;
}

#houseRules {
    width: 33%;
    height: 100%;
    display: inline-block;
}

#healthAndSafety {
    width: 33%;
    height: 100%;
    display: inline-block;
}

#cancellation {
    width: 33%;
    height: 100%;
    display: inline-block;
}

</style>