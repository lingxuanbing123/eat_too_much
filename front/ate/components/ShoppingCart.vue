<template>
  <view class="container">
    <!-- 弹出层--显示点单的卡片列表 -->
    <view v-if="showJumpCard" class="overlay" @click="toggleJumpCard"></view>
    <view class="jumpCard" v-if="showJumpCard">
      <view class="jumpCardTitle">
        已选商品
        <view class="deleteList" @click="clearItems">
          <image class="deleteListImg" src="../static/deleteList.png" ></image>
          清空
        </view>
      </view>
      <!-- 存放卡片列表 -->
      <view class="jumpCardList">
        <!-- 这里模拟一些内容 -->
        <view v-if="hasContent">商品内容</view>
      </view>
    </view>
    <!-- choseFood页面底部底单汇总的卡片 -->
    <view class="choseFoodTotalCard">
      <view class="cardLeft" @click="toggleJumpCard">
        <image class="cardLeftImg" :src="cardLeftImgSrc"></image>
        <view class="numShow" v-if="hasContent">
          {{ itemCount }}
        </view>
        <view class="totalMoney">
          {{ totalMoney }}
        </view>
      </view>
      <view class="cardright">
        <view :class="settleButtonClass">
          结算
        </view>
      </view>
    </view>
  </view>
</template>

<script setup>
import { ref, computed, defineProps, defineEmits } from 'vue';

// 定义 props
const props = defineProps({
  items: {
    type: Array,
    default: () => []
  }
});

// 定义 emits
const emit = defineEmits(['clear-items']);

// 本地状态
const showJumpCard = ref(false);

// 计算属性
const hasContent = computed(() => props.items.length > 0);
const cardLeftImgSrc = computed(() => hasContent.value ? '../../static/cFTAfter.png' : '../../static/cFTBefore.png');
const itemCount = computed(() => props.items.length);
const totalMoney = computed(() => '¥' + props.items.reduce((sum, item) => sum + item.price, 0).toFixed(2));
const settleButtonClass = computed(() => hasContent.value ? 'rightBtn active' : 'rightBtn inactive');

// 方法
const toggleJumpCard = () => {
  showJumpCard.value = !showJumpCard.value;
};

const clearItems = () => {
  emit('clear-items');
  showJumpCard.value = false;
};
</script>

<style scoped>
.container {
  background-color: whitesmoke;
  min-height: 100vh;
  width: 750rpx;
  position: relative;
}
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 1;
  transition: opacity 0.2s;
}
.jumpCard {
  width: 100%;
  height: 20vh;
  background-color: white;
  border-top-left-radius: 20rpx;
  border-top-right-radius: 20rpx;
  position: fixed;
  bottom: 6vh; /* 放在 choseFoodTotalCard 上面 */
  left: 0;
  z-index: 2;
  transition: transform 0.2s;
}
.jumpCard.show {
  transform: translateY(0);
}
.jumpCard .jumpCardTitle {
  width: 100%;
  height: 4vh;
  border-top-left-radius: 20rpx;
  border-top-right-radius: 20rpx;
  border-bottom: 2rpx solid gray;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding: 5rpx;
  background-color: #FEF6DF;
  font-weight: 550;
}
.jumpCardTitle .deleteList {
  width: 150rpx;
  height: 5vh;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #cdcdcd;
}
.deleteList .deleteListImg {
  width: 40rpx;
  height: 3vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.jumpCard .jumpCardList {
  min-height: 10vh;
  background-color: #FFFFFF;
}
.choseFoodTotalCard {
  width: 100%;
  height: 9vh;
  display: flex;
  flex-direction: row;
  position: fixed;
  bottom: 0;
  left: 0;
  background-color: #FFFFFF;
  z-index: 3;
}
.choseFoodTotalCard .cardLeft {
  width: 500rpx;
  height: 8vh;
  display: flex;
  flex-direction: row;
}
.cardLeft .cardLeftImg {
  width: 100rpx;
  height: 5vh;
  padding: 20rpx;
}
.cardLeft .numShow {
  width: 30rpx;
  height: 30rpx;
  background-color: red;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 50rpx;
  margin: 10rpx 0 0 -30rpx;
}
.cardLeft .totalMoney {
  width: 100rpx;
  height: 5vh;
  padding: 20rpx;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 30rpx;
  font-weight: 700;
}
.choseFoodTotalCard .cardright {
  width: 250rpx;
  height: 8vh;
  display: flex;
  align-items: center;
  justify-content: center;
}
.rightBtn {
  width: 220rpx;
  height: 5vh;
  margin: 10rpx 0 0 10rpx;
  border-radius: 40rpx;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 30rpx;
  color: white;
}
.rightBtn.active {
  background-color: #01B5FE;
}
.rightBtn.inactive {
  background-color: #777777;
}
</style>
