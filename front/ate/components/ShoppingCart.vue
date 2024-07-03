<template>
  <view class="container">
    <!-- 覆盖层用于展示选购卡片 -->
    <view v-if="showJumpCard" class="overlay" @click="toggleJumpCard"></view>

    <!-- 选购卡片 -->
    <view class="jumpCard" :class="{ show: showJumpCard }">
      <view class="jumpCardTitle">
        已选商品
        <view class="deleteList" @click="clearItems">
          <image class="deleteListImg" src="../static/deleteList.png"></image>
          清空
        </view>
      </view>
      <view class="jumpCardList">
        <!-- 已选商品列表 -->
        <orderedListCard
          v-for="(item, index) in items"
          :key="index"
          :imgSrc="item.cdPic"
          :name="item.commodityName"
          :price="item.dCost"
          :initialNum="item.quantity"
        />
        <view class="jumpCardListBottom"></view>
      </view>
    </view>

    <!-- 总计和结算部分 -->
    <view class="choseFoodTotalCard">
      <!-- 左侧部分显示商品数量和总金额 -->
      <view class="cardLeft" @click="toggleJumpCard">
        <image class="cardLeftImg" src="../static/cFTAfter.png"></image>
        <view class="numShow" v-if="hasContent">
          {{ itemCount }}
        </view>
        <view class="totalMoney">
          {{ totalMoney }}
        </view>
      </view>
      
      <!-- 右侧结算按钮 -->
      <view class="cardright" @click="handleSettle">
        <view :class="settleButtonClass">
          结算
        </view>
      </view>
    </view>
  </view>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useStore } from 'vuex';
import orderedListCard from '@/components/orderedListCard.vue';

const store = useStore();

// 计算属性
const items = computed(() => store.getters.cartItems);
const itemCount = computed(() => store.getters.cartItemCount);
const totalMoney = computed(() => '¥' + store.getters.cartTotalPrice.toFixed(2));
const showJumpCard = ref(false);
const hasContent = computed(() => items.value.length > 0);
const settleButtonClass = computed(() => hasContent.value ? 'rightBtn active' : 'rightBtn inactive');

// 方法
const toggleJumpCard = () => {
  showJumpCard.value = !showJumpCard.value;
};

const clearItems = () => {
  store.dispatch('clearCart');
  showJumpCard.value = false;
};

const handleSettle = () => {
  if (hasContent.value) {
    console.log("Settling order with items:", items.value); // 调试输出
    store.dispatch('setOrderItems', items.value);

    // 导航到 orderForm 页面
    uni.switchTab({
      url: '/pages/orderForm/orderForm'
    });
  }
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
  background-color: white;
  border-top-left-radius: 20rpx;
  border-top-right-radius: 20rpx;
  position: fixed;
  bottom: 6vh;
  left: 0;
  z-index: 2;
  transition: max-height 0.2s ease-out, transform 0.2s ease-out;
  max-height: 0;
  overflow: hidden;
}
.jumpCard.show {
  max-height: 80vh; /* 这里设定一个最大高度 */
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
  background-color: #FFFFFF;
  max-height: 76vh;
  overflow-y: auto;
}

.jumpCardList .jumpCardListBottom{
	width: 100%;
	height: 50rpx;
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