<template>
	<view class="container">
		<view class="myHead">
			个人资料
		</view>
		<view class="basicMes">
			基础信息
		</view>
		<view class="bMList">
			<view class="bMListItem" v-for="(item, index) in bMList" :key="item.id" @click="inputDialogToggle(item)">
				<view class="itemName">
					{{ item.name }}
				</view>
				<view class="rightBtn">
					>
				</view>
			</view>
		</view>
		<!-- 填写信息卡片 -->
		<transition name="dialog-scale">
			<view v-if="isInputDialogVisible" class="overlay" @click="inputDialogToggle"></view>
		</transition>
		<transition name="dialog-scale">
			<view class="inputDialog" v-if="isInputDialogVisible">
				<view class="iDTitle">
					输入内容
				</view>
				<view class="input">
					<input class="inputIn" type="text" :placeholder="inputPlaceholder" />
				</view>
				<view class="iDBtn">
					<view class="iDBtn1" @click="inputDialogToggle">
						取消
					</view>
					<view class="iDBtn2" @click="inputDialogConfirm">
						确定
					</view>
				</view>
			</view>
		</transition>
	</view>
</template>





<script>
export default {
	data() {
		return {
			isInputDialogVisible: false,
			inputPlaceholder: '', // New data property for placeholder
			bMList: [
				{ id: 1, name: '账号' },
				{ id: 2, name: '昵称' },
				{ id: 3, name: '简介' },
				{ id: 4, name: '收货地址' }
			]
		}
	},
	methods: {
		inputDialogToggle(item = null) {
			this.isInputDialogVisible = !this.isInputDialogVisible;
			if (item) {
				this.inputPlaceholder = `请输入${item.name}`;
			}
		},
		inputDialogConfirm() {
			// Handle confirmation logic here
			this.isInputDialogVisible = false;
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

.container .myHead{
	width: 100%;
	height: 100rpx;
	display: flex;
	flex-direction: row;
	background-color:#FFFFFF;
	justify-content: space-around;
	align-items: center;
	font-size: 35rpx;
}

.container .basicMes{
	width: 100%;
	height: 80rpx;
	display: flex;
	align-items: center;
}

.container .bMList{
	width: 100%;
	height:300rpx;
}

.bMList .bMListItem{
	width: 100%;
	height: 80rpx;
	display: flex;
	flex-direction: row;
	background-color: #FFFFFF;
	border-bottom: 2rpx solid #F5F5F5;
}

.bMListItem .itemName{
	width: 700rpx;
	display: flex;
	justify-content: start;
	align-items: center;
	font-size: 30rpx;
}

.bMListItem .rightBtn{
	width: 50rpx;
	display: flex;
	justify-content: start;
	align-items: center;
	font-size: 40rpx;
}

/* Overlay */
.overlay {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	z-index: 999;
}

/* Centered inputDialog */
.container .inputDialog{
	width: 650rpx;
	height: 320rpx;
	background-color: white;
	border-radius: 20rpx;
	display: flex;
	flex-direction: column;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	z-index: 1000; /* Higher z-index to appear above the overlay */
}

.inputDialog .iDTitle{
	width: 650rpx;
	height: 100rpx;
	border-top-left-radius:20rpx ;
	border-top-right-radius:20rpx ;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 40rpx;
	color: gray;
}

.inputDialog .input{
	width: 650rpx;
	height: 150rpx;
	display: flex;
	justify-content: center;
	align-items: center;
}

.input .inputIn{
	width: 600rpx;
	height: 80rpx;
	border: 2rpx solid gray;
	border-radius: 20rpx;
}

.inputDialog .iDBtn{
	width: 650rpx;
	height: 100rpx;
	border-bottom-left-radius:20rpx ;
	border-bottom-right-radius:20rpx ;
	display: flex;
	flex-direction: row;
}

.iDBtn .iDBtn1{
	width: 325rpx;
	height: 80rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	color: gray;
	border-bottom-left-radius:20rpx ;
	font-size: 40rpx;
	border-top: 2rpx solid gray;
	border-right: 2rpx solid gray;
}

.iDBtn .iDBtn2{
	width: 325rpx;
	height: 80rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	color: #287BFF;
	border-bottom-right-radius:20rpx ;
	font-size: 40rpx;
	border-top: 2rpx solid gray;
}

/* Dialog transition effects */
.dialog-scale-enter-active {
	transition: transform 0.5s;
}

.dialog-scale-leave-active {
	transition: transform 0.1s;
}

.dialog-scale-enter {
	transform: scale(1.2);
}

.dialog-scale-leave-to /* .dialog-scale-leave-active in <2.1.8 */ {
	transform: scale(0.8);
}

</style>
