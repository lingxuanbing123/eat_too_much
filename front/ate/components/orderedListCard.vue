<!-- OrderedListCard.vue -->
<template>
  <view class="orderedListCard" v-if="oCLNum > 0">
    <view class="oLCImg">
      <image class="oLCImgPic" :src="imgSrc"></image>
    </view>
    <view class="oLCDes">
      <view class="oLCName">
        {{ name }}
      </view>
      <view class="oLCAdd">
        {{ additionalInfo }}
      </view>
      <view class="oLCprice">
        {{ price }}元
      </view>
    </view>
    <view class="oLCNumBtn">
      <view class="leftBtn" @click="decrement">
        <image class="leftBtnPic" :src="leftPic"></image>
      </view>
      <view class="oLCNum">
        {{ oCLNum }}
      </view>
      <view class="rightBtn" @click="increment">
        <image class="rightBtnPic" :src="rightPic"></image>
      </view>
    </view>
  </view>
</template>

<script setup>
import { ref } from 'vue';
import { defineProps } from 'vue';

const props = defineProps({
  initialNum: {
    type: Number,
    default: 1
  },
  imgSrc: {
    type: String,
    default: '../../static/indexCard3.jpg'
  },
  leftPic:{
    type: String,
    default: '../../static/delete.png'
  },
  rightPic:{
    type: String,
    default: '../../static/addTrolly.png'
  },
  name: {
    type: String,
    default: '【销量top】猪脚+配菜+米饭'
  },
  additionalInfo: {
    type: String,
    default: '不加'
  },
  price: {
    type: String,
    default: '21.9'
  }
});

const oCLNum = ref(props.initialNum);

const increment = () => {
  oCLNum.value += 1;
};

const decrement = () => {
  if (oCLNum.value > 1) {
    oCLNum.value -= 1;
  } else {
    oCLNum.value = 0;
  }
};
</script>


<style scoped>
.orderedListCard {
  width: 100%;
  height: 150rpx;
  display: flex;
  flex-direction: row;
}

.orderedListCard .oLCImg {
  width: 150rpx;
  height: 150rpx;
}

.oLCImg .oLCImgPic {
  width: 140rpx;
  height: 140rpx;
  border-radius: 15rpx;
  margin: 5rpx 0 0 5rpx;
}

.orderedListCard .oLCDes {
  width: 400rpx;
  height: 150rpx;
  display: flex;
  flex-direction: column;
}

.oLCDes .oLCName {
  height: 50rpx;
}

.oLCDes .oLCAdd {
  display: flex;
  height: 50rpx;
  font-size: 20rpx;
  align-items: center;
  color: gray;
}

.oLCDes .oLCprice {
  height: 50rpx;
  display: flex;
  align-items: center;
  color: #D65C45;
  font-weight: 700;
}

.orderedListCard .oLCNumBtn {
  width: 200rpx;
  height: 50rpx;
  display: flex;
  flex-direction: row;
  margin-top: 100rpx;
}

.oLCNumBtn .leftBtn,
.rightBtn {
  width: 50rpx;
  height: 50rpx;
  display: flex;
  justify-content: center;
  align-items: center;
}

.oLCNumBtn .leftBtnPic,
.rightBtnPic {
  width: 40rpx;
  height: 40rpx;
}

.oLCNumBtn .oLCNum {
  height: 50rpx;
  width: 80rpx;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 40rpx;
}
</style>
