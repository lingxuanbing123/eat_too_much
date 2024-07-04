<template>
	<!-- nreversion -->
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
				<!-- <view class="searchButton">
					搜索
					
				</view> -->
			<!--美食外卖  -->
			<view class="indexSquare">
				<!-- 美食外卖 -->
				<view class="squareItem" v-for="item in squareItems" :key="item.id">
					<!-- 美食外卖一系列图标 -->
					<image class="squareItemPic" :src="item.imgSrc"></image>
					<view class="squareItemText">
						{{item.text}}
					</view>
				</view>
			</view>
			
			<view class="indexList">
			       <takeOutCard
			               v-for="card in takeOutCards"
			               :key="card.id"
			               :card-name="card.cardName"
			               :card-image="card.cardImage"
			               :rating="card.rating"
			               :monthly-sales="card.monthlySales"
			               :delivery-time="card.deliveryTime"
			               :distance="card.distance"
			               :min-order="card.minOrder"
			               :delivery-fee="card.deliveryFee"
			               :re-buyers="card.reBuyers"
			               :re-buy-image="card.reBuyImage"
			               :hide-img="card.hideImg"
			               :hide1-img="card.hide1Img"
			               :no-threshold="card.noThreshold"
			               :hdiscount1="card.hdiscount1"
			               :hdiscount2="card.hdiscount2"
			               :service1="card.service1"
			               :service2="card.service2"
			               :service3="card.service3"
			               :udiscount1="card.udiscount1"
			               :udiscount2="card.udiscount2"
			               :udiscount3="card.udiscount3"
			               :udiscount4="card.udiscount4"
			             />
			</view>
		</view>
	</view>
</template>

<script>
import takeOutCard from '@/components/takeOutCard.vue'

