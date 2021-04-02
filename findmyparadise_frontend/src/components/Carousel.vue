<template>
  <template>
    <div
      id="carouselExampleControls"
      class="carousel slide"
      data-bs-ride="carousel"
    >
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img
            src="https://a0.muscache.com/im/pictures/b79fb3f2-70a2-4fcd-a207-db3124d01e8b.jpg?im_w=1200"
            class="d-block w-100"
            alt=""
          />
        </div>
        <div class="carousel-item">
          <img src="" class="d-block w-100" alt="" />
        </div>
        <div class="carousel-item">
          <img src="" class="d-block w-100" alt="" />
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselExampleControls"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselExampleControls"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </template>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style scoped>
.app {
  display: flex;
  justify-content: center;
}
</style>
