<template>
  <div class="dateBox">
    <DatePicker
      is-expanded
      class="datePicker"
      v-model="range"
      is-range
      v-on:change="ChangeDate()"
      :min-date="new Date()"
    />

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

    OnClick() {
      this.$emit("DatePick", this.range);
    },

    sendDate() {
      this.$emit("datePick", this.range);
    },
  },
};
</script>
<style scoped>
.vc-weeks {
  height: 350px !important;
  width: 100% !important;
}
</style>
