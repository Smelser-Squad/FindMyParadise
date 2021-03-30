<template>
    <div>
    <DatePicker 
    class="datePicker"
    v-model="range" 
    is-range 
    v-on:change="ChangeDate()"
    @click="OnClick()"
    :min-date='new Date()' 
    />
    <br/>
    <span>Start Date: {{updateDate(range.start)}}</span>
    <br/>
    <span>End Date: {{updateDate(range.end)}}</span>
    <br/>
    </div>
</template>

<script>
import { DatePicker } from 'v-calendar';
// import Calendar from './Calendar.vue';

export default {
    components: {
        DatePicker
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
      let dateSub = date.toString().substring(0,15)
      return dateSub
    },
    
     OnClick(){
      this.$emit('DatePick',this.range);
     }
    }
}
</script>
