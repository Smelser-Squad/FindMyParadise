<template>
  <div class="dateBox">
    <DatePicker
      is-expanded
      class="datePicker"
      v-model="range"
      is-range
      :min-date="new Date()"
      :column="2"
      :row="1"
      color="pink"
      :disabled-dates='
      {
        start: new Date(2021, 3, 12),
        end: new Date(2021, 3, 18)
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


let listingID = 1;

export default {
  components: {
    DatePicker,
  },
  mounted() {
    axios.get(`http://localhost:8080/api/reservations/${listingID}`).then((res) => {
      this.reservationID = res.data.reservationID
      this.adults = res.data.adults
      this.checkInDate = res.data.checkInDate
      this.checkOutDate = res.data.checkOutDate
      this.children = res.data.children
      this.infants = res.data.infants
      this.price = res.data.price

    });

  },
  data() {
    return {
      range: {
        start: new Date(),
        end: new Date(),
      },
      showDates: false
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
