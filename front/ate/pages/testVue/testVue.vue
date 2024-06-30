<template>
	<view class="container">
		<!-- 外卖商家信息展示卡片 -->
	<!-- <deliveryMerchantCardVue /> -->
	<tabListVue />
	</view>
</template>

<script>
	import tabListVue from '@/components/tabList.vue'
	// import deliveryMercha ntCardVue from '@/components/deliveryMerchantCard.vue'
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		},
		components: {
			// deliveryMerchantCardVue
			tabListVue
		}
	}
</script>

<style>
.container{
	background-color: whitesmoke;	
	min-height: 100vh;
	width: 750rpx;
	}


</style>
