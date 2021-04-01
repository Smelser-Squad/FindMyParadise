<template>
  <div id="Resrevation body">
    <header>
      <h2>
        <b>${{dailyPrice}}</b> / night
      </h2>
      <div>
       
        <span style="color:gray;"> ({{reviewsNum}}) reviews</span
        >
      </div>
    </header>
    <body>
      <form v-on:submit.prevent="submitForm">
      
        <h5>Guests:</h5>
        <Guests v-on:Qty="updateQty($event)" />

      <div v-if="showCalendar" ><DateRangePicker v-on:datePickIn="updateDatesIn($event)" v-on:datePickOut="updateDatesOut($event)" v-on:differeceDays="updateNights($event)"/></div>
      
      <h3>CheckIn:</h3><input disabled v-model="form.CheckIn"/>
       <input disabled v-model="form.CheckOut" />

     

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
      <hr />
      <p>
        <b>
          Total: ${{ form.TotalPrice
          }}</b
        >
      </p>
    </body>
  </div>
</template>
<script>
import Guests from "./Guests";
import axios from "axios";
import DateRangePicker from "./DateRangePicker";


let listingID = 1;

export default {
  name: "Reservation",
  

  data() {
    return {
      showCalendar: true,
      details: false,
      dataObject: {},
      dailyPrice:'',
      cleaningFee:'',
      occupancyFee:'',
      serviceFee:'',
      reviewsNum:'',
      form:{
        CheckIn:'',
        CheckOut:'',
        NumAdults:'',
        NumChildren:'',
        NumInfants:'',
        NumOfDays:1,
        TotalPrice:''
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
      this.cleaningFee=res.data.cleaningFee;
      this.occupancyFee=res.data.occupancyFee;
      this.serviceFee=res.data.serviceFee;
      this.reviewsNum=res.data.reviews.length;
      this.form.TotalPrice=(this.dailyPrice*this.form.NumOfDays) +this.serviceFee + this.cleaningFee + this.occupancyFee;
      
      
   
    });
  },

  components: {
    Guests,
    DateRangePicker,
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
          console.log(res);
        });
        console.log(this.form);
    },
    showDetails() {
      this.details= true;
    },
    updateDatesIn(start) {
      this.range.start = start;
      this.form.CheckIn= start.toString().substring(0, 15);
      // this.form.CheckOut=this.range.end;
    },
    updateDatesOut(end) {
      
      this.form.CheckOut=end.toString().substring(0, 15);

  },
  updateNights(nights){
    this.form.NumOfDays=nights;
  
  },
  updateQty(num){
    this.form.NumAdults=num;
  }
  }
};
</script>
<style scoped>
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}
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
