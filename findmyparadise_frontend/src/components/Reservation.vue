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

      <h4>CheckIn:</h4><input disabled v-model="form.checkInDate"/>
       <h4>CheckOut:</h4><input disabled v-model="form.checkOutDate" />
     
        <h5>Guests:</h5>
        <Guests @iAQty="increaseAQty($event)" @dAQty="decreaseAQty($event)" 
        @iCQty="increaseCQty($event)" @dCQty="decreaseCQty($event)" 
        @iIQty="increaseIQty($event)" @dIQty="decreaseIQty($event)"/>
 <span style="display:none;"> Start Date: {{updateDate(dateStart)}}</span>
        <br/>
        <p> {{maxGuests}} guests maximum, infants don't count towards number of guests</p>
        <span style="display:none;"> {{updateDate(dateEnd)}}</span>
       <span>{{updateDays(days)}}</span>
      
      
      


  

        <h4>Guests:</h4>
        <br />
        <Guests
          @iAQty="increaseAQty($event)"
          @dAQty="decreaseAQty($event)"
          @iCQty="increaseCQty($event)"
          @dCQty="decreaseCQty($event)"
          @iIQty="increaseIQty($event)"
          @dIQty="decreaseIQty($event)"
        />
        <span style="display: none">
          Start Date: {{ updateDate(dateStart) }}</span
        >
        <br />
        <p>
          <b>
            {{ maxGuests }} Guests maximum, infants don't count towards number
            of guests.
          </b>
        </p>
        <span style="display: none"> {{ updateDate(dateEnd) }}</span>
        <span>{{ updateDays(days) }}</span>

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

      
        <div>
          <u>${{ dailyPrice }} x {{ NumOfDays }} nights</u>
          <span>${{ dailyPrice * NumOfDays }}</span>
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
      
      <hr />
      <p>
        <b>
          Total: ${{ form.price



      <div>
        <u>${{ dailyPrice }} x {{ NumOfDays }} Nights : </u>
        <span>${{ dailyPrice * NumOfDays }}</span>
      </div>
      <div class="popup" @click="CleaningFeepopup()">
        <u>Cleaning Fee :</u> <span> ${{ cleaningFee }}</span>
        <span class="popuptext" id="CleaningFeepopup"
          >One-time fee charged by host to cover the cost of cleaning their
          space.</span
        >
      </div>
      <br />
      <div class="popup" @click="ServiceFeepopup()">
        <u>Service Fee :</u><span> ${{ serviceFee }}</span>
        <span class="popuptext" id="ServiceFeepopup"
          >The service fee, which the host has decided to pay, helps us run our
          platform and offer services like 24/7 support on your trip.</span

        >
      </div>
      <br />
      <div>
        <u>Occupancy Taxes & Fees :</u>
        <span> ${{ occupancyFee }} </span>
      </div>
      <br />
      <p id="totalPrice">
        <b> Total: ${{ form.price }}</b>
      </p>
    </body>
  </div>
</template>
<script>
import Guests from "./Guests";
import axios from "axios";
import moment from "moment";

export default {
  name: "Reservation",
  props: ["dateStart", "dateEnd", "days"],
  data() {
    return {
      dailyPrice: "",
      cleaningFee: "",
      occupancyFee: "",
      serviceFee: "",
      reviewsNum: "",
      maxGuests: "",
      NumOfDays: 1,
      form: {
        checkInDate: "",
        checkOutDate: "",
        adults: 1,
        children: 0,
        infants: 0,
        price: "",
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
    axios.get(`http://54.91.69.145:80/api/listing/${this.$route.params.listingId}`).then((res) => {
      this.maxGuests=res.data.maxGuests;

      this.dailyPrice = res.data.price;
      this.cleaningFee = res.data.cleaningFee;
      this.occupancyFee = res.data.occupancyFee;
      this.serviceFee = res.data.serviceFee;
      this.reviewsNum = res.data.reviews.length;
      this.form.price =
        (this.dailyPrice * this.NumOfDays) +
        this.serviceFee +
        this.cleaningFee +
        this.occupancyFee
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

        .post(`http://54.91.69.145:80/api/reservation/${this.$route.params.listingId}`, this.form)

        .then((res) => {
          console.log(res.data);
        });
    },
    increaseAQty(num) {
      this.form.adults = num + 1;
    },
    decreaseAQty(num) {
      this.form.adults -= num;
    },
    increaseCQty(num) {
      this.form.children = num + 1;
    },
    decreaseCQty(num) {
      this.form.children = num;
    },
    increaseIQty(num) {
      this.form.infants = num + 1;
    },
    decreaseIQty(num) {
      this.form.infants -= num;
    },
    updateDate(date) {
      let dateSub = date;
      this.form.checkInDate = moment(this.dateStart).format("MM-DD-YYYY");
      this.form.checkOutDate = moment(this.dateEnd).format("MM-DD-YYYY");
      return dateSub;
    },
    updateDays(num) {
      if (num == 0) {
        this.NumOfDays = 1;
      } else {
        this.NumOfDays = num;
      }
      this.form.price =
        (this.dailyPrice * this.NumOfDays) +
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
  border: 5px solid rgb(209, 60, 110);
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