<template>
	<!-- 点菜的列表里面的卡片 -->
	<view class="commodityCard">
		<view class="commodityCardImg">
			<image class="commodityCardPic" :src="cdPic"></image>
		</view>
		<view class="commodityCardDec">
			<view class="commodityName">
				{{commodityName}}
			</view>
			<view class="commodityEvaluate">
				{{commodityEvaluate}}
			</view>
			<view class="commoditySale">
				月售{{csNum}}+ 好评率{{cSRate}}%
			</view>
			<view class="commodityDiscount">
				{{cDiscount}}折
			</view>
			<!-- 价格以及加入购物车按钮 -->
			<view class="saleCost">
				<view class="discountCost">
					{{dCost}}元
				</view>
				<view class="originalCost">
					{{oCost}}元
				</view>
				<view class="addTrolly">
					<image class="addTrollyPic" src="../static/addTrolly.png" mode=""></image>
				</view>
			</view>
		</view>
	</view>
</template>


<script setup>
import { defineProps } from 'vue'

const props = defineProps({
	cdPic: {
		type: String,
		default: "../../static/indexCard3.jpg"
	},
	commodityName: {
		type: String,
		default: "猪脚+配菜+米饭"
	},
	commodityEvaluate: {
		type: String,
		default: "洪山区炖肘子热销第一名"
	},
	csNum: {
		type: Number,
		default: 1000
	},
	cSRate: {
		type: Number,
		default: 95
	},
	cDiscount: {
		type: Number,
		default: 7.49
	},
	dCost: {
		type: Number,
		default: 23.9
	},
	oCost: {
		type: Number,
		default: 32.5
	}
})
</script>


<style>
.commodityCard {
	width: 550rpx;
	height: 200rpx;
	background-color: white;
	margin: 10rpx 0 0 50rpx;
	display: flex;
	flex-direction: row;
}

.commodityCard .commodityCardImg {
	width: 200rpx;
	height: 160rpx;
}

.commodityCardImg .commodityCardPic {
	width: 170rpx;
	height: 170rpx;
	border-radius: 15rpx;
	margin: 10rpx 0 0 10rpx;
}

.commodityCard .commodityCardDec {
	width: 300rpx;
	height: 200rpx;
	display: flex;
	flex-direction: column;
}

.commodityCardDec .commodityName {
	font-size: 30rpx;
}

.commodityCardDec .commodityEvaluate {
	width: 220rpx;
	border-radius: 10rpx;
	font-size: 20rpx;
	background-color: #FEF2E1;
	color: #957D57;
}

.commodityCardDec .commoditySale {
	color: #A5A5A3;
	font-size: 25rpx;
}

.commodityCardDec .commodityDiscount {
	width: 70rpx;
	color: #E26E70;
	border: 2rpx solid #E26E70;
	font-size: 20rpx;
	border-radius: 10rpx;
	padding: 2rpx;
}

.commodityCardDec .saleCost {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
}

.saleCost .discountCost {
	font-size: 25rpx;
	font-weight: 700;
}

.saleCost .originalCost {
	color: gray;
	font-size: 20rpx;
	margin-top: 3rpx;
	padding: 3rpx;
}

.saleCost .addTrolly {
	width: 50rpx;
	height: 50rpx;
}

.addTrolly .addTrollyPic {
	width: 50rpx;
	height: 50rpx;
}

</style>