<template>
    Things to Know
    <br />
    <div id="thingsToKnow">
        <div id="houseRules">
            House rules
        </div>
        <div id="healthAndSafety">
            Health and Safety
        </div>
        <div id="cancellation">
            <p>Cancellation policy</p>
            <span>You have until {{ updateDate(dateStart) }} to cancel your reservation</span>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import moment from "moment";


export default {
    props : ["dateStart"],
    data() {
        
    },
    mounted(){
        axios.get(`http://54.91.69.145:80/api/listing/${this.$route.params.listingId}`).then((res) => {
            this.dataObject = res.data;
        })
    },
    methods : {
        updateDate(date) {
        return moment(date).format("MM-DD");
        },
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