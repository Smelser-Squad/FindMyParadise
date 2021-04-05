<template>
  <div class="dateBox">
    <DatePicker
      :column="2"
      :row="1"
      is-expanded
      class="datePicker"
      v-model="range"
      is-range
      :min-date="new Date()"
      color="pink"
      :disabled-dates='
      {
        start: new Date(startYear, startMonth, startDay),
        end: new Date(endYear, endMonth, endDay)
      }'
      
    />
    <br />

    <span v-if='showDates'>Start Date: {{ updateDate(range.start) }}</span>

    <br />
    <span v-if='showDates'>End Date: {{ updateDate(range.end) }}</span>
    <br />

    <span>Number Of Days: </span>
    <span>{{ numOfDays() }}</span>
    <br />
    <button class="btn" @click="sendDate">Submit</button>

  </div>
</template>

<script>
import { DatePicker } from "v-calendar";
import moment from "moment";
import axios from "axios";


let listingID = 2;

export default {
  components: {
    DatePicker,
  },
  mounted() {
    axios.get(`http://localhost:8080/api/reservations/${listingID}`).then((res) => {
      for (let i = 0; i < res.data.length; i++) {
      
      this.reservations = res.data[i]
      this.checkInDate = res.data[i].checkInDate
      this.checkOutDate = res.data[i].checkOutDate
      this.startYear = new Date(this.checkInDate).getFullYear()
      this.startDay = new Date(this.checkInDate).getDate()
      this.startMonth = new Date(this.checkInDate).getMonth()
      this.endYear = new Date(this.checkOutDate).getFullYear()
      this.endDay = new Date(this.checkOutDate).getDate()
      this.endMonth = new Date(this.checkOutDate).getMonth()
      }
    });

  },
  data() {
    return {
      range: {
        start: new Date(),
        end: new Date(),
      },
      showDates: true,
      reservations: [],
      startDay: 0,
      startMonth: 0,
      startYear: 0,
      endDay: 0,
      endMonth: 0,
      endYear: 0,
      checkInDate: new Date(),
      checkOutDate: new Date()
    };
  },
  methods: {
    updateDate(date) {
      return moment(date).format("MM-DD-YYYY");
    },
    numOfDays() {
      let difference =
        new Date(this.range.end).getTime() -
        new Date(this.range.start).getTime();
      let days = Math.ceil(difference / (1000 * 3600 * 24));
      console.log(this.range.end)
      console.log(this.reservations)
      return days;
    },

    sendDate() {
      this.$emit("datePick", this.range);
      this.$emit("diffDays", this.numOfDays());
    },
  },
};
</script>
<style scoped>
.dateBox {
  margin: auto;
}
</style>
