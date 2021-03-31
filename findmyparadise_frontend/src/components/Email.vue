<template>
  <div class="email">
    <div class="email-inner">
      <h2>
        {{host.hostName}}
      </h2>
      <button @click="toggleEmail()">Close email</button>
    </div>
  </div>
</template>

<script>
export default {
  props: ['toggleEmail', 'host']
}
</script>

<style scoped>
  .email {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: 99;
    background-color: rgba(0, 0, 0, 0.2);
    
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .email-inner {
    background: #FFF;
  }
</style>