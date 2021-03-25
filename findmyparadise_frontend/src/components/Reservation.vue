<template>
    <header>
        <h1> Reservation</h1>
    </header>
    <body> 
        <h3> Check-In</h3>
        <Calendar/>
         <h3> Check-Out</h3>
        <Calendar/>     
         <button> Reserve </button>
        
    </body>
</template>
<script>
  import Calender from './Calendar';

export default {
    name:'Reservation',

    components:{
          Calender,
    
    },
}
</script>
<style scoped>
header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;

    }
</style>