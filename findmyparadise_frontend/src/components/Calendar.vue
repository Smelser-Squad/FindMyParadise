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
    <button>Submit</button>
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
      date1: "",
      date2: "",
    };
  },
  methods: {
    updateDate(date) {
      let date1sub = date.toString().substring(4,15)
      return date1sub
    },
  }
};
</script>
