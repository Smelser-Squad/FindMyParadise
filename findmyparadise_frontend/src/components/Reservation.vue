<template>
  <div>
    <header>
      <h2>
        <b>${{ dailyPrice }}</b> / night
      </h2>
      <div>
        <span style="color: gray"> ({{ reviewsNum }}) reviews</span>
      </div>
    </header>
    <body id="ReservationBody">
      <form v-on:submit.prevent="submitForm" method="post">
        <h5>Guests:</h5>
        <Guests
          @iAQty="increaseAQty($event)"
          @dAQty="decreaseAQty($event)"
          @iCQty="increaseCQty($event)"
          @dCQty="decreaseCQty($event)"
          @iIQty="increaseIQty($event)"
          @dIQty="decreaseAQty($event)"
        />
        <br>
        <span style="display:none;"> Start Date: {{ updateDate(dateStart) }}</span>
        <br />

        <br>
        <span>{{ updateDays(days) }}</span>
        <br>
        <h4>CheckIn:</h4>
        <input disabled v-model="form.CheckIn" />
        <span style="display:none;"> End Date: {{ updateDate(dateEnd) }}</span>
        <h4>CheckOut:</h4>
        <input disabled v-model="form.CheckOut" />
        <br>
        <br />
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
        >
          Reserve
        </button>
      </form>
      <p style="color: gray; text-align: center">You won't be charged yet</p>
      <u @click="showDetails()"><b> Show price details</b></u>
      <div v-if="details">
        <div>
          <u>${{ dailyPrice }} x {{ form.NumOfDays }} nights</u>
          <span>${{ dailyPrice * form.NumOfDays }}</span>
        </div>

        <div class="popup" @click="CleaningFeepopup()">
          <u>Cleaning Fee</u> <span> ${{ cleaningFee }}</span>
          <span class="popuptext" id="CleaningFeepopup"
            >One-time fee charged by host to cover the cost of cleaning their
            space.</span
          >
        </div>
        <br />
        <div class="popup" @click="ServiceFeepopup()">
          <u>Service Fee</u><span> ${{ serviceFee }}</span>
          <span class="popuptext" id="ServiceFeepopup"
            >The service fee, which the host has decided to pay, helps us run
            our platform and offer services like 24/7 support on your
            trip.</span
          >
        </div>
        <br />
        <div>
          <u>Occupancy taxes and fees</u>
          <span> ${{ occupancyFee }} </span>
        </div>
      </div>
      <br>
      <p id = "totalPrice">
        <b> Total: ${{ form.TotalPrice }}</b>
      </p>
    </body>
  </div>
</template>
<script>
import Guests from "./Guests";
import axios from "axios";
import moment from "moment";
let listingID = 1;
export default {
  name: "Reservation",
  props: ["dateStart", "dateEnd", "days"],
  data() {
    return {
      showCalendar: true,
      details: false,
      date: new Date(),
      dataObject: {},
      dailyPrice: "",
      cleaningFee: "",
      occupancyFee: "",
      serviceFee: "",
      reviewsNum: "",
      form: {
        CheckIn: "",
        CheckOut: "",
        NumAdults: 1,
        NumChildren: 0,
        NumInfants: 0,
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
      this.dailyPrice = res.data.price;
      this.cleaningFee = res.data.cleaningFee;
      this.occupancyFee = res.data.occupancyFee;
      this.serviceFee = res.data.serviceFee;
      this.reviewsNum = res.data.reviews.length;
      this.form.TotalPrice =
        this.dailyPrice * this.form.NumOfDays +
        this.serviceFee +
        this.cleaningFee +
        this.occupancyFee;
    });
  },
  components: {
    Guests,
  },
  methods: {
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
          console.log(res.data);
        });
      console.log(this.form);
    },
    ShowDetals() {
      this.show = true;
    },
    increaseAQty(num) {
      this.form.NumAdults = num + 1;
    },
    decreaseAQty(num) {
      this.form.NumAdults -= num;
    },
    increaseCQty(num) {
      this.form.NumChildren = num + 1;
    },
    decreaseCQty(num) {
      this.form.NumChildren -= num;
    },
    increaseIQty(num) {
      this.form.NumInfants = num;
    },
    decreaseIQty(num) {
      this.form.NumInfants -= num;
    },
    updateDate(date) {
      let dateSub = date;
      this.form.CheckIn = moment(this.dateStart).format("MM-DD-YYYY");
      this.form.CheckOut = moment(this.dateEnd).format("MM-DD-YYYY");
      return dateSub;
      
    },
    updateDays(num) {
      if (num == 0) {
        this.form.NumOfDays = 1;
      } else {
        this.form.NumOfDays = num;
      }
      this.form.TotalPrice =
        this.dailyPrice * this.form.NumOfDays +
        this.serviceFee +
        this.cleaningFee +
        this.occupancyFee;
    },
  },
};
</script>
<style scoped>
#totalPrice {
  margin-top: 20px;
  border: 5px solid black;
  border-radius: 50%;
  padding-top: 20px;
  padding-bottom: 20px;
  margin-left: 40%;
  margin-right: 40%;
}
#ReservationBody {
  background: whitesmoke !important;
}
#ReservationBody {
  margin: auto;
  text-align: center;
}
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
