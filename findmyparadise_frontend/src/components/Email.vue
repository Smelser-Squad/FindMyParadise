<template>
  <div class="email">
    <div class="email-inner">
      <h2>Contact {{ host.hostName }}</h2>
      <br />
      <div class="input-row">
        <label class="input-label" for="guestName"> Name </label>
        <input v-model="guestName" v-on:input="validateName" id="guestName" />
      </div>
      <div class="input-row">
        <label class="input-label" for="guestEmail"> Email </label>
        <input
          v-model="guestEmail"
          v-on:input="validateEmail"
          id="guestEmail"
        />
      </div>
      <div class="input-row">
        <label class="input-label" for="guestMessage"> Message </label>
        <textarea
          v-model="guestMessage"
          v-on:input="validateMessage"
          id="guestMessage"
        >
        </textarea>
      </div>
      <br />
      <button
        :disabled="!(validName && validEmail && validMessage)"
        @click="sendEmail()"
        style = "width: 100px;"
      >
        Send Email
      </button>
      <br />
      <button style="width: 100px;" @click="toggleEmail()">Close email</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Email",
  props: ["toggleEmail", "host"],
  data: () => {
    return {
      guestName: "",
      guestEmail: "",
      guestMessage: "",
      validName: false,
      validEmail: false,
      validMessage: false,
      //eslint-disable-next-line
      reg: /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,24}))$/
    };
  },
  methods: {
    validateName() {
      this.validName = this.guestName != "";
    },
    validateEmail() {
      this.validEmail = this.reg.test(this.guestEmail);
    },
    validateMessage() {
      this.validMessage = this.guestMessage != "";
    },
    sendEmail() {
      // console.log("SENT");
    },
  },
};
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
  padding: 10px;
  background: #fff;
  text-align: center;
  width: 50%;
  border: 5px solid rgb(209, 60, 110);
}
.input-label {
  padding-right: 10px;
}
.input-row {
  text-align: center;
}
</style>
