<template>
	<view class="container">
		<view class="indexTitle">
			<!-- 常用|推荐 -->
			<view class="buttonBox">
				<view class="titleButton1">
					常点
				</view>
				<view class="titleButton2">
					推荐
				</view>
			</view>
			
			<view class="location">
				华中科技大学东校区
			</view>
		</view>
		<view class="prefer">
			<!-- 搜索框 -->
			<view class="indexSearch">
				<view class="searchText">
					<input type="text" placeholder="韩小愈猪脚饭 | 华科校内店" />
				</view>
				<view class="searchButton">
					搜索
				</view>
			</view>

			<!--美食外卖  -->
			<view class="indexSquare">
				<!-- 美食外卖 -->
				<view class="squareItem">
					
				</view>
			</view>
			
			<view class="indexList">
				<view class="takeOutCard">
					<!-- 左边大图图片 -->
					<view class="cardImage">
						<image class="cardImagePic" src="../../static/indexCard3.jpg"></image>
					</view>
					
					<!-- 右边描述 -->
					<view class="cardDescribe">
						<view class="cardName">
							韩小愈猪脚饭(华科店)
						</view>
						<view class="cardevaluate">
							<view class="cardeValuateGrade">
								5.0分  月售300+
							</view>
							50分钟 1.3km
						</view>
						
						<view class="deliveryFee">
							起送 10元 配送 1元
						</view>
						<!-- 火山 近30日 373人复购 -->
						<view class="reBuy">
							<view class="reBuyLeft">
								<image class="reBuyImage" src="../../static/reBuy.png"></image>
							</view>
							近30日373人复购
						</view>
						
						<!-- 下拉框按钮 -->
						<view class="hideButton" @click="showHide">
							<image class="hideButtonImg" :src="hideIm"></image>
						</view>
						
						<!-- 未点击隐藏按钮之前显示的内容 -->
						<view v-if="isHide" class="hide">
							<view class="hide1">
								<image class="hide1Img" src="../../static/hide1.png"></image>
								9.5元无门槛
							</view>
							<view class="hide2">
								25减2
							</view>
							<view class="hide3">
								35减3
							</view>
						</view>
						<!-- 点击隐藏按钮之后显示的内容 -->
						<view v-else class="unHide">
							<view class="activity">
								活动
								<view class="act1">
									25减2
								</view>
								<view class="act2">
									35减3
								</view>
								<view class="act3">
									55减5
								</view>
								<view class="act4">
									首次光顾减1
								</view>
							</view>
							<view class="redPocket">
								红包
								<view class="rP1">
									红包满28减8
								</view>
								<view class="rP2">
									9.5元无门槛
								</view>
								<view class="rP3">
									3.5元店铺红包
								</view>
							</view>
							<view class="service">
								服务
								<view class="sv1">
									先享后付
								</view>
								<view class="sv2">
									食无优
								</view>
								<view class="sv3">
									极速退
								</view>
							</view>
						</view>
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
				isHide: true,
				hideIm:"../../static/hideButton1.png"
				
			}
		},
		onLoad() {

		},
		methods: {
			showHide() {
				this.isHide = !this.isHide;
				this.hideIm = this.isHide ? "../../static/hideButton1.png":"../../static/hideButton2.png"; 
			}
		}
	}
</script>

<style>
.container {
	position: relative;
	background-color: whitesmoke;
	min-height: 100vh;
}

.container .indexTitle {
	width: 100%;
	height: 70rpx;
	background-color: whitesmoke;
	display: flex;
	flex-direction: row;
	padding: 20rpx;
}

.indexTitle .buttonBox {
	display: flex;
	flex-direction: row;
	font-size: 40rpx;
	height: 50rpx;
}

.buttonBox .titleButton1 {
	padding: 5rpx;
	border-right: 4rpx solid #D8D8D8;
}

.buttonBox .titleButton2 {
	padding: 5rpx;
}

.indexTitle .location {
	display: flex;
	flex-direction: row;
	margin-left: 250rpx;
	padding: 5rpx;
	font-size: 31rpx;
}

