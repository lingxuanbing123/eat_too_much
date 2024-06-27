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
					<!-- 美食外卖一系列图标 -->
				</view>
			</view>
			
			<view class="indexList">
				<takeOutCard />
			</view>
			
		</view>
	</view>
</template>

<script>
import takeOutCard from '@/components/takeOutCard.vue'

export default {
  components: {
    takeOutCard
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

.container .tabbar {
	width: 100%;
	height: 400rpx;
	background-color: brown;
}
</style>