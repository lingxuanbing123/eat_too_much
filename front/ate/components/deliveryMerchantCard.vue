<template>
	<view class="container">
		<!-- 外卖商家信息展示卡片 -->
		
			<view class="deliveryMerchantCard">
				<view class="merchantHead">
					<view class="headLeft">
						<view class="merchantName">
							<!-- 韩小愈猪脚饭（华科店） -->
							{{merchantName}}
						</view>
						<view class="nameDescribe">
							<view class="nameD1">
								{{merchantGrade}}分 
							</view>
							<view class="nameD2">
								商家自配送 
							</view>
							
							约{{deliveryTime}}分钟 月售{{salesNum}}+ 售后无忧、
							
						</view>
					</view>
					
					<view class="headImg">
						<image class="headPic" :src="merchantImage" mode=""></image>
					</view>
				</view>
				
				
				<view class="notice">
					<!-- 公告：猪脚饭常有而伯乐不常有。健康为首，精选正大猪肉,... -->
					公告:{{noticeDescribe}}
				</view>
				<!-- 9.5元无门槛 -- 优惠券 -->
			<!-- 	<view class="discount">
				</view> -->
				<view class="cardLogo">
					<view class="cL1">
						25减2
					</view>
					<view class="cL2">
						35减3
					</view>
					<view class="cL3">
						55减5
					</view>
					<view class="cL4">
						首次光顾减1
					</view>
					<view class="cL5">
						配送费优惠
					
					</view>
				</view>
			</view>
	</view>
	
	
	
</template>

<script setup>
import {ref} from 'vue'

const props = defineProps({
	merchantName: {
		type: String,
		default:"韩小愈猪脚饭（华科店）"
	},
	merchantGrade: {
		type: Number,
		default: "4.8"
	},
	deliveryTime: {
		type: Number,
		default : "50"
	},
	salesNum: {
		type: Number,
		default: "3000"
	},
	noticeDescribe:{
		type: String,
		default: "猪脚饭常有而伯乐不常有。健康为首，精选正大猪肉,..."
	},
	merchantImage: {
			type: String,
			default: "../../static/indexCard3.jpg"
	}
})

</script>

<style>
.deliveryMerchantCard{
	width: 700rpx;
	height: 200rpx;
	background-color: white;
	margin:25rpx 0 0 25rpx;
	border-radius: 20rpx;
	display: flex;
	flex-direction: column;
}

.deliveryMerchantCard .merchantHead{
	width: 700rpx;
	height: 75rpx;
	border-top-left-radius: 25rpx;
	padding: 20rpx;
	display: flex;
	flex-direction: row;
	justify-content: start;
}

.merchantHead .headLeft{
	width: 550rpx;
	height: 100rpx;
	display: flex;
	flex-direction: column;
	
	
}

.headLeft .merchantName{
	width: 500rpx;
	height: 30px;
	border-top-left-radius: 25rpx;
	font-size: 30rpx;
}

.headLeft .nameDescribe{
	width: 500rpx;
	height: 30rpx;
	font-size: 20rpx;
	display: flex;
	flex-direction: row;
	justify-content: start;	
}

.nameDescribe .nameD1{
	color: #F2832E;
	
}

.nameDescribe .nameD2{
	border: 2rpx solid #DADADA;
	border-radius: 10rpx;
	font-size: 19rpx;
	margin-left: 10rpx;
	color: #7E7E7E;
}

.merchantHead .headImg{
	width: 100rpx;
	height: 100rpx;

}

.headImg .headPic{
	width: 90rpx;
	height: 90rpx;

	border-radius: 10rpx;
}

.deliveryMerchantCard .notice{
	width: 700rpx;
	height: 30rpx;
	/* background-color: darkcyan; */
	font-size: 20rpx;
	color: #7E7E7E;
	margin-left: 20rpx;
}

/* .deliveryMerchantCard .discount{
	width: 700rpx;
	height: 60rpx;
	background-color: beige;
} */

.deliveryMerchantCard .cardLogo{
	width: 700rpx;
	height: 30rpx;
	/* background-color: aquamarine; */
	display: flex;
	flex-direction: row;
	justify-content: start;
}

.cardLogo .cL1,.cL2,.cL3,.cL4,.cL5{
	border: 2rpx solid darkred;
	color: red;
	font-size: 15rpx;
	margin-left: 20rpx;
	border-radius: 5rpx;
	padding: 5rpx;
}


</style>
