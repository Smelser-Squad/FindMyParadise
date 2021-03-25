<template>
<div id="Resrevation body">
  <header>
    <h2> <b>$ 199</b> / night</h2>
    <div>
              <svg
                viewBox="0 0 1000 1000"
                role="presentation"
                aria-hidden="true"
                focusable="false"
                style="height: 14px; width: 14px; fill: red"
              >
                <path
                  d="M972 380c9 28 2 50-20 67L725 619l87 280c11 39-18 75-54 75-12 0-23-4-33-12L499 790 273 962a58 58 0 0 1-78-12 50 50 0 0 1-8-51l86-278L46 447c-21-17-28-39-19-67 8-24 29-40 52-40h280l87-279c7-23 28-39 52-39 25 0 47 17 54 41l87 277h280c24 0 45 16 53 40z"
                ></path>
              </svg>
              4.95 (20)
            </div>
  </header>
  <body>
    <h5>Check-In</h5>

    <Calendar />
    <h5>Check-Out</h5>
    <Calendar />
    <h5>Guests</h5>
    <select>
      <option> 1 guest</option>
     
    </select>
    <Guests/>
<span class="_19di23v" style="background-position: calc((100 - var(--mouse-x, 0)) * 1%) calc((100 - var(--mouse-y, 0)) * 1%); --mouse-x:25.2363; --mouse-y:83.3333;"></span>
    <button class="btn" @click="OnClick()">Reserve</button>
    <p>  You won't be charged yet</p>

    <div class="popup" @click="CleaningFeepopup()"> <u>Cleaning Fee</u>
    <span class="popuptext" id="CleaningFeepopup">The service fee, which the host has decided to pay, helps us run our platform and offer services like 24/7 support on your trip.</span>
    </div>
    <br/>
     <div class="popup" @click="ServiceFeepopup()"> <u>Service Fee</u>
     <span class="popuptext" id="ServiceFeepopup">One-time fee charged by host to cover the cost of cleaning their space.</span>
     </div>
     <br/>
       <div> <u>Occupancy taxes and fees</u></div>
    
     <hr/>
     <p> <b> Total: </b> </p>
  </body>
  </div>
</template>
<script>
import Calendar from "./Calendar";
import Guests from './Guests';


export default {
  name: "Reservation",
  props: {
    title: String,
  },

  components: {
    Calendar,
    Guests
  
  },
  methods: {
    OnClick() {
      console.log("Reserve");
    },
    CleaningFeepopup(){
      let popup=document.getElementById("CleaningFeepopup");
      popup.classList.toggle("show")
    },
    ServiceFeepopup(){
       let popup=document.getElementById("ServiceFeepopup");
      popup.classList.toggle("show")
    }
  },
};
</script>
<style scoped>
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}
.popup{
  position: relative;
  display: inline-block;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}
.popup .popuptext{
  visibility: hidden;
  width: 160px;
  background-color: whitesmoke;
  color: black;
  text-align: center;
  border-radius: 6px;
  padding: 8px 0;
  position: absolute;
  z-index: 1;
  bottom: 125%;
  left: 50%;
  margin-left: -80px;
}
.popup .show{
  visibility: visible;
  -webkit-animation: fadeIn 1s;

}
@-webkit-keyframes fadeIn{
  from{opacity: 0;}
  to{opacity: 1;}
}
@keyframes fadein{
  from{opacity: 0;}
  to{opacity: 1;}
}
</style>
