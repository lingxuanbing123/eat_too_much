<template>
  <view class="container">
    <view class="formHead">
		<view class="oT1">
			全部
		</view>
		<view class="oT1">
			进行中
		</view>
		<view class="oT1">
			待评价
		</view>
		<view class="oT1">
			退款
		</view>
	
	</view>
    <view class="orderFormContent">
      <orderFormCard
        v-for="(item, index) in orderItems"
        :key="index"
        :imgSrc="item.cdPic" 
        :name="item.commodityName"
        :price="item.dCost"
        :quantity="item.quantity"
      />
    </view>
  </view>
</template>

<script setup>
import { useStore } from 'vuex';
import { computed } from 'vue';
import orderFormCard from '@/components/orderFormCard.vue';

const store = useStore();

// 从 Vuex 获取订单项目
const orderItems = computed(() => store.getters.orderItems);

// 调试输出
console.log("orderItems:", orderItems.value);
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


.formHead .oT1,
.formHead .oT2,
.formHead .oT3,
.formHead .oT4 {
	display: flex;
	justify-content: center;
	align-items: center;
}

.container .formList {
	width: 100%;
	padding-bottom: 100rpx;
}
</style>