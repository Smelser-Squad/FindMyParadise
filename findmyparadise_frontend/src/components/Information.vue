<template>
    <div id="Information">
        <h2>Things to Know</h2>
        <div class="innerDiv">
            <div class="title">
                <span>House rules</span>
            </div>
            <ul>
                <li v-for="rule in rules" :key="rule">
                    <svg xmlns="http://www.w3.org/2000/svg">
                    <path v-bind:d="setDPath(rule.ruleValue)"></path>
                    </svg>
                    {{rule.ruleValue}}
                </li>
            </ul>
        </div >
        <div class="innerDiv">
            <div class="title">
                <span>Health & safety</span>
            </div>
        <span>Check-in: {{ checkIn }}</span> <br>
        <span>Check-out: {{ checkOut }}</span> <br>
        <li v-for="health in healthRules" :key="health">
            {{health.healthValue}} 
        </li>
        </div>
    </div>
</template>

<script>
import axios from "axios";
let listingID = 2;

export default{
    name: "Information",
    data(){
        return {
            listing: [],
            rules: [],
            healthRules: [],
            checkIn: "",
            checkOut: "",
            dPath: ""
        }
    },
    mounted(){
        axios
        .get(`http://54.91.69.145:80/api/listing/${listingID}`)
        .then((res) => 
        {
            this.listing = res.data.listing;
            this.checkIn = res.data.checkIn;
            this.checkOut = res.data.checkOut;
            this.rules = res.data.rules;
            this.healthRules = res.data.healthRules;
            console.log("Getting data...");
            console.log(res.data);
        })
        .catch((err) => Promise.reject(err));
    },
    methods:{
        setDPath(name)
        {
            switch(name)
            {
                case "Check-in":
                case "Check-out":
                    this.dPath = ""
                    break;
                case "No pets":
                    this.dPath = "M3.707 2.293l26 26-1.414 1.414-26-26 1.414-1.414zm8.164 13.821l11.149 11.15a3.993 3.993 0 0 1-3.053.612l-.234-.055L16 26.82l-3.733 1.001a4 4 0 0 1-2.941-.347l-.204-.118-.197-.131a4 4 0 0 1-1.08-5.398l.119-.177 3.907-5.536zM27 12a4 4 0 1 1 0 8 4 4 0 0 1 0-8zM5 12a4 4 0 1 1 0 8 4 4 0 0 1 0-8zm16-8a4 4 0 1 1 0 8 4 4 0 0 1 0-8zM11 4a4 4 0 0 1 3.381 6.138l-5.52-5.519A3.981 3.981 0 0 1 11 4z"
                    break;
                case "No smoking":
                    this.dPath = ""
                    break;
                    default:
                    this.dPath = ""
                    break;
            }
            return this.dPath;
        }
    }

};

</script>

<style>
.innerDiv{
    display: inline-block;
    width: 300px;

}
svg {
  width: 35px;
  height: 35px;
}

.title
{
    font-weight: 600;
}

li 
{
    list-style: none;
}
</style>