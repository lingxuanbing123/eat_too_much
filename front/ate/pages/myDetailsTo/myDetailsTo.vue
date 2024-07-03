<template>
  <view class="container">
    <view class="title">
      <view class="back" @click="backMyDetails">
        <
      </view>
      <view class="head">
        {{ name }}
      </view>
      <view v-if="id !== 1" class="addhead" @click="toChangeDetails">
        新增{{ name }}
      </view>
    </view>
    <!-- 显示账号，地址，昵称的内容 -->
    <view class="mainPage">
      
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      id: null,
      name: ''
    }
  },
  onLoad(options) {
    this.id = parseInt(options.id);
    this.name = options.name;
  },
  methods: {
    backMyDetails() {
      uni.navigateBack();
    },
    toChangeDetails() {
      uni.navigateTo({
        url: `/pages/changeDetails/changeDetails?name=${this.name}`
      });
    }
  }
}
</script>

<style>
.container {
  position: relative;
  background-color: whitesmoke;
  min-height: 100vh;
}

.container .title {
  width: 100%;
  height: 100rpx;
  background-color: beige;
  display: flex;
  flex-direction: row;
}

.title .back {
  width: 150rpx;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 50rpx;
}

.title .head {
  width: 450rpx;
  display: flex;
  justify-content: center;
  align-items: center;
}

.title .addhead {
  width: 150rpx;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
