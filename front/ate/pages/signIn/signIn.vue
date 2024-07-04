<!-- 注册页面 -->
<template>
	<view class="container">
		<view class="title">
			<view class="titleLeft" @click="backToLogin">
				<
			</view>
			<view class="titleRight">
				注册页面
			</view>
		</view>
		<view class="regesterCard">
			<!-- 账号 -->
			<view class="atCard">
				<input class="at" type="text" placeholder="请输入账号" />
			</view>
			<!-- 密码 -->
			<view class="passwordCard">
				<input class="password" type="text" placeholder="请输入密码"/>
			</view>
			<view class="phoneNumCard">
				<input class="phoneNum" type="text" placeholder="请输入电话号码" />
			</view>
			<view class="rePasswordCard">
				<input class="rePassword" type="text" placeholder="请确认密码"/>
			</view>
			
			
			<view class="signLnNotice">
				<view class="signLnNoticeLeft">
				</view>
				注意事项: 账号 ，密码为2-10位
			</view>
			<view class="registerBtn">
				注册
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
			backToLogin(){
				uni.navigateTo({
				  url: `/pages/logIn/logIn`
				});
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
   flex-direction: column; /* 确保子元素按列布局 */
   align-items: center; /* 水平居中 */
	
}

.container .title{
	width: 100%;
	height: 100rpx;
	display: flex;
	flex-direction: row;
	background-color: cadetblue;
	color: white;
}

.title .titleLeft{
	width: 100rpx;
	height: 100rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-right: 200rpx;
}

.title .titleRight{
	width: 450rpx;
	height: 100rpx;
	display: flex;
	justify-content: start;
	align-items: center;
}

.container .regesterCard{
	width: 700rpx;
	height: 1000rpx;
	border-radius: 20rpx;
	background-color: white;
	margin: 100rpx 0 0 0rpx;
	
}

.regesterCard .atCard{
	
	width: 700rpx;
	height: 100rpx;
	margin-top: 80rpx;
	display: flex;
	justify-content: center;
	align-items: center;
}

.atCard .at{
	width: 600rpx;
	height: 60rpx;
	border-bottom: 2rpx solid gray;
	
}

.regesterCard .passwordCard{
	width: 700rpx;
	height: 100rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	margin:50rpx 0 0 0rpx;
}

.passwordCard .password{
	width: 600rpx;
	height: 60rpx;
	border-bottom: 2rpx solid gray;
}

.regesterCard .phoneNumCard{
	width: 700rpx;
	height: 100rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	margin:50rpx 0 0 0rpx;
}

.phoneNumCard .phoneNum{
	width: 600rpx;
	height: 60rpx;
	border-bottom: 2rpx solid gray;
}

.regesterCard .rePasswordCard{
	width: 700rpx;
	height: 100rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	margin:50rpx 0 0 0rpx;
} 

.rePasswordCard .rePassword{
	width: 600rpx;
	height: 60rpx;
	border-bottom: 2rpx solid gray;
}






.regesterCard .signLnNotice{
	width: 700rpx;
	height: 50rpx;
	display: flex;
	justify-content:start;
	align-items: center;
	margin:20rpx 0 0 0rpx;
	color: gray;
}

.signLnNotice .signLnNoticeLeft{
	width: 50rpx;
}

.regesterCard .registerBtn{
	width: 500rpx;
	height: 100rpx;
	background-color: cadetblue;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 35rpx;
	margin:50rpx 0 0 100rpx;
	border-radius: 20rpx;
	color: white;
}
</style>
