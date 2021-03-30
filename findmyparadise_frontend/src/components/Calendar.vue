
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
    <button type="button" @click="numOfDays">Submit</button>
    <br/>
    <span>Number of days: </span>
    <span>{{numOfDays()}}</span>
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
      let dateSub = date.toString().substring(4,15)
      return dateSub
    },
    numOfDays() {
      let difference = new Date(this.date2).getTime() - new Date(this.date1).getTime()
      let days = Math.ceil(difference/ (1000 * 3600 * 24))
      console.log(days)
      
      return days
    },
   OnClick(){
      this.$emit('DatePick',this.range.start);
    

   }
   
    
  }
};
</script>

