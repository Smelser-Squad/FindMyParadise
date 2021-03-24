<template>  
    <div id="Calendar">
        <h1>Calendar here</h1>
        <date-picker v-model="date" lang="en" type="date" format="YYYY-MM-dd"></date-picker>
    </div>
</template>

<script>
import DatePicker from "vue2-datepicker";
export default {
  name: "Calendar",
  props: {
    
  },
  components: {
      DatePicker,
  },
  data() {
      return {
          date: ""
      }
  }

  
  
};
</script>