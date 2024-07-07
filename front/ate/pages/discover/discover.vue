<template>
	<view class="container">
		<view class="top">
			<view class="dicoverTitle">
				<image class="dicoverTitlePic" src="../../static/discoverTitle.png"></image>
			</view>
			<view class="topList">
				<view class="topListItem" v-for="(item,index) in topList" :key="item.id">
					<image class="topListItemPic" :src="item.img"></image>
						{{item.name}}
				</view>
			</view>	
		</view>
		<view class="cardList">
			<takeOutCard
			    v-for="card in takeOutCards" 
			    :key="card.id"
			    :card-image="card.cardImage"
			    :card-name="card.cardName"
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
</template>

<script>
	import takeOutCard from '@/components/takeOutCard.vue'
	export default {
		components: {
		  takeOutCard
		},
		created() {
		    this.fetchData();
		  },
		
		data() {
			return {
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
				],
				topList: [
					{id: 1, img: '../../static/tL1.png', name: '冰激凌'},
					{id: 2, img: '../../static/tL2.png', name: '甜点'},
					{id: 3, img: '../../static/tL3.png', name: '汉堡'},
					{id: 4, img: '../../static/tL4.png', name: '甜点'},
					{id: 5, img: '../../static/tL5.png', name: '水果捞'},
					{id: 6, img: '../../static/tL6.png', name: '披萨'},
					{id: 7, img: '../../static/tL7.png', name: '快餐'},
					{id: 8, img: '../../static/tL8.png', name: '主食'},
					{id: 9, img: '../../static/tL9.png', name: '甜点'}
				]
			}
		},
		methods: {
			fetchData(){
					  fetch('http://localhost:8089/info').then(res=>res.json())
					      .then(res=>{
					          console.log(res);
					      })
					      .catch(e=>{console.error(e)
					      uni.navigateTo({
					        url: `/pages/logIn/logIn`
					      });
					      })
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

.container .top {
	width: 100%;
	height: 200rpx;
}

.top .dicoverTitle {
	width: 100%;
	height: 80rpx;
}

.dicoverTitle .dicoverTitlePic {
	width: 165rpx;
	height: 70rpx;
	padding: 10rpx;
}

.container .cardList {
	width: 100%;
	padding-bottom: 100rpx;
	height: auto;
}

.top .topList {
	width: 100%;
	height: 120rpx;
	display: flex;
	flex-direction: row;
	overflow-x: scroll;
	white-space: nowrap;
}

.topList .topListItem {
	width: 120rpx;
	height: 120rpx;
	display: inline-flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-left: 20rpx;
}

.topListItem .topListItemPic {
	width: 100rpx;
	height: 100rpx;
}
</style>
