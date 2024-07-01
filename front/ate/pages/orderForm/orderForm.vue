<template>
	<view class="container">
		<view class="formHead">
			<view class="fH1">全部</view>
			<view class="fH2">进行中</view>
			<view class="fH3">待评价</view>
			<view class="fH4">退款</view>
		</view>

		<view class="formList">
			<orderFormCardVue 
				v-for="item in formCardList" 
				:key="item.id"
				:titleOne="item.titleOne"
				:status="item.status"
				:titleTwo="item.titleTwo"
				:price="item.price"
				:orderNum="item.orderNum"
				:orderTime="item.orderTime"
				:orderDishesList="item.orderDishesList"
			/>
		</view>
	</view>
</template>

<script>
import orderFormCardVue from '@/components/orderFormCard.vue'

export default {
	data() {
		return {
			formCardList: [
				{
					id: 1,
					titleOne: "韩小愈猪脚饭(华科店)",
					status: "已送达",
					titleTwo: "接受预订中",
					price: 26.4,
					orderNum: 1,
					orderTime: "2024-06-28 10:49:25",
					orderDishesList: [
						{ id: 1, img: '../../static/indexCard3.jpg'},
						{ id: 2, img: '../../static/indexCard2.jpg'},
						{ id: 3, img: '../../static/indexCard1.jpg'}
					]
				},
				{
					id: 2,
					titleOne: "韩小愈猪脚饭(华科店)",
					status: "已送达",
					titleTwo: "接受预订中",
					price: 26.4,
					orderNum: 1,
					orderTime: "2024-06-28 10:49:25",
					orderDishesList: [
						{ id: 1, img: '../../static/indexCard3.jpg'},
						{ id: 2, img: '../../static/indexCard2.jpg'},
						{ id: 3, img: '../../static/indexCard1.jpg'}
					]
				},
				{
					id: 3,
					titleOne: "韩小愈猪脚饭(华科店)",
					status: "已送达",
					titleTwo: "接受预订中",
					price: 26.4,
					orderNum: 1,
					orderTime: "2024-06-28 10:49:25",
					orderDishesList: [
						{ id: 1, img: '../../static/indexCard3.jpg'},
						{ id: 2, img: '../../static/indexCard2.jpg'},
						{ id: 3, img: '../../static/indexCard1.jpg'}
					]
				}
			]
		}
	},
	components: {
		orderFormCardVue
	},
	created() {
		console.log("formCardList: ", this.formCardList);
	}
}
</script>

<style>
.container {
	background-color: #F4F7FC;
	min-height: 100vh;
	width: 750rpx;
}

.container .formHead {
	width: 100%;
	height: 100rpx;
	background-color: #F4F7FC;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
}

.formHead .fH1,
.formHead .fH2,
.formHead .fH3,
.formHead .fH4 {
	display: flex;
	justify-content: center;
	align-items: center;
}

.container .formList {
	width: 100%;
	padding-bottom: 100rpx;
}
</style>
