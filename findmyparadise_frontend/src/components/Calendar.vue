
<template>
  <div id="Calendar">
    <h1>Pick a Date Range</h1>
    <date-picker
      class="datePicker"
      v-model="date1"
      lang="en"
      type="date"
      format="MM-dd-YYYY"
    ></date-picker>
    <date-picker
      class="datePicker"
      v-model="date2"
      lang="en"
      type="date"
      format="MM-dd-YYYY"
    ></date-picker>
    <span>Start Date: {{updateDate(date1)}}</span>
    <br/>
    <span>End Date: {{updateDate(date2)}}</span>
    <br/>
    <button class="btn" @click="numOfDays">Submit</button>
    <br/>
    <span>Number of days: </span>
    <span>{{numOfDays()}}</span>
  </div>
</template>

<script>
import DatePicker from "vue3-datepicker";
export default {
  name: "Calendar",
  props: {},
  components: {
    DatePicker,
  },
  data() {
    return {
      date1: '',
      date2: '',
    };
  },
  methods: {
    updateDate(date) {
      let dateSub = date.toString().substring(4,15)
      return dateSub
    },
    numOfDays() {
      let difference = new Date(this.date2).getTime() - new Date(this.date1).getTime()
      let days = Math.ceil(difference/ (1000 * 3600 * 24))
      console.log(days)
      return days
    }
  }
};
</script>

