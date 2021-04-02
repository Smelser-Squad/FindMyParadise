<template>
  <div class="dateBox">
    <DatePicker
      is-expanded
      class="datePicker"
      v-model="range"
      is-range
      :min-date="new Date()"
<<<<<<< HEAD
      :column="2"
      :row="1"
      

=======
      :columns="2"
      :rows="1"
>>>>>>> 5eb80882062d9c567e999cad26144562f1f364a2
    />
    <br />

    <span>Start Date: {{ updateDate(range.start) }}</span>

    <br />
    <span>End Date: {{ updateDate(range.end) }}</span>
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
      return moment(date).format("MM-DD-YYYY");
    },
    numOfDays() {
      let difference =
        new Date(this.range.end).getTime() -
        new Date(this.range.start).getTime();
      let days = Math.ceil(difference / (1000 * 3600 * 24));
      console.log(days);
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
