<template>
	<!-- 外卖订单页面卡片 -->
    <view class="orderFormCard">
      <view class="cardTitle">
        <view class="cardTitleImg">
          <image class="cardTitlePic" src="@/static/indexCard3.jpg"></image>
        </view>
        <view class="title">
          <view class="titleOne">{{ titleOne }}</view>
          <view class="status">{{ status }}</view>
          <view class="titleTwo">{{ titleTwo }}</view>
        </view>
      </view>
      <view class="orderDishes">
        <view class="orderDishesList">
          <view
            class="orderDishesImg"
            v-for="(item, index) in orderDishesList"
            :key="item.id"
          >
            <image class="orderDishesImgPic" :src="item.img"></image>
          </view>
        </view>
        <view class="price">
          {{ price }}元
          <view class="orderNum">共{{ orderNum }}件</view>
        </view>
      </view>
      <!-- 时间 -->
      <view class="orderTime">{{ orderTime }}</view>
      <view class="bottomButton">
        <view class="bottomButton1" @click="toggleDis">再来一单</view>
        <view class="bottomButton2">评价</view>
      </view>
    </view>
 
</template>

<script setup>
import {ref} from 'vue' 
const props = defineProps({
  titleOne: {
    type: String,
    default: '韩小愈猪脚饭(华科店)',
  },
  status: {
    type: String,
    default: '已送达',
  },
  titleTwo: {
    type: String,
    default: '接受预订中',
  },
  price: {
    type: Number,
    default: 26.4,
  },
  orderNum: {
    type: Number,
    default: 1,
  },
  orderTime: {
    type: String,
    default: '2024-06-28 10:49:25',
  },
  orderDishesList: {
    type: Array,
    default: () => []
  }
})

const toggleDis = () => {
  uni.switchTab({
  	url: '/pages/discover/discover'
  });
}
</script>

<style scoped>


.orderFormCard {
  width: 700rpx;
  height: 400rpx;
  background-color: white;
  margin-left: 25rpx;
  border-radius: 20rpx;
  margin-top: 20rpx;
}

.orderFormCard .cardTitle {
  width: 700rpx;
  height: 130rpx;
  display: flex;
  flex-direction: row;
  border-top-left-radius: 20rpx;
  border-top-right-radius: 20rpx;
}

.cardTitle .cardTitleImg {
  width: 100rpx;
  height: 100rpx;
}

.cardTitleImg .cardTitlePic {
  width: 90rpx;
  height: 90rpx;
  border-radius: 20rpx;
  margin: 20rpx 0 0 20rpx;
}

.cardTitle .title {
  width: 550rpx;
  height: 100rpx;
  margin: 20rpx 0 0 20rpx;
  display: flex;
  flex-direction: column;
}

.title .titleOne {
  height: 60rpx;
  display: flex;
  align-items: center;
  font-size: 30rpx;
  justify-content: space-between;
}

.titleOne .status {
  font-size: 25rpx;
  color: #989898;
}

.titleTwo {
  width: 100rpx;
  height: 40rpx;
  display: flex;
  align-items: center;
  font-size: 20rpx;
  color: white;
  border: 2rpx solid #4ccf99;
  background-color: #4ccf99;
  border-radius: 10rpx;
}

.orderFormCard .orderDishes {
  width: 700rpx;
  height: 150rpx;
  display: flex;
  flex-direction: row;
}

.orderDishes .orderDishesList {
  width: 600rpx;
  height: 150rpx;
  display: flex;
  flex-direction: row;
  overflow-x: scroll;
  white-space: nowrap;
}

.orderDishesList .orderDishesImg {
  width: 150rpx;
  height: 150rpx;
}

.orderDishesImg .orderDishesImgPic {
  width: 140rpx;
  height: 140rpx;
  border-radius: 20rpx;
  margin: 5rpx 10rpx;
}

.orderDishes .price {
  height: 150rpx;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.orderPrice .orderNum {
  font-size: 25rpx;
  color: gray;
}

.orderFormCard .orderTime {
  height: 50rpx;
  display: flex;
  align-items: center;
}

.orderFormCard .bottomButton {
  height: 50rpx;
  display: flex;
  flex-direction: row-reverse;
}

.bottomButton .bottomButton1,
.bottomButton .bottomButton2 {
  width: 150rpx;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 40rpx;
}

.bottomButton .bottomButton1 {
  margin-left: 10rpx;
  border: 2rpx solid #37a2bf;
  color: #37a2bf;
}

.bottomButton .bottomButton2 {
  border: 2rpx solid gray;
}
</style>
