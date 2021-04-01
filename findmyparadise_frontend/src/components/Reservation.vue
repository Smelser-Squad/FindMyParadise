<template>
  <div>
    <header>
      <h2>
        <b>${{ dataObject.price }}</b> / night
      </h2>
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
        <span v-if="dataObject.reviews != undefined"
          >{{ dataObject.reviews[0].rating }} ({{
            dataObject.reviews.length
          }})</span
        >
      </div>
    </header>
    <body>
      <form v-on:submit.prevent="submitForm">

        <div class="split">
          <div class="split-left">
            <h5>Guests:</h5>
            <Guests />
          </div>
          <div class="split-right">
            <h5>Dates</h5>
          </div>

          <div v-if="showCalendar">
            <DateRangePicker v-on:datePick="updateDates($event)" />
          </div>
        </div>
        <span> Start Date: {{ range.start }} </span>


       
       
        <br/>
        <span> End Date: {{updateDate(dateEnd)}}</span>

        <span
          class="_19di23v"
          style="
            background-position: calc((100 - var(--mouse-x, 0)) * 1%)
              calc((100 - var(--mouse-y, 0)) * 1%);
            --mouse-x: 25.2363;
            --mouse-y: 83.3333;
          "
        ></span>
        <button
          class="btn"
          type="submit"
          style="width: 420px; text-align: center"
          @click="OnClick()"
        >
          Reserve
        </button>
      </form>
      <p style="color: gray; text-align: center">You won't be charged yet</p>
      <u @click="ShowDetals()"><b> Show price details</b></u>
      <div v-if="show">
        <div>
          <u>${{ dataObject.listing.price }} x {{ form.NumOfDays }} nights</u>
          <span>${{ dataObject.price * form.NumOfDays }}</span>
        </div>

        <div class="popup" @click="CleaningFeepopup()">
          <u>Cleaning Fee</u> <span> ${{ dataObject.cleaningFee }}</span>
          <span class="popuptext" id="CleaningFeepopup"
            >The service fee, which the host has decided to pay, helps us run
            our platform and offer services like 24/7 support on your
            trip.</span
          >
        </div>
        <br />
        <div class="popup" @click="ServiceFeepopup()">
          <u>Service Fee</u><span> ${{ dataObject.serviceFee }}</span>
          <span class="popuptext" id="ServiceFeepopup"
            >One-time fee charged by host to cover the cost of cleaning their
            space.</span
          >
        </div>
        <br />
        <div>
          <u>Occupancy taxes and fees</u>
          <span> ${{ dataObject.occupancyFee }} </span>
        </div>
      </div>
      <hr />
      <p>
        <b>
          Total: ${{
            dataObject.price +
            dataObject.cleaningFee +
            dataObject.serviceFee +
            dataObject.occupancyFee
          }}</b
        >
      </p>
    </body>
  </div>
</template>
<script>
import Guests from "./Guests";
import axios from "axios";
// import DateRangePicker from "./DateRangePicker";

let listingID = 1;

export default {
  name: "Reservation",
  props: {
    dateStart: new Date(),
    dateEnd: new Date()
  },

  data() {
    return {
      showCalendar: true,
      show: false,
      date: new Date(),
      dataObject: {},
      form: {
        CheckIn: "2",
        CheckOut: "",
        NumAdults: "",
        NumChildren: "",
        NumInfants: "",
        NumOfDays: 1,
        TotalPrice: "",
      },
      range: {
        start: new Date(),
        end: new Date(),
      },

      startDateStr: "",
      endDateStr: "",
    };
  },
  mounted() {
    axios.get(`http://localhost:8080/api/listing/${listingID}`).then((res) => {
      this.dataObject = res.data;
      console.log(res.data);
      console.log(this.date1);
    });
  },

  components: {
    Guests,
  },
  methods: {
    OnClick() {
      console.log("Reserve");
    },
    CleaningFeepopup() {
      let popup = document.getElementById("CleaningFeepopup");
      popup.classList.toggle("show");
    },
    ServiceFeepopup() {
      let popup = document.getElementById("ServiceFeepopup");
      popup.classList.toggle("show");
    },
    submitForm() {
      axios
        .post("http://localhost:8080/api/reservation", this.form)
        .then((res) => {
          console.log(res);
        });
    },
    ShowDetals() {
      this.show = true;
    },
    updateDate(date) {
      let dateSub = date.toString().substring(0, 15);
      return dateSub;
      
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
/* .split {
  display: flex;
}
.split .split-left {
  flex: 1;
}
.split .split-right {
  flex: 1;
} */
.popup {
  position: relative;
  display: inline-block;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}
.popup .popuptext {
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
.popup .show {
  visibility: visible;
  -webkit-animation: fadeIn 1s;
}
@-webkit-keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
@keyframes fadein {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
</style>