export default {
  components: {
    takeOutCard
  },
  data(){
	  return {
		squareItems:[
		{id:1,imgSrc:'../../static/takeOut.png',text:'美食外卖'},	
		{id:2,imgSrc:'../../static/supermarket.png',text:'超市便利'},
		{id:3,imgSrc:'../../static/fruit.png',text:'新鲜水果'},
		{id:4,imgSrc:'../../static/vegetables.png',text:'买菜'},
		{id:5,imgSrc:'../../static/medicine.png',text:'买药'},
		{id:6,imgSrc:'../../static/drink.png',text:'甜食饮品'},
		{id:7,imgSrc:'../../static/errand.png',text:'跑腿'},
		{id:8,imgSrc:'../../static/fruit2.png',text:'0元领水果'},
		],
		 takeOutCards: [
		        {
		          id: 1,
		          cardImage: '../../static/indexCard3.jpg',
		          cardName: '韩小愈猪脚饭(华科店)',
		          rating: 5.0,
		          monthlySales: 300,
		          deliveryTime: 50,
		          distance: 1.3,
		          minOrder: 10,
		          deliveryFee: 1,
		          reBuyers: 373,
		          reBuyImage: '../../static/reBuy.png',
		          hideImg: '../../static/hideButton.png',
		          hide1Img: '../../static/hide1.png',
		          noThreshold: '9.5元无门槛',
		          hdiscount1: '25减2',
		          hdiscount2: '35减3',
		          service1: '红包满28减8',
		          service2: '9.5元无门槛',
		          service3: '3.5元店铺红包',
		          udiscount1: '活动优惠1',
		          udiscount2: '活动优惠2',
		          udiscount3: '活动优惠3',
		          udiscount4: '活动优惠4'
		        },
		        // 其他卡片数据
				{
				  id: 2,
				  cardImage: '../../static/indexCard1.jpg',
				  cardName: '氧气层(华科东校区店)',
				  rating: 4.4,
				  monthlySales: 2000,
				  deliveryTime: 45,
				  distance: 1,
				  minOrder: 20,
				  deliveryFee: 1,
				  reBuyers: 433,
				  reBuyImage: '../../static/reBuy.png',
				  hideImg: '../../static/hideButton.png',
				  hide1Img: '../../static/hide1.png',
				  noThreshold: '8元无门槛',
				  hdiscount1: '30减4',
				  hdiscount2: '50减9',
				  service1: '红包满28减8',
				  service2: '8元无门槛',
				  service3: '7元店铺红包',
				  udiscount1: '活动优惠1',
				  udiscount2: '活动优惠',
				  udiscount3: '含2元津贴',
				  udiscount4: '免配送费'
				},
				{
				  id: 3,
				  cardImage: '../../static/indexCard2.jpg',
				  cardName: '熊猫盖码饭(华科校内店)',
				  rating: 4.9,
				  monthlySales: 3000,
				  deliveryTime: 45,
				  distance: 1.9,
				  minOrder: 0,
				  deliveryFee: 1.9,
				  reBuyers: 675,
				  reBuyImage: '../../static/reBuy.png',
				  hideImg: '../../static/hideButton.png',
				  hide1Img: '../../static/hide1.png',
				  noThreshold: '8元无门槛',
				  hdiscount1: '10减6',
				  hdiscount2: '28减10',
				  service1: '红包满28减7',
				  service2: '8元无门槛',
				  service3: '5元店铺红包',
				  udiscount1: '活动优惠1',
				  udiscount2: '活动优惠2',
				  udiscount3: '活动优惠3',
				  udiscount4: '活动优惠4'
				},
				{
				  id: 4,
				  cardImage: '../../static/indexCard3.jpg',
				  cardName: '韩小愈猪脚饭(华科店)',
				  rating: 5.0,
				  monthlySales: 300,
				  deliveryTime: 50,
				  distance: 1.3,
				  minOrder: 10,
				  deliveryFee: 1,
				  reBuyers: 373,
				  reBuyImage: '../../static/reBuy.png',
				  hideImg: '../../static/hideButton.png',
				  hide1Img: '../../static/hide1.png',
				  noThreshold: '9.5元无门槛',
				  hdiscount1: '25减2',
				  hdiscount2: '35减3',
				  service1: '红包满28减8',
				  service2: '9.5元无门槛',
				  service3: '3.5元店铺红包',
				  udiscount1: '活动优惠1',
				  udiscount2: '活动优惠2',
				  udiscount3: '活动优惠3',
				  udiscount4: '活动优惠4'
				},
				{
				  id: 5,
				  cardImage: '../../static/indexCard3.jpg',
				  cardName: '韩小愈猪脚饭(华科店)',
				  rating: 5.0,
				  monthlySales: 300,
				  deliveryTime: 50,
				  distance: 1.3,
				  minOrder: 10,
				  deliveryFee: 1,
				  reBuyers: 373,
				  reBuyImage: '../../static/reBuy.png',
				  hideImg: '../../static/hideButton.png',
				  hide1Img: '../../static/hide1.png',
				  noThreshold: '9.5元无门槛',
				  hdiscount1: '25减2',
				  hdiscount2: '35减3',
				  service1: '红包满28减8',
				  service2: '9.5元无门槛',
				  service3: '3.5元店铺红包',
				  udiscount1: '活动优惠1',
				  udiscount2: '活动优惠2',
				  udiscount3: '活动优惠3',
				  udiscount4: '活动优惠4'
				},
				{
				  id: 6,
				  cardImage: '../../static/indexCard3.jpg',
				  cardName: '韩小愈猪脚饭(华科店)',
				  rating: 5.0,
				  monthlySales: 300,
				  deliveryTime: 50,
				  distance: 1.3,
				  minOrder: 10,
				  deliveryFee: 1,
				  reBuyers: 373,
				  reBuyImage: '../../static/reBuy.png',
				  hideImg: '../../static/hideButton.png',
				  hide1Img: '../../static/hide1.png',
				  noThreshold: '9.5元无门槛',
				  hdiscount1: '25减2',
				  hdiscount2: '35减3',
				  service1: '红包满28减8',
				  service2: '9.5元无门槛',
				  service3: '3.5元店铺红包',
				  udiscount1: '活动优惠1',
				  udiscount2: '活动优惠2',
				  udiscount3: '活动优惠3',
				  udiscount4: '活动优惠4'
				},
		    ]
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
	font-size: 30rpx;
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
	border-radius: 30rpx;
	display: flex;
	justify-content: center;
}

.prefer .indexSquare {
	width: 100%;
	height: 300rpx;
	/* background-color: whitesmoke; */
	background-color: white;
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
}

.indexSquare .squareItem{
	width: 140rpx;
	height: 140rpx;

	margin-left: 40rpx;
} 

.squareItem .squareItemPic{
	width: 80rpx;
	height: 80rpx;
	margin: 10rpx 0 0 30rpx;
}

.squareItem .squareItemText{
	font-size: 25rpx;
	color: gray;
	display: flex;
	justify-content: center;
}

.prefer .indexList {
	width: 100%;
	padding-bottom: 100rpx;
}


</style>