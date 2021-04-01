import { shallowMount } from "@vue/test-utils";
import Email from "@/components/Email.vue";
import { iterator } from "core-js/fn/symbol";

describe("Email.vue", () => {
  const wrapper = shallowMount(Email, {
    data() {
      return {
        guestName: "",
        guestEmail: "",
        guestMessage: "",
        validName: false,
        validEmail: false,
        validMessage: false,
        //eslint-disable-next-line
        reg: /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,24}))$/
      }
    }
  });

  it()
})