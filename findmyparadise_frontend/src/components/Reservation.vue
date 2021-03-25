<template>
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
    <h3>Check-In</h3>

    <Calendar />
    <h3>Check-Out</h3>
    <Calendar />
    <h3>Guests</h3>
    <select>
      <option> 1 guest</option>
     
    </select>
    <Guests/>

    <button class="btn" @click="OnClick()">Reserve</button>
    <p>  You won't be charged yet</p>

    <a href=""> Cleaning Fee</a>
    <br/>
     <a href=""> Service Fee</a>
     <hr/>
     <p> <b> Total: </b> </p>
  </body>
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
</style>
