import { shallowMount } from "@vue/test-utils";
import MorePlaces from "@/components/MorePlaces.vue";
import mockData from "@/assets/MorePlaces.json";

describe("MorePlaces.vue", () => {
  const wrapper = shallowMount(MorePlaces, {
    data() {
      return {
        items: mockData,
      };
    },
  });

  it("has the correct title", () => {
    expect(wrapper.find("h2").text()).toMatch("More places to stay");
  });

  it("has a superhost section", () => {
    expect(wrapper.find(".superhost").exists());
  });

  it("has the correct data", () => {
    expect(wrapper.vm.items).toBe(mockData);
  });
});
