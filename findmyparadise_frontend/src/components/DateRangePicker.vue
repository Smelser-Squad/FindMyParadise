<template>
  <div>
    <DatePicker
      is-expanded
      class="datePicker"
      v-model="range"
      is-range
      v-on:change="ChangeDate()"
      :min-date="new Date()"
      :rows="1"
      :columns="2"
      
      
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
