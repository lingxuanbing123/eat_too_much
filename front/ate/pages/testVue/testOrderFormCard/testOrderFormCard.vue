<template>
  <view class="container">
    <!-- 外卖商家信息展示卡片 -->
    <orderFormCardVue
	titleOne="韩小愈猪脚饭(华科店)"
	status="已送达"
	titleTwo="接受预订中"
	:price="26.4"
	:orderNum="1"
	orderTime="2024-06-28 10:49:25"
	:orderDishesList="orderDishesList"
    />
  </view>
</template>

<script>
import orderFormCardVue from '@/components/orderFormCard.vue'
export default {
		data() {
			return {
				 orderDishesList: [
					{ id: 1, img:'../../../static/indexCard3.jpg' },
					{ id: 2, img: '../../../static/indexCard2.jpg' },
					{ id: 3, img: '../../../static/indexCard1.jpg' },
					{ id: 4, img: '../../../static/indexCard2.jpg' },
					{ id: 5, img: '../../../static/indexCard1.jpg' },
					{ id: 6, img: '../../../static/indexCard3.jpg'},
					{ id: 7, img: '../../../static/indexCard2.jpg' },
					{ id: 8, img:'../../../static/indexCard1.jpg' }
				]
			}
		},
		methods: {
			
		},
		components: {
			// deliveryMerchantCardVue
			orderFormCardVue
		}
	}
</script>

<style>
.container {
  background-color: whitesmoke;
  min-height: 100vh;
  width: 750rpx;
}
</style>
