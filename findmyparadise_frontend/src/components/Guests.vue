<template>
  <div>
    <h5>
      Adults:
      <button
        type="button"
        id="DecresaeAdults"
        class="btn"
        @click="DecreaseAdults()"
      >
        -
      </button>
      {{ AdultsNum }}
      <button type="button" class="btn" @click="IncreaseAdults()">+</button>
    </h5>
    <h5>
      Children:<button type="button" class="btn">-</button>{{ ChildNum
      }}<button type="button" class="btn">+</button>
    </h5>
    <h5>
      Infants: <button type="button" class="btn">-</button> {{ InfantNum }}
      <button type="button" class="btn">+</button>
    </h5>
  </div>
</template>

<script>
export default {
  name: "Guests",
  props: {},
  methods: {
    IncreaseAdults() {
      this.AdultsNum += 1;
    },
    DecreaseAdults() {
      if (this.AdultsNum == 1) {
        console.log("Error");
      } else {
        this.AdultsNum -= 1;
      }
    },
  },
  DecreaseChild() {
    if (this.ChildNum < 0) {
      console.log("Error");
    } else {
      this.ChildNum -= 1;
    }
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
