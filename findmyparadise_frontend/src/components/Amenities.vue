<template>
  <div id="Amenities">
    <h3>Amenities</h3>
    <ul class="initDisplay">
      <li v-for="amenity in amenities.slice(0, 10)" :key="amenity">
        <svg xmlns="http://www.w3.org/2000/svg">
          <path v-bind:d="setDPath(amenity.amenityName)"></path>
        </svg>
        {{ amenity.amenityName }}
      </li>
    </ul>

    <button class="showBtn" @click="() => TogglePopup('buttonTrigger')">
      Show all {{ amenities.length }} amenities
    </button>

    <Modal
      v-if="popupTriggers.buttonTrigger"
      :TogglePopup="() => TogglePopup('buttonTrigger')"
    >
      <h3>Amenities</h3>
      <br />
      <div v-if="bathBool">
        <h5 class="toggleHeader" id="bathroomHeader">Bathroom</h5>
        <br />
        <ul class="modalList">
          <li v-for="amenity in bathArr" :key="amenity">
            {{ amenity.amenityName }}
            <hr />
          </li>
        </ul>
      </div>

      <div v-if="bedBool">
        <h5 class="toggleHeader" id="bedroomHeader">Bedroom and laundry</h5>
        <br />
        <ul class="modalList">
          <li v-for="amenity in bedArr" :key="amenity">
            {{ amenity.amenityName }}
            <hr />
          </li>
        </ul>
      </div>

      <div v-if="entBool">
        <h5 class="toggleHeader" id="entertainmentHeader">Entertainment</h5>
        <br />
        <ul class="modalList">
          <li v-for="amenity in entArr" :key="amenity">
            {{ amenity.amenityName }}
            <hr />
          </li>
        </ul>
      </div>

      <div v-if="heatBool">
        <h5 class="toggleHeader" id="heatingHeader">Heating and cooling</h5>
        <br />
        <ul class="modalList">
          <li v-for="amenity in heatArr" :key="amenity">
            {{ amenity.amenityName }}
            <hr />
          </li>
        </ul>
      </div>

      <div v-if="homeBool">
        <h5 class="toggleHeader" id="homeHeader">Home safety</h5>
        <br />
        <ul class="modalList">
          <li v-for="amenity in homeArr" :key="amenity">
            {{ amenity.amenityName }}
            <hr />
          </li>
        </ul>
      </div>

      <div v-if="intBool">
        <h5 class="toggleHeader" id="internetHeader">Internet and office</h5>
        <br />
        <ul class="modalList">
          <li v-for="amenity in intArr" :key="amenity">
            {{ amenity.amenityName }}
            <hr />
          </li>
        </ul>
      </div>

      <div v-if="kitBool">
        <h5 class="toggleHeader" id="kitchenHeader">Kitchen and dining</h5>
        <br />
        <ul class="modalList">
          <li v-for="amenity in kitArr" :key="amenity">
            {{ amenity.amenityName }}
            <hr />
          </li>
        </ul>
      </div>
    </Modal>
  </div>
</template>

<script>
import { ref } from "vue";
import axios from "axios";
import Modal from "./Modal";

let listingID = 1;

