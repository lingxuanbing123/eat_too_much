<template>
  <view class="orderForm">
    <view class="orderFormTitle">订单详情</view>
    <view class="orderFormContent">
      <orderFormCard
        v-for="(item, index) in orderItems"
        :key="index"
        :imgSrc="item.imgSrc" 
        :name="item.name"
        :price="item.price"
        :quantity="item.quantity"
      />
    </view>
  </view>
</template>

<script setup>
import { useStore } from 'vuex';
import orderFormCard from '@/components/orderFormCard.vue';

const store = useStore();

// 从 Vuex 获取订单项目
const orderItems = store.state.orderItems;
</script>

<style>
.container {
	background-color: #F4F7FC;
	min-height: 100vh;
	width: 750rpx;
}

.container .formHead {
	width: 100%;
	height: 100rpx;
	background-color: #F4F7FC;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
}

.formHead .fH1,
.formHead .fH2,
.formHead .fH3,
.formHead .fH4 {
	display: flex;
	justify-content: center;
	align-items: center;
}

.container .formList {
	width: 100%;
	padding-bottom: 100rpx;
}
</style>