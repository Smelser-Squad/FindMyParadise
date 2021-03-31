<template>
  <div id="Calendar">

  
    <date-picker class="datePicker" :min-date="new Date()" v-on:change="ChangeDate()"
      v-model="range"
      @click="OnClick()" is-range
  
      
    ></date-picker>
    <span>CheckIn: {{updateDate(range.start)}}</span>
    <br/>
    <span>CheckOut {{updateDate(range.end)}}</span>
    <br/>
    
    <br/>
  </div>
</template>

<script>
import { DatePicker } from 'v-calendar';
export default {
  name: "Calendar",


  components: {
    DatePicker,
  },
  data() {
    return {
      date1: '',
      date2: '',
      range: {
      start: new Date(),
      end: new Date()
    }
    };
  },
  methods: {
    updateDate(date) {
      let dateSub = date.toString().substring(4, 15);
      return dateSub;
    },
    
   OnClick(){
      this.$emit('DatePick',this.range);
    

   }
   
    
  }
};
</script>