export default {
  components: { Modal },
  name: "Amenities",
  setup() {
    const popupTriggers = ref({
      buttonTrigger: false,
    });
    
    const TogglePopup = (trigger) => {
      popupTriggers.value[trigger] = !popupTriggers.value[trigger];
    }

    return {
      Modal,
      popupTriggers,
      TogglePopup,
    };
  },
  data() {
    return {
      amenities: [],
      amenityName: "",
      dPath: "",

      bathArr: [],
      bedArr: [],
      entArr: [],
      heatArr: [],
      homeArr: [],
      intArr: [],
      kitArr: [],

      bathBool: false,
      bedBool: false,
      entBool: false,
      heatBool: false,
      homeBool: false,
      intBool: false,
      kitBool: false,
    };
  },
  mounted() {
    axios

      .get(`http://localhost:8080/api/listing/${listingID}`)
      .then((res) => {
        this.amenities = res.data.amenities;
        this.arrSetup();
        this.bathBool = this.setupDisplay(this.bathArr);
        this.bedBool = this.setupDisplay(this.bedArr);
        this.entBool = this.setupDisplay(this.entArr);
        this.heatBool = this.setupDisplay(this.heatArr);
        this.homeBool = this.setupDisplay(this.homeArr);
        this.intBool = this.setupDisplay(this.intArr);
        this.kitBool = this.setupDisplay(this.kitArr);
      })
      .catch((err) => Promise.reject(err));
  },
  methods: {
    setDPath(name) {
      switch (name) {
        case "Ethernet connection":
        case "Wifi": {
          this.dPath =
            "M16 20a4 4 0 1 1 0 8 4 4 0 0 1 0-8zm0 2a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm0-7a9 9 0 0 1 8.043 4.958L22.53 21.47a7.003 7.003 0 0 0-13.058 0l-1.514-1.514A9 9 0 0 1 16 15zm0-5c4.89 0 9.193 2.506 11.697 6.304l-1.45 1.45A11.993 11.993 0 0 0 16 12c-4.339 0-8.14 2.302-10.247 5.752l-1.45-1.449A13.987 13.987 0 0 1 16 10zm0-5c6.267 0 11.826 3.034 15.286 7.714l-1.432 1.432C26.773 9.821 21.716 7 16 7 10.285 7 5.228 9.82 2.146 14.145L.714 12.714C4.174 8.034 9.733 5 16 5z";
          break;
        }
        case "TV":
          this.dPath =
            "M9 29v-2h2v-2H6a5 5 0 0 1-4.995-4.783L1 20V8a5 5 0 0 1 4.783-4.995L6 3h20a5 5 0 0 1 4.995 4.783L31 8v12a5 5 0 0 1-4.783 4.995L26 25h-5v2h2v2zm10-4h-6v2h6zm7-20H6a3 3 0 0 0-2.995 2.824L3 8v12a3 3 0 0 0 2.824 2.995L6 23h20a3 3 0 0 0 2.995-2.824L29 20V8a3 3 0 0 0-2.824-2.995z";
          break;
        case "Carbon Monoxide Alarm":
          this.dPath =
            "M25 2a5 5 0 0 1 4.995 4.783L30 7v18a5 5 0 0 1-4.783 4.995L25 30H7a5 5 0 0 1-4.995-4.783L2 25V7a5 5 0 0 1 4.783-4.995L7 2zm0 2H7a3 3 0 0 0-2.995 2.824L4 7v18a3 3 0 0 0 2.824 2.995L7 28h18a3 3 0 0 0 2.995-2.824L28 25V7a3 3 0 0 0-2.824-2.995zM11.1 17a5.006 5.006 0 0 0 3.9 3.9v2.03A7.005 7.005 0 0 1 9.071 17zm9.8 0l2.029.001a7.005 7.005 0 0 1-5.928 5.928v-2.03A5.006 5.006 0 0 0 20.9 17zM16 13a3 3 0 1 1 0 6 3 3 0 0 1 0-6zm0 2a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm1.001-5.929A7.005 7.005 0 0 1 22.929 15H20.9A5.006 5.006 0 0 0 17 11.1zm-2.001 0v2.03A5.006 5.006 0 0 0 11.1 15H9.07A7.005 7.005 0 0 1 15 9.07zM23 8a1 1 0 1 1 0 2 1 1 0 0 1 0-2z";
          break;
        case "First aid kit":
          this.dPath =
            "M26 3a5 5 0 0 1 4.995 4.783L31 8v16a5 5 0 0 1-4.783 4.995L26 29H6a5 5 0 0 1-4.995-4.783L1 24V8a5 5 0 0 1 4.783-4.995L6 3zm0 2H6a3 3 0 0 0-2.995 2.824L3 8v16a3 3 0 0 0 2.824 2.995L6 27h20a3 3 0 0 0 2.995-2.824L29 24V8a3 3 0 0 0-2.824-2.995zm-7 4v4h4v6h-4v4h-6v-4.001L9 19v-6l4-.001V9zm-2.001 2h-2L15 14.999h-4.001V17L15 16.998 14.999 21h2L17 17h3.999v-2H17z";
          break;
        case "Hangers":
          this.dPath =
            "M16 2a5 5 0 0 1 1.661 9.717 1.002 1.002 0 0 0-.653.816l-.008.126v.813l13.23 9.052a3 3 0 0 1 1.299 2.279l.006.197a3 3 0 0 1-3 3H3.465a3 3 0 0 1-1.694-5.476L15 13.472v-.813c0-1.211.724-2.285 1.816-2.757l.176-.07a3 3 0 1 0-3.987-3.008L13 7h-2a5 5 0 0 1 5-5zm0 13.211L2.9 24.175A1 1 0 0 0 3.465 26h25.07a1 1 0 0 0 .565-1.825z";
          break;
        case "Heating":
          this.dPath =
            "M16 0a5 5 0 0 1 4.995 4.783L21 5l.001 12.756.26.217a7.984 7.984 0 0 1 2.717 5.43l.017.304L24 24a8 8 0 1 1-13.251-6.036l.25-.209L11 5A5 5 0 0 1 15.563.019l.22-.014zm0 2a3 3 0 0 0-2.995 2.824L13 5v13.777l-.428.298a6 6 0 1 0 7.062.15l-.205-.15-.428-.298L19 11h-4V9h4V7h-4V5h4a3 3 0 0 0-3-3zm1 11v7.126A4.002 4.002 0 0 1 16 28a4 4 0 0 1-1-7.874V13zm-1 9a2 2 0 1 0 0 4 2 2 0 0 0 0-4z";
          break;
        case "Smoke Alarm":
          this.dPath =
            "M16 1c8.284 0 15 6.716 15 15 0 8.284-6.716 15-15 15-8.284 0-15-6.716-15-15C1 7.716 7.716 1 16 1zm0 2C8.82 3 3 8.82 3 16s5.82 13 13 13 13-5.82 13-13S23.18 3 16 3zm-4.9 14a5.006 5.006 0 0 0 3.9 3.9v2.03A7.005 7.005 0 0 1 9.071 17zm9.8 0l2.029.001a7.005 7.005 0 0 1-5.928 5.928v-2.03A5.006 5.006 0 0 0 20.9 17zM16 13a3 3 0 1 1 0 6 3 3 0 0 1 0-6zm0 2a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm1.001-5.929A7.005 7.005 0 0 1 22.929 15H20.9A5.006 5.006 0 0 0 17 11.1zm-2.001 0v2.03A5.006 5.006 0 0 0 11.1 15H9.07A7.005 7.005 0 0 1 15 9.07zM23 8a1 1 0 1 1 0 2 1 1 0 0 1 0-2z";
          break;
        case "Air conditioning":
          this.dPath =
            "M17 1v4.03l4.026-2.324 1 1.732L17 7.339v6.928l6-3.464V5h2v4.648l3.49-2.014 1 1.732L26 11.381l4.026 2.325-1 1.732L24 12.535l-6 3.464 6 3.465 5.026-2.902 1 1.732L26 20.618l3.49 2.016-1 1.732L25 22.351V27h-2v-5.804l-6-3.465v6.929l5.026 2.902-1 1.732L17 26.97V31h-2v-4.031l-4.026 2.325-1-1.732L15 24.66v-6.929l-6 3.464V27H7v-4.65l-3.49 2.016-1-1.732 3.489-2.016-4.025-2.324 1-1.732 5.025 2.901 6-3.464-6-3.464-5.025 2.903-1-1.732L6 11.38 2.51 9.366l1-1.732L7 9.648V5h2v5.803l6 3.464V7.339L9.974 4.438l1-1.732L15 5.03V1z";
          break;
        case "Cable TV":
          this.dPath =
            "M24 1a5 5 0 0 1 4.995 4.783L29 6v20a5 5 0 0 1-4.783 4.995L24 31h-5v-2h5a3 3 0 0 0 2.995-2.824L27 26V6a3 3 0 0 0-2.824-2.995L24 3H8a3 3 0 0 0-2.995 2.824L5 6v20a3 3 0 0 0 2.824 2.995L8 29h7v-8h-2a2 2 0 0 1-1.995-1.85L11 19v-6a2 2 0 0 1 1.85-1.995L13 11h6a2 2 0 0 1 1.995 1.85L21 13v6a2 2 0 0 1-1.85 1.995L19 21h-2v8a2 2 0 0 1-1.85 1.995L15 31H8a5 5 0 0 1-4.995-4.783L3 26V6a5 5 0 0 1 4.783-4.995L8 1zm-5 12h-6v6h2v-4h2v4h2z";
          break;
        case "Fire extinguisher":
          this.dPath =
            "M7 28H5V15c0-4.997 3.356-9.304 8.061-10.603A3 3 0 0 1 17.69 2.52l2.66-2.28 1.302 1.52L19.036 4H23v2h-4.17A3.008 3.008 0 0 1 17 7.83l.001.242a7.007 7.007 0 0 1 5.982 6.446l.013.24L23 15v15a2 2 0 0 1-1.85 1.995L21 32H11a2 2 0 0 1-1.995-1.85L9 30v-6H7zm9-18c-2.617 0-4.775 2.014-4.983 4.573l-.013.22L11 15v15h10V15.018l-.003-.206A5 5 0 0 0 16 10zm-2.654-3.6a9.002 9.002 0 0 0-6.342 8.327L7 15v7h2v-7.018l.005-.244A7.001 7.001 0 0 1 15 8.071v-.242a3.01 3.01 0 0 1-1.654-1.43zM16 4a1 1 0 1 0 0 2 1 1 0 0 0 0-2z";
          break;
        case "Hot Water":
        case "Shampoo": {
          this.dPath =
            "M11 1v7l1.898 20.819.007.174c-.025 1.069-.804 1.907-1.818 1.999a2 2 0 0 1-.181.008h-7.81l-.174-.008C1.86 30.87 1.096 30.018 1.096 29l.002-.09 1.907-21L3.001 1zm6 0l.15.005a2 2 0 0 1 1.844 1.838L19 3v7.123l-2 8V31h-2V18.123l.007-.163.02-.162.033-.16L16.719 11H13V1zm11 0a2 2 0 0 1 1.995 1.85L30 3v26a2 2 0 0 1-1.85 1.995L28 31h-7v-2h7v-2h-7v-2h7v-2h-7v-2h7v-2h-7v-2h7v-2h-7v-2h7v-2h-7V9h7V7h-7V5h7V3h-7V1zM9.088 9h-4.18L3.096 29l.058.002L10.906 29l-.004-.058zM17 3h-2v6h2zM9.002 3H5L5 7h4.004z";
          break;
        }
        case "Hair Dryer":
          this.dPath =
            "M14 27l-.005.2a4 4 0 0 1-3.789 3.795L10 31H4v-2h6l.15-.005a2 2 0 0 0 1.844-1.838L12 27zM10 1c.536 0 1.067.047 1.58.138l.38.077 17.448 3.64a2 2 0 0 1 1.585 1.792l.007.166v6.374a2 2 0 0 1-1.431 1.917l-.16.04-13.554 2.826 1.767 6.506a2 2 0 0 1-1.753 2.516l-.177.008H11.76a2 2 0 0 1-1.879-1.315l-.048-.15-1.88-6.769A9 9 0 0 1 10 1zm5.692 24l-1.799-6.621-1.806.378a8.998 8.998 0 0 1-1.663.233l-.331.008L11.76 25zM10 3a7 7 0 1 0 1.32 13.875l.331-.07L29 13.187V6.813L11.538 3.169A7.027 7.027 0 0 0 10 3zm0 2a5 5 0 1 1 0 10 5 5 0 0 1 0-10zm0 2a3 3 0 1 0 0 6 3 3 0 0 0 0-6z";
          break;
        case "Stove":
        case "Oven":
        case "Microwave": {
          this.dPath =
            "M26 1a5 5 0 0 1 5 5c0 6.389-1.592 13.187-4 14.693V31h-2V20.694c-2.364-1.478-3.942-8.062-3.998-14.349L21 6l.005-.217A5 5 0 0 1 26 1zm-9 0v18.118c2.317.557 4 3.01 4 5.882 0 3.27-2.183 6-5 6s-5-2.73-5-6c0-2.872 1.683-5.326 4-5.882V1zM2 1h1c4.47 0 6.934 6.365 6.999 18.505L10 21H3.999L4 31H2zm14 20c-1.602 0-3 1.748-3 4s1.398 4 3 4 3-1.748 3-4-1.398-4-3-4zM4 3.239V19h3.995l-.017-.964-.027-.949C7.673 9.157 6.235 4.623 4.224 3.364l-.12-.07zm19.005 2.585L23 6l.002.31c.045 4.321 1.031 9.133 1.999 11.39V3.17a3.002 3.002 0 0 0-1.996 2.654zm3.996-2.653v14.526C27.99 15.387 29 10.4 29 6a3.001 3.001 0 0 0-2-2.829z";
          break;
        }
        default:
          this.dPath = "";
          break;
      }
      return this.dPath;
    },

    processData(catName) {
      let arr = new Array();

      for (let i = 0; i < this.amenities.length; i++) {
        if (this.amenities[i].amenityCategory === catName) {
          arr.push(this.amenities[i]);
        }
      }

      return arr;
    },

    arrSetup() {
      this.bathArr = this.processData("Bathroom");
      this.bedArr = this.processData("Bedroom and laundry");
      this.entArr = this.processData("Entertainment");
      this.heatArr = this.processData("Heating and cooling");
      this.homeArr = this.processData("Home and safety");
      this.intArr = this.processData("Internet and office");
      this.kitArr = this.processData("Kitchen and dining");
    },

    setupDisplay(arr) {
      if (arr.length === 0) {
        return false;
      } else {
        return true;
      }
    },
  },
};
</script>

<style scoped>
ul {
  list-style-type: none;
}

.initDisplay {
  columns: 2;
}

.showBtn {
  border-radius: 12px;
  background-color: white;
  padding: 10px;
  border: 1px solid;
}

.showBtn:hover {
  text-decoration: underline;
  background-color: #f7f7f7;
}

svg {
  width: 35px;
  height: 35px;
}

ul {
  list-style-type: none;
}

.initDisplay {
  columns: 2;
}

.showBtn {
  border-radius: 12px;
  background-color: white;
  padding: 10px;
  border: 1px solid;
}

.showBtn:hover {
  text-decoration: underline;
  background-color: #f7f7f7;
}

svg {
  width: 35px;
  height: 35px;
}

.toggleHeader {
  float: left;
}

.modalList {
  margin-top: 20px;
  margin-bottom: 20px;
  padding-bottom: 20px;
  padding-top: 20px;
}
</style>
