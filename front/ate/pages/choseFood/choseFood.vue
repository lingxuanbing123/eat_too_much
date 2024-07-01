<template>
	<!-- 点单选菜页面 -->
	<view class="container">
		<view class="background">
			<image class="backgroundImg" src="../../static/cFB1.jpg"></image>
		</view>
		<view class="nameCard">
			<deliveryMerchantCard />
		</view>
		
	</view>
</template>

<script>
import deliveryMerchantCard from '@/components/deliveryMerchantCard.vue'
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		},
		components: {
			deliveryMerchantCard
		}
	}
</script>

<style>
.container {
	position: relative;
	background-color: whitesmoke;
	min-height: 100vh;
}

.container .background {
	width: 100%;
	height: 250rpx;
	position: relative; /* Add this to position the nameCard relative to the background */
	z-index: 1; /* Ensure background is beneath the nameCard */
}

.background .backgroundImg {
	width: 100%;
	height: 250rpx;
	position: relative; /* Add this to position the nameCard relative to the background */
	z-index: 1; /* Ensure background is beneath the nameCard */
}

.nameCard {
	position: absolute; /* Position absolutely within the relative container */
	top: 200rpx; /* Position it slightly above the bottom of the background */
	left: 41%;
	transform: translateX(-50%); /* Center it horizontally */
	width: 80%; /* Adjust width as needed */
	z-index: 2; /* Ensure nameCard is above the background */
}


</style>
