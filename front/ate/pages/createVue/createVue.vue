<template>
	<view class="container">
		<view class="commodityCard">
			<view class="commodityCardImg">
				<image class="commodityCardPic" src="../../static/indexCard3.jpg"></image>
			</view>
			<view class="commodityCardDec">
				<view class="commodityName">
					猪脚+配菜+米饭
				</view>
				<view class="commodityEvaluate">
					洪山区炖肘子热销第一名
				</view>
				<view class="commoditySale">
					月售1000+ 好评率95%
				</view>
				<view class="commodityDiscount">
					7.42折
				</view>
				
				<!-- 价格以及加入购物车按钮 -->
				<view class="saleCost">
					<view class="discountCost">
						23.9元
					</view>
					<view class="originalCost">
						32.5元
					</view>
					<view class="addTrolly">
						<image class="addTrollyPic" src="../../static/addTrolly.png" mode=""></image>
					</view>
				</view>
			</view>
		</view>
		
	</view>
	
	
	
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
.container{
	background-color: whitesmoke;	
	min-height: 100vh;
	width: 750rpx;
	}
.commodityCard{
	width: 550rpx;
	height: 200rpx;
	background-color: white;
	margin: 100rpx 0 0 200rpx;
	display: flex;
	flex-direction: row;
	
}

.commodityCard .commodityCardImg{
	width: 200rpx;
	height: 160rpx;
}

.commodityCardImg .commodityCardPic{
	width: 170rpx;
	height: 170rpx;
	border-radius: 15rpx;
	margin: 10rpx 0 0 10rpx;
}

.commodityCard .commodityCardDec{
	width: 300rpx;
	height: 200rpx;
	/* background-color: gray; */
	display: flex;
	flex-direction: column;
}

.commodityCardDec .commodityName{
	font-size: 30rpx;
}

.commodityCardDec .commodityEvaluate{
	width: 220rpx;
	border-radius: 10rpx;
	font-size: 20rpx;
	background-color: #FEF2E1;
	color: #957D57;
}

.commodityCardDec .commoditySale{
	color:#A5A5A3 ;
	font-size: 25rpx;
}

.commodityCardDec .commodityDiscount{
	width: 70rpx;
	color: #E26E70;
	border: 2rpx solid #E26E70;
	font-size: 20rpx;
	border-radius: 10rpx;
	padding: 2rpx;
}

.commodityCardDec .saleCost{
	display: flex;
	flex-direction: row;
	justify-content: space-between;
}

.saleCost .discountCost{
	font-size: 25rpx;
	font-weight: 700;
	
}

.saleCost .originalCost{
	color: gray;
	font-size: 20rpx;
	margin-top: 3rpx ;
	padding: 3rpx;
}

.saleCost .addTrolly{
	width: 50rpx;
	height: 50rpx;
}

.addTrolly .addTrollyPic{
	width: 50rpx;
	height: 50rpx;
	
}

</style>