.prefer .indexSearch {
	width: 720rpx;
	height: 50rpx;
	background-color: #FEFFFA;
	border-radius: 50rpx;
	border: 4rpx solid #28ADE6;
	padding: 5rpx;
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	align-items: center;
	margin-left: 10rpx;
}

.indexSearch .searchText {
	padding: 5rpx;
	width: 600rpx;
}

.indexSearch .searchButton {
	width: 120rpx;
	height: 45rpx;
	padding: 5rpx;
	font-size: 35rpx;
	background-color: #25C6FD;
	color: white;
	text-align: center;
	align-items: center;
	border-radius: 50rpx;
	display: flex;
	justify-content: center;
}

.prefer .indexSquare {
	width: 100%;
	height: 400rpx;
	background-color: lightblue;
}

.prefer .indexList {
	width: 100%;
}

.indexList .takeOutCard {
	width: 700rpx;
	height: auto;
	display: flex;
	flex-direction: row;
	justify-content: start;
	margin: 15rpx 0 0 15rpx;
	border-radius: 20rpx;
	padding: 15rpx;
	background-color: white;
}

.takeOutCard .cardImage {
	width: 180rpx;
	margin-top: 20rpx;
}

.cardImage .cardImagePic {
	width: 180rpx;
	height: 180rpx;
	border-radius: 10rpx;
	display: flex;
	align-items: center;
}

.takeOutCard .cardDescribe {
	flex-grow: 1;
	border-top-right-radius: 20rpx;
	border-bottom-right-radius: 20rpx;
	display: flex;
	flex-direction: column;
	padding: 5rpx;
}

.cardDescribe .cardName {
	font-size: 30rpx;
	margin: 10rpx 0 0 0;
}

.cardDescribe .cardevaluate {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	font-size: 23rpx;
	color: gray;
}

.cardevaluate .cardeValuateGrade {
	color: orange;
}

.cardDescribe .deliveryFee {
	font-size: 20rpx;
	color: gray;
}

.cardDescribe .reBuy {
	width: 200rpx;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
	background-color: #FFF3E5;
	font-size: 20rpx;
	color: #D7A476;
	border-radius: 20rpx;
	margin: 10rpx 0 0 0;
}

.reBuy .reBuyLeft {
	background-color: #FFD8C1;
	border-top-left-radius: 20rpx;
	border-bottom-left-radius: 20rpx;
}

.reBuy .reBuyImage {
	width: 25rpx;
	height: 25rpx;
}

.cardDescribe .hideButton {
}

.hideButton .hideButtonImg {
	width: 30rpx;
	height: 30rpx;
	margin: 0rpx 0 0 400rpx;
}

.cardDescribe .hide {
	width: 300rpx;
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	font-size: 20rpx;
	margin: -30rpx 0 0 0;
}

.hide .hide1 {
	padding: 3rpx;
	border: 2rpx solid #D1944F;
	color: #D1944F;
	border-radius: 5rpx;
}

.hide1 .hide1Img {
	width: 20rpx;
	height: 20rpx;
}

.hide .hide2,.hide3 {
	color: #C97A81;
	border: 2rpx solid #C97A10;
	border-radius: 5rpx;
}

.unHide .activity {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	font-size: 20rpx;
	color: gray;
}

.activity .act1, .act2, .act3, .act4 {
	color: red;
	border: 2rpx solid #C97A81;
	border-radius: 5rpx;
}

.unHide .redPocket {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	font-size: 20rpx;
	color: gray;
	margin-top: 10rpx;
}

.redPocket .rP1, .rP2, .rP3 {
	color: red;
	border: 2rpx solid #C97A81;
	border-radius: 5rpx;
}

.unHide .service {
	display: flex;
	flex-direction: row;
	justify-content: start;
	font-size: 20rpx;
	color: gray;
	margin-top: 10rpx;
}

.unHide .sv1, .sv2, .sv3 {
	color: black;
	border: 2rpx solid black;
	border-radius: 5rpx;
	margin-left: 10rpx;
}

.container .tabbar {
	width: 100%;
	height: 400rpx;
	background-color: brown;
}
</style>