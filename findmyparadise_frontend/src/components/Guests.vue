<template>
  <div>
    <h5>
      Adults:
      <button
        type="button"
        id="decresaeAdults"
        class="btn"
        @click="
          decreaseAdults();
          sendDecreaseAdultQty();
        "
      >
        -
      </button>
      {{ AdultsNum }}
      <button
        type="button"
        class="btn"
        @click="
          sendIncreaseAdultQty();
          increaseAdults();
        "
      >
        +
      </button>
    </h5>
    <h5>
      Children:<button
        type="button"
        class="btn"
        @click="
          sendDecreaseChildQty();
          decreaseChild();
        "
      >
        -</button
      >{{ ChildNum
      }}<button
        type="button"
        class="btn"
        @click="
          sendIncreaseAdultQty();
          increaseChild();
        "
      >
        +
      </button>
    </h5>
    <h5>
      Infants:
      <button
        type="button"
        class="btn"
        @click="
          sendDecreaseInfantQty();
          decreaseInfants();
        "
      >
        -
      </button>
      {{ InfantNum }}
      <button
        type="button"
        class="btn"
        @click="
          sendIncreaseInfantQty();
          increaseInfants();
        "
      >
        +
      </button>
    </h5>
  </div>
</template>

<script>
export default {
  name: "Guests",
  props: {},
  methods: {
    increaseAdults() {
      this.AdultsNum += 1;
    },
    decreaseAdults() {
      if (this.AdultsNum == 1) {
        // console.log("Error");
      } else {
        this.AdultsNum -= 1;
      }
    },
    decreaseChild() {
      if (this.ChildNum == 0) {
        // console.log("Error");
      } else {
        this.ChildNum -= 1;
      }
    },
    increaseChild() {
      this.ChildNum += 1;
    },
    decreaseInfants() {
      if (this.InfantNum == 0) {
        // console.log("Error");
      } else {
        this.InfantNum -= 1;
      }
    },
    increaseInfants() {
      this.InfantNum += 1;
    },
    sendIncreaseAdultQty() {
      this.$emit("iAQty", this.AdultsNum);
    },
    sendDecreaseAdultQty() {
      this.$emit("dAQty", this.AdultsNum);
    },
    sendIncreaseChildQty() {
      this.$emit("iCQty", this.AdultsNum);
    },
    sendDecreaseChildQty() {
      this.$emit("dCQty", this.AdultsNum);
    },
    sendIncreaseInfantQty() {
      this.$emit("iIQty", this.AdultsNum);
    },
    sendDecreaseInfantQty() {
      this.$emit("dIQty", this.AdultsNum);
    },
  },
  data() {
    return {
      AdultsNum: 1,
      ChildNum: 0,
      InfantNum: 0,
    };
  },
};
</script>
