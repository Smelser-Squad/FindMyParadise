<template>
  <div class="row">
    <div class="left">
      <img
        class="leftImage"
        src="https://a0.muscache.com/im/pictures/36283cf5-95c8-4c70-800f-b1c5a9a6f5a0.jpg?im_w=1200"
      />
    </div>
    <div class="rightSide">
      <img
        class="rightTop"
        src="https://a0.muscache.com/im/pictures/73b354de-ca65-45a4-a492-a6f8c922edc2.jpg?im_w=720"
      />
      <img
        class="rightTopR"
        src="https://a0.muscache.com/im/pictures/d4a660ca-31ea-41d0-94bd-d277657d170a.jpg?im_w=720"
      />
      <img
        class="rightBot"
        src="https://a0.muscache.com/im/pictures/15d1a761-3e20-4631-83ca-32594fa88975.jpg?im_w=1440"
      />
      <img
        class="rightBotR"
        src="https://a0.muscache.com/im/pictures/939d189e-560e-49fd-aa01-b0f26740b786.jpg?im_w=720"
      />
    </div>
  </div>
</template>

<style scoped>
.rightSide {
  width: 50%;
  height: 100%;
}
.left {
  width: 50%;
  height: 100%;
  overflow: hidden;
}
.leftImage {
  border-right: 4px solid #ffffff;
  object-fit: cover;
  transform: translateX(-20%);
  transform: translateY(-20%);
}
.rightTop {
  width: 50%;
  height: 50%;
  border-left: 4px solid #ffffff;
  border-bottom: 4px solid #ffffff;
  border-right: 4px solid #ffffff;
  object-fit: fill;
  overflow: hidden;
}
.rightTopR {
  width: 50%;
  height: 50%;
  border-left: 4px solid #ffffff;
  border-bottom: 4px solid #ffffff;
  object-fit: fill;
  overflow: hidden;
}
.rightBot {
  width: 50%;
  height: 50%;
  border-left: 4px solid #ffffff;
  border-top: 4px solid #ffffff;
  border-right: 4px solid #ffffff;
  object-fit: fill;
  overflow: hidden;
}
.rightBotR {
  width: 50%;
  height: 50%;
  border-left: 4px solid #ffffff;
  border-top: 4px solid #ffffff;
  object-fit: cover;
  overflow: hidden;
}
.row {
  border-radius: 5px;
  object-fit: fill;
}
</style>
