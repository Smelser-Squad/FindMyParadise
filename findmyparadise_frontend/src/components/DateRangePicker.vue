<template>
  <div>
    <DatePicker
      class="datePicker"
      v-model="range"
      is-range
      :min-date="new Date()"
      :columns = "2"
      :rows = "1"
    />
    <br />
    <span>Start Date: {{ updateDate(range.start) }}</span>

    <br />
    <span>End Date: {{ updateDate(range.end) }}</span>
    <br />
  <span>Number of days: </span>
    <span>{{numOfDays()}}</span>
    <button class="btn" @click="sendDate">Submit</button>
  </div>
</template>

<script>
import { DatePicker } from "v-calendar";
// import Calendar from './Calendar.vue';

export default {
  components: {
    DatePicker,
  },
  data() {
    return {
      range: {
        start: new Date(),
        end: new Date(),
      },
    };
  },
  methods: {
    updateDate(date) {
      let dateSub = date.toString().substring(0, 15);
      return dateSub;
    },
     numOfDays() {
      let difference = new Date(this.range.end).getTime() - new Date(this.range.start).getTime()
      let days = Math.ceil(difference/ (1000 * 3600 * 24))
      console.log(days)
      return days
    },
    
 
       sendDate() {
      this.$emit("datePick", this.range);
      this.$emit("diffDays",this.numOfDays())
    },
      
     
    }
}
</script>
