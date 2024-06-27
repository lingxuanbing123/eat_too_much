<template>
	<!-- 首页外卖列表卡片 -->
  <view class="takeOutCard">
    <!-- 左边大图图片 -->
    <view class="cardImage">
      <image class="cardImagePic" :src="cardImage"></image>
    </view>
    
    <!-- 右边描述 -->
    <view class="cardDescribe">
      <view class="cardName">
        {{ cardName }}
      </view>
      <view class="cardevaluate">
        <view class="cardeValuateGrade">
        {{ rating }}分 月售{{ monthlySales }}+
        </view>
        {{ deliveryTime }}分钟 {{ distance }}km
      </view>
      <view class="deliveryFee">
        起送 {{ minOrder }}元 配送 {{ deliveryFee }}元
      </view>
      <!-- 火山 近30日 373人复购 -->
      <view class="reBuy">
        <view class="reBuyLeft">
          <image class="reBuyImage" :src="reBuyImage"></image>
        </view>
        近30日{{ reBuyers }}人复购
      </view>
      
      <!-- 下拉框按钮 -->
      <view class="hideButton" @click="showHide">
        <image class="hideButtonImg" :src="hideIm"></image>
      </view>
      
      <!-- 未点击隐藏按钮之前显示的内容 -->
      <view v-if="isHide" class="hide">
        <view class="hide1">
          <image class="hide1Img" :src="hide1Img"></image>
          {{ noThreshold }}
        </view>
        <view class="hide2">
          {{ hdiscount1 }}
        </view>
        <view class="hide3">
          {{ hdiscount2 }}
        </view>
      </view>
      <!-- 点击隐藏按钮之后显示的内容 -->
      <view v-else class="unHide">
        <view class="activity">
          活动
          <view class="act1">
            {{ udiscount1 }}
          </view>
          <view class="act2">
            {{ udiscount2 }}
          </view>
          <view class="act3">
            {{ udiscount3 }}
          </view>
          <view class="act4">
            {{ udiscount4 }}
          </view>
        </view>
        <view class="redPocket">
          红包
          <view class="rP1">
            {{ service1 }}
          </view>
          <view class="rP2">
            {{ service2 }}
          </view>
          <view class="rP3">
            {{ service3 }}
          </view>
        </view>
        <view class="service">
          服务
          <view class="sv1">
            先享后付
          </view>
          <view class="sv2">
            食无优
          </view>
          <view class="sv3">
            极速退
          </view>
        </view>
      </view>
    </view>
  </view>
</template>

<script setup>
import { ref } from 'vue'

const props = defineProps({
  cardImage: {
    type: String,
    default: "../../static/indexCard3.jpg"
  },
  cardName: {
    type: String,
    default: "韩小愈猪脚饭(华科店)"
  },
  rating: {
    type: Number,
    default: 5.0
  },
  monthlySales: {
    type: Number,
    default: 300
  },
  deliveryTime: {
    type: Number,
    default: 50
  },
  distance: {
    type: Number,
    default: 1.3
  },
  minOrder: {
    type: Number,
    default: 10
  },
  deliveryFee: {
    type: Number,
    default: 1
  },
  reBuyers: {
    type: Number,
    default: 373
  },
  reBuyImage: {
    type: String,
    default: "../../static/reBuy.png"
  },
  hideImg: {
    type: String,
    default: "../../static/hideButton.png"
  },
  hide1Img: {
    type: String,
    default: "../../static/hide1.png"
  },
  noThreshold: {
    type: String,
    default: "9.5元无门槛"
  },
  hdiscount1: {
    type: String,
    default: "25减2"
  },
  hdiscount2: {
    type: String,
    default: "35减3"
  },
  firstVisitDiscount: {
    type: String,
    default: "首次光顾减1"
  },
  service1: {
    type: String,
    default: "红包满28减8"
  },
  service2: {
    type: String,
    default: "9.5元无门槛"
  },
  service3: {
    type: String,
    default: "3.5元店铺红包"
  },
  udiscount1: {
    type: String,
    default: "活动优惠1"
  },
  udiscount2: {
    type: String,
    default: "活动优惠2"
  },
  udiscount3: {
    type: String,
    default: "活动优惠3"
  },
  udiscount4: {
    type: String,
    default: "活动优惠4"
  }
})

const isHide = ref(true)
const hideIm = ref("../../static/hideButton1.png")

function showHide() {
  isHide.value = !isHide.value
  hideIm.value = isHide.value ? "../../static/hideButton1.png" : "../../static/hideButton2.png"
}
</script>

<style>
.takeOutCard {
  width: 700rpx;
  height: auto;
  display: flex;
  flex-direction: row;
  justify-content: start;
  margin: 15rpx 0 0 15rpx;
  border-radius: 20rpx;
  padding: 15rpx;
  background-color: white;
}

.takeOutCard .cardImage {
  width: 180rpx;
  margin-top: 20rpx;
}

.cardImage .cardImagePic {
  width: 180rpx;
  height: 180rpx;
  border-radius: 10rpx;
  display: flex;
  align-items: center;
}

.takeOutCard .cardDescribe {
  flex-grow: 1;
  border-top-right-radius: 20rpx;
  border-bottom-right-radius: 20rpx;
  display: flex;
  flex-direction: column;
  padding: 5rpx;
}

.cardDescribe .cardName {
  font-size: 30rpx;
  margin: 10rpx 0 0 0;
}

.cardDescribe .cardevaluate {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 23rpx;
  color: gray;
}

.cardevaluate .cardeValuateGrade {
  color: orange;
}

.cardDescribe .deliveryFee {
  font-size: 20rpx;
  color: gray;
}

.cardDescribe .reBuy {
  width: 200rpx;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  background-color: #FFF3E5;
  font-size: 20rpx;
  color: #D7A476;
  border-radius: 20rpx;
  margin: 10rpx 0 0 0;
}

.reBuy .reBuyLeft {
  background-color: #FFD8C1;
  border-top-left-radius: 20rpx;
  border-bottom-left-radius: 20rpx;
}

.reBuy .reBuyImage {
  width: 25rpx;
  height: 25rpx;
}

.cardDescribe .hideButton {
}

.hideButton .hideButtonImg {
  width: 30rpx;
  height: 30rpx;
  margin: 0rpx 0 0 400rpx;
}

.cardDescribe .hide {
  width: 300rpx;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 20rpx;
  margin: -30rpx 0 0 0;
}

.hide .hide1 {
  padding: 3rpx;
  border: 2rpx solid #D1944F;
  color: #D1944F;
  border-radius: 5rpx;
}

.hide1 .hide1Img {
  width: 20rpx;
  height: 20rpx;
}

.hide .hide2, .hide3 {
  color: #C97A81;
  border: 2rpx solid #C97A10;
  border-radius: 5rpx;
}

.unHide .activity {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 20rpx;
  color: gray;
}

.activity .act1, .act2, .act3, .act4 {
  color: red;
  border: 2rpx solid #C97A81;
  border-radius: 5rpx;
}

.unHide .redPocket {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 20rpx;
  color: gray;
  margin-top: 10rpx;
}

.redPocket .rP1, .rP2, .rP3 {
  color: red;
  border: 2rpx solid #C97A81;
  border-radius: 5rpx;
}

.unHide .service {
  display: flex;
  flex-direction: row;
  justify-content: start;
  font-size: 20rpx;
  color: gray;
  margin-top: 10rpx;
}

.unHide .sv1, .sv2, .sv3 {
  color: black;
  border: 2rpx solid black;
  border-radius: 5rpx;
  margin-left: 10rpx;
}
</style>
