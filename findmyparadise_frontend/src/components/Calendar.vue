<template>
  <div id="Calendar">
    <date-picker
      v-model="date"
      lang="en"
      type="date"
      format="YYYY-MM-dd"
    ></date-picker>
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
      date: "",
    };
  },
};
</script>
