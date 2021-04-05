import { createRouter, createWebHashHistory } from "vue-router";
import Listing from "../views/Listing.vue";

const routes = [
  {
    path: "/listing/:listingId",
    name: "Listing",
    component: Listing,
    props: true,
  },
  // {
  //   path: "/",
  //   name: "Home",
  //   component: Listing
  // },
  // {
  //   path: "/:pathMatch(.*)*",
  //   name: "wildcard",
  //   redirect: "/",
  // },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
