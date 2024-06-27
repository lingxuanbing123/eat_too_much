<template>
	<view class="container">
		<!-- 外卖商家信息展示卡片 -->
	<!-- <deliveryMerchantCardVue /> -->
	<commodityCardVue />
	</view>
</template>

<script>
	import commodityCardVue from '@/components/commodityCard.vue'
	// import deliveryMerchantCardVue from '@/components/deliveryMerchantCard.vue'
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		},
		components: {
			// deliveryMerchantCardVue
			commodityCardVue
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
