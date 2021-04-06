<template>
    <div id="Information">
        <h2>Things to Know</h2>
        <div class="innerDiv">
            <div class="title">
                <span>House rules</span>
            </div>
            <ul>
                <li>
                    <svg xmlns="http://www.w3.org/2000/svg">
                    <path v-bind:d="setDPath('Check-in')"></path>
                    </svg> 
                    Check-in: {{checkIn}}
                </li>                
                <li>
                    <svg xmlns="http://www.w3.org/2000/svg">
                    <path v-bind:d="setDPath('Check-out')"></path>
                    </svg>
                    Check-out: {{checkOut}}  
                </li>
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

        <li v-for="health in healthRules" :key="health">
            <svg xmlns="http://www.w3.org/2000/svg">
            <path v-bind:d="setDPath(health.healthName)"></path>
            </svg>
            {{health.healthValue}} 
        </li>
        </div>
    </div>
</template>

<script>
import axios from "axios";

export default{
     name: "Information",
     props: ["listingId"],
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
        .get(`http://54.91.69.145:80/api/listing/${this.$route.params.listingId}`)
        .then((res) => 
        {
            this.listing = res.data.listing;
            this.rules = res.data.rules;
            this.healthRules = res.data.healthRules;
            this.checkIn = res.data.checkIn;
            this.checkOut = res.data.checkOut;

        })
        .catch((err) => Promise.reject(err));
    },
    methods:{
        setDPath(name)
        {
            switch(name)
            {
                case "Alarm":
                    this.dPath = "M8 .5a7.5 7.5 0 1 1 0 15 7.5 7.5 0 0 1 0-15zM5.846 9H4.515A3.632 3.632 0 0 0 7 11.485v-1.33A2.384 2.384 0 0 1 5.846 9zm5.64 0h-1.332a2.384 2.384 0 0 1-1.153 1.154v1.331A3.632 3.632 0 0 0 11.484 9zM8 7a1 1 0 1 0 0 2 1 1 0 0 0 0-2zM7 4.515A3.632 3.632 0 0 0 4.515 7h1.33A2.384 2.384 0 0 1 7 5.845zm2 0v1.33c.508.237.919.647 1.155 1.155h1.33A3.632 3.632 0 0 0 9 4.515zm3-1.265a.75.75 0 1 0 0 1.5.75.75 0 0 0 0-1.5z"
                    break;
                case "Covid-safety":
                    this.dPath = "M5 5v.414l4 4v3.172L4.464 17.12C3.527 18.06 3 18.674 3 20v9c0 1.644 1.356 2.982 3 3 6.645-.012 10.645-.012 12 0 1.657.014 3-1 3-3v-9c0-1.351-.547-2.126-1.516-3.067L15 12.577V9a2.99 2.99 0 0 1 2.083-2.842 8.957 8.957 0 0 0 2.17 4.798l1.499-1.324A6.959 6.959 0 0 1 19.078 6H23V0H10a5 5 0 0 0-5 5zm14-3h2v2h-2zm-1.032 22.686h.004c.348 0 .69-.034 1.028-.084v2.02c-.34.039-.682.064-1.028.064h-.004a8.946 8.946 0 0 1-6.362-2.636A6.948 6.948 0 0 0 6.659 22h-.003A7.07 7.07 0 0 0 5 22.204v-2.048c.54-.1 1.093-.156 1.655-.156h.005a8.94 8.94 0 0 1 6.36 2.636 6.956 6.956 0 0 0 4.948 2.05zM11 10h2v2h-2zm17-9a1 1 0 1 1 2 0 1 1 0 0 1-2 0zm2 4a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm-3-2a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"
                    break;
                case "Self check-in with lockbox":
                    this.dPath = "M27 29V3a2 2 0 0 0-2-2H7a2 2 0 0 0-2 2v26H3v2h26v-2zm-8.5-11a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zM25 29h-2V3h2z"
                    break;
                case "Check-in":
                    this.dPath = "M16 1C7.716 1 1 7.716 1 16s6.716 15 15 15 15-6.716 15-15S24.284 1 16 1zm7.895 22.954l-9.526-5.5a1.5 1.5 0 0 1-.743-1.154l-.007-.145v-11h3V16.29l8.776 5.067-1.5 2.598z"
                    break;
                case "Check-out":
                    this.dPath = "M16 1C7.716 1 1 7.716 1 16s6.716 15 15 15 15-6.716 15-15S24.284 1 16 1zm7.895 22.954l-9.526-5.5a1.5 1.5 0 0 1-.743-1.154l-.007-.145v-11h3V16.29l8.776 5.067-1.5 2.598z"
                    break;
                case "No pets":
                    this.dPath = "M3.707 2.293l26 26-1.414 1.414-26-26 1.414-1.414zm8.164 13.821l11.149 11.15a3.993 3.993 0 0 1-3.053.612l-.234-.055L16 26.82l-3.733 1.001a4 4 0 0 1-2.941-.347l-.204-.118-.197-.131a4 4 0 0 1-1.08-5.398l.119-.177 3.907-5.536zM27 12a4 4 0 1 1 0 8 4 4 0 0 1 0-8zM5 12a4 4 0 1 1 0 8 4 4 0 0 1 0-8zm16-8a4 4 0 1 1 0 8 4 4 0 0 1 0-8zM11 4a4 4 0 0 1 3.381 6.138l-5.52-5.519A3.981 3.981 0 0 1 11 4z"
                    break;
                case "No smoking":
                    this.dPath = "M24.242 19H27v2.758L24.242 19zM23 15c1.103 0 2 .897 2 2h2c0-2.206-1.794-4-4-4h-4.758l2 2H23zm6 8.758l2 2V19h-2v4.758zM18 5V3c-2.636 0-4.875 1.71-5.679 4.079l1.701 1.701C14.14 6.678 15.87 5 18 5zM4 19c-1.103 0-2 .897-2 2v4c0 1.103.897 2 2 2h19.758l-8-8H4zm25-2h2c0-3.629-2.429-6.701-5.746-7.677A3.97 3.97 0 0 0 26 7c0-2.206-1.794-4-4-4v2c1.103 0 2 .897 2 2s-.897 2-2 2v2h1c3.309 0 6 2.691 6 6zM3.293 3.707l26 26 1.414-1.414-26-26-1.414 1.414z"
                    break;
                case "Not suitable for children and infants":
                    this.dPath = "M19.862 24.105l1.535 1.536a2 2 0 0 0 2.327 2.327l1.55 1.548A4 4 0 0 1 19.365 26a3.913 3.913 0 0 1 .444-1.8l.052-.095zM11.757 16l8 8H10.81c.344.59.555 1.268.555 2a4 4 0 0 1-8 0c0-1.545.885-2.87 2.167-3.536.025-.039.05-.078.078-.116l.048-.055L9.95 18H8.364a3 3 0 0 0-1.976.743l-.145.136-3.829 3.829L1 21.294l3.829-3.83A5 5 0 0 1 8.1 16.008L8.364 16h3.393zM3.979 2.565l25.456 25.456-1.414 1.414L2.565 3.979l1.414-1.414zM7.365 24a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm23-22v2h-2.343a3 3 0 0 0-1.977.743l-.144.136-.536.535V19c0 .63-.122 1.23-.34 1.782l-8.929-8.929.06-.06-.184-.064-2.365-2.363A4 4 0 0 1 17.365 4a3.983 3.983 0 0 1 3.728 2.6l.066.192.499-.5.272-.27 2.556-2.558a5 5 0 0 1 3.271-1.457L28.022 2h2.343z"
                    break;
                case "No parties or events":
                    this.dPath = "M5.12 9.363l13.882 13.88c-.494.349-1.01.694-1.549 1.035L19.65 27.2a1.125 1.125 0 0 1-.433 1.7l-.111.043-.157.039-.04.006-.158.013H17v3h-2v-3h-1.75a1.125 1.125 0 0 1-1.117-1.264l.025-.131.067-.189.021-.045.103-.17 2.14-2.862C8.212 20.918 5 16.457 5 11c0-.556.041-1.103.12-1.637zm-1.413-7.07l26 26-1.414 1.414-26-26 1.414-1.414zM16 0c5.909 0 11 5.275 11 11 0 2.915-1.167 5.676-3.472 8.286L7.853 3.609A10.972 10.972 0 0 1 16 0zm6 7a2 2 0 1 0 0 4 2 2 0 0 0 0-4z"
                    break;
                default:
                    this.dPath = ""
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