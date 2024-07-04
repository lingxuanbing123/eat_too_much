<template>
	<view class="container">
		<view class="title">
			<view class="titleLeft">
				地址管理页面
			</view>
			<view class="titleRight">
				增加地址
			</view>
		</view>
		
		<view class="addressList">
			<view class="addressItem" v-for="item in addressList" :key="item.id">
				<view class="addressItemLeft">
				</view>
				<view class="address">
					{{item.address}}
				</view>
				<view class="addressRight" @click="deteaddressItem(item.id)">
					<view class="deletBtn">
						删除
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
				addressList:[
					{id:1,address:'华中科技大学'},
					{id:2,address:'大学'},
					{id:3,address:'大学'},
					{id:4,address:'大学'},
					
				]
			}
		},
		methods: {
			deteaddressItem(id){
				this.addressList = this.addressList.filter(item => item.id !== id);
			}
		}
	}
</script>

<style>
.container {
	position: relative;
	background-color: whitesmoke;
	min-height: 100vh;
	display: flex;
	flex-direction: column;
}

.container .title{
	width: 100%;
	height: 100rpx;
	background-color: cadetblue;
	display: flex;
	flex-direction: row;
	color: white;
}

.title .titleLeft{
	width: 600rpx;
	height: 100rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-left: 120rpx;
}

.title .titleRight{
	width: 150rpx;
	height: 100rpx;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container .addressList{
	width: 700rpx;
	min-height: 900rpx;
	background-color: white;
	display: flex;
	flex-direction: column;
	margin: 150rpx 0 0 25rpx;
}

.addressList .addressItem{
	width: 700rpx;
	height: 100rpx;
	margin-top: 20rpx;
	display: flex;
	flex-direction: row;
	color: black;
	border-bottom: 2rpx solid gray;
}

.addressItem .addressItemLeft{
	width: 20rpx;
	height: 100rpx;
}

.addressItem .address{
	width: 580rpx;
	height: 100rpx;
	display: flex;
	justify-content: start;
	align-items: center;
	font-size: 30rpx;
	
}

.addressItem .addressRight{
	width: 150rpx;
	height: 100rpx;
	display: flex;
	justify-content: center;
	align-items: center;
}

.addressRight .deletBtn{
	width: 120rpx;
	height: 70rpx;
	background-color: cadetblue;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 20rpx;
	color: white;
}





</style>
