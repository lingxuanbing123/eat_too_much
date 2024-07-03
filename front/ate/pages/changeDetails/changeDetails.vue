<template>
  <view class="container">
    <view class="title">
      <!-- 返回上一个页面 -->
      <view class="back" @click="backLast">
        <
      </view>
      <view class="head">
        修改{{ name }}
      </view>
      <view class="right"></view>
    </view>

    <view class="input">
      <input class="inputItem" type="text" :placeholder="notice" v-model="inputValue"/>
    </view>
    <view class="inputNotice">
      {{ name }} 只能修改一次，5-24个字
    </view>
    <!-- 确认按钮 -->
    <view class="inputBtn" :class="{ active: isInputValid }" @click="confirmChange">
      确认修改
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      name: '',
      notice: '',
      inputValue: ''
    }
  },
  computed: {
    isInputValid() {
      return this.inputValue.length >= 5 && this.inputValue.length <= 24;
    }
  },
  onLoad(options) {
    this.name = options.name;
    this.notice = `请输入${this.name}`;
  },
  methods: {
    backLast() {
      uni.navigateBack();
    },
    confirmChange() {
      if (this.isInputValid) {
        // Store the input value in localStorage or Vuex
        uni.setStorageSync('inputValue', this.inputValue);

        // Navigate to myDetailsTo page
        uni.navigateTo({
          url: `/pages/myDetailsTo/myDetailsTo`
        });
      }
    }
  }
}
</script>

<style>
.container {
  position: relative;
  min-height: 100vh;
}
.container .title {
  width: 100%;
  height: 100rpx;
  display: flex;
  flex-direction: row;
}

.title .back {
  width: 100rpx;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 50rpx;
}

.title .head {
  width: 550rpx;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 30rpx;
}

.title .right {
  width: 100;
}

.container .input {
  width: 100%;
  height: 150rpx;
  display: flex;
  justify-content: center;
  align-items: center;
}

.input .inputItem {
  width: 90%;
  height: 70rpx;
  padding: 15rpx;
  font-size: 35rpx;
  background-color: white;
}

.container .inputNotice {
  width: 100%;
  height: 100rpx;
  color: gray;
  margin-left: 30rpx;
}

.container .inputBtn {
  width: 550rpx;
  height: 70rpx;
  background-color: grey;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-left: 100rpx;
  border-radius: 10rpx;
}

.inputBtn.active {
  background-color: #01B5FA;
}
</style>
