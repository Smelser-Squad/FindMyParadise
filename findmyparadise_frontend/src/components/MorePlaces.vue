<template>
  <div>
    <h2>More places to stay</h2>

    <horizontal-list :items="items" :options="options">
      <template v-slot:default="{ item }">
        <div>
          <a @click="listingClicked(item.listingId)">
            <div class="image-container">
              <img :src="item.photos[0].imageSrc" />
              <div class="image-overlay">
                <div>
                  <div class="superhost-container" v-if="item.host.superhost">
                    <div class="superhost">SUPERHOST</div>
                  </div>
                </div>
                <div
                  class="button-container"
                  v-on:click.stop="liked(item.listingId)"
                >
                  <button>
                    <svg
                      viewBox="0 0 32 32"
                      xmlns="http://www.w3.org/2000/svg"
                      aria-hidden="true"
                      role="presentation"
                      focusable="false"
                      style="
                        display: block;
                        fill: rgba(0, 0, 0, 0.5);
                        height: 24px;
                        width: 24px;
                        stroke: rgb(255, 255, 255);
                        stroke-width: 2;
                        overflow: visible;
                      "
                    >
                      <path
                        d="m16 28c7-4.733 14-10 14-17 0-1.792-.683-3.583-2.05-4.95-1.367-1.366-3.158-2.05-4.95-2.05-1.791 0-3.583.684-4.949 2.05l-2.051 2.051-2.05-2.051c-1.367-1.366-3.158-2.05-4.95-2.05-1.791 0-3.583.684-4.949 2.05-1.367 1.367-2.051 3.158-2.051 4.95 0 7 7 12.267 14 17z"
                      ></path>
                    </svg>
                  </button>
                </div>
              </div>
            </div>

            <div class="subtitle">
              <div v-if="item.reviews && item.reviews.length > 0">
                <svg
                  viewBox="0 0 1000 1000"
                  role="presentation"
                  aria-hidden="true"
                  focusable="false"
                  style="height: 14px; width: 14px; fill: red"
                >
                  <path
                    d="M972 380c9 28 2 50-20 67L725 619l87 280c11 39-18 75-54 75-12 0-23-4-33-12L499 790 273 962a58 58 0 0 1-78-12 50 50 0 0 1-8-51l86-278L46 447c-21-17-28-39-19-67 8-24 29-40 52-40h280l87-279c7-23 28-39 52-39 25 0 47 17 54 41l87 277h280c24 0 45 16 53 40z"
                  ></path>
                </svg>
                {{ calculateAverageRating(item.reviews) }} ({{
                  item.reviews.length
                }})
              </div>
              <div v-else>No reviews yet</div>
            </div>
            <p>
              Entire {{ item.type }} · {{ item.beds }}
              {{ item.beds === 1 ? "bed" : "beds" }}
            </p>
            <p>{{ item.name }}</p>
          </a>
          <p>
            <b>${{ item.price }}</b> / night
          </p>
        </div>
      </template>
    </horizontal-list>
  </div>
</template>

<script>
import HorizontalList from "./HorizontalList.vue";
import axios from "axios";
export default {
  name: "more-places",
  components: {
    HorizontalList
  },
  props: ["listing"],
  data() {
    return {
      items: [],
      options: {
        responsive: [
          { end: 576, size: 1 },
          { start: 576, end: 768, size: 2 },
          { start: 768, end: 992, size: 3 },
          { size: 4 },
        ],
      },
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/api/listings")
      .then((res) => {
        this.items = res.data;
      })
      .catch((err) => Promise.reject(err));
  },
  methods: {
    liked(listingId) {
      alert(`You liked listing with id: ${listingId}!`);
    },
    listingClicked(listingId) {
      alert(listingId);
    },
    calculateAverageRating(reviews) {
      return (
        reviews.reduce((curr, next) => {
          return (curr += next.rating);
        }, 0) / reviews.length
      ).toFixed(2);
    },
  },
};
</script>

<style scoped>
a,
a:hover,
a:focus,
a:active {
  text-decoration: none;
  color: inherit;
}
a:hover {
  cursor: pointer;
}
p {
  margin-top: 6px;
  margin: 0;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
.subtitle {
  margin-top: 8px;
  margin-bottom: 6px;
  display: flex;
  justify-content: space-between;
  font-size: 14px;
  font-weight: 500;
}
.image-container {
  border-radius: 3px;
  overflow: hidden;
  position: relative;
  width: 100%;
  padding-top: 60%;
}
img {
  object-fit: cover;
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  border-radius: 8px;
}
.image-overlay {
  display: flex;
  position: absolute;
  top: 0;
  z-index: 1;
  padding: 8px;
  width: 100%;
  justify-content: space-between !important;
  -webkit-box-pack: justify !important;
}
.superhost-container {
  display: inline-flex !important;
  vertical-align: top !important;
  background-clip: padding-box !important;
  max-width: 100% !important;
  box-shadow: rgb(0 0 0 / 18%) 0px 2px 4px !important;
  border-radius: 4px !important;
  contain: content !important;
  background-color: rgba(255, 255, 255, 0.95);
  border: 0.5px solid rgba(0, 0, 0, 0.2);
  color: rgb(34, 34, 34);
  font-family: Circular, -apple-system, BlinkMacSystemFont, Roboto,
    Helvetica Neue, sans-serif !important;
  font-weight: 400 !important;
  font-size: 16px !important;
  line-height: 20px !important;
  --gp-section-compact-padding: 32px !important;
  --gp-section-compact-padding-condensed: 16px !important;
  --gp-section-standard-padding: 48px !important;
  --gp-section-standard-padding-condensed: 24px !important;
  -webkit-font-smoothing: antialiased;
}
.superhost {
  font-size: 12px !important;
  line-height: 16px !important;
  font-weight: 800 !important;
  letter-spacing: 0.04em !important;
  padding: 4px 8px !important;
  height: 100%;
  overflow: hidden !important;
  text-overflow: ellipsis !important;
  display: -webkit-box !important;
  -webkit-line-clamp: 1 !important;
  -webkit-box-orient: vertical !important;
}
button {
  -webkit-box-pack: center !important;
  -webkit-box-align: center !important;
  cursor: pointer !important;
  position: relative !important;
  text-align: center !important;
  text-decoration: none !important;
  background: transparent !important;
  touch-action: manipulation !important;
  font-family: Circular, -apple-system, BlinkMacSystemFont, Roboto,
    "Helvetica Neue", sans-serif !important;
  font-size: 16px !important;
  line-height: 20px !important;
  font-weight: 600 !important;
  border-radius: 50% !important;
  outline: none !important;
  padding: 2px 0px 0px !important;
  transition: -ms-transform 0.25s ease 0s, -webkit-transform 0.25s ease 0s,
    transform 0.25s ease 0s !important;
  display: inline-flex !important;
  align-items: center !important;
  justify-content: center !important;
  border: none !important;
  color: rgb(34, 34, 34) !important;
  margin: 0px !important;
  width: 32px !important;
  height: 32px !important;
}
</style>
