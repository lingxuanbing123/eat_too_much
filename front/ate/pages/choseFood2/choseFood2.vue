<template>
  <!-- 点单选菜页面 -->
  <view class="container">
    <view class="background">
      <view class="back" @click="backTab">
        <
      </view>
      <image class="backgroundImg" src="../../static/cFB2.jpg"></image>
      <image src="" mode=""></image>
    </view>
    <view class="nameCard">
      <deliveryMerchantCard 
        :merchantName="merchantName"
        :merchantGrade="merchantGrade"
        :deliveryTime="deliveryTime"
        :salesNum="salesNum"
        :noticeDescribe="noticeDescribe"
        :merchantImage="merchantImage"
      />
    </view>
    <!-- 点菜列表 -->
    <view class="bottom">
      <view class="tabListContainer">
        <tabListVue :tabLists="tabLists" @tab-chose="handleTabChose" />
      </view>
      <view class="bottomList">
        <view class="bottomListItem" v-for="(commodity, index) in commodities" :key="index">
          <commodityCardVue
            :cdPic="commodity.cdPic"
            :commodityName="commodity.commodityName"
            :commodityEvaluate="commodity.commodityEvaluate"
            :csNum="commodity.csNum"
            :cSRate="commodity.cSRate"
            :cDiscount="commodity.cDiscount"
            :dCost="commodity.dCost"
            :oCost="commodity.oCost"
          />
        </view>
      </view>
    </view>
    <!-- 引入购物车组件 -->
    <ShoppingCart :items="items" @clear-items="clearItems" />
  </view>
</template>

<script>
import deliveryMerchantCard from '@/components/deliveryMerchantCard.vue';
import tabListVue from '@/components/tabList.vue';
import commodityCardVue from '@/components/commodityCard.vue';
import ShoppingCart from '@/components/ShoppingCart.vue';

export default {
	created() {
	    this.fetchData();
	  },
  data() {
    return {
      tabLists: [
        { text: '华科送至宿舍楼下' },
        { text: '粉丝福利' },
        { text: '招牌多肉' },
        { text: '加食双拼满足加料' },
        { text: '美味小吃' },
        { text: '健康饮品' }
      ],
      commodities: [
        {
          cdPic: "../../static/yqc1.jpg",
          commodityName: "葡国奶油焗饭",
          commodityEvaluate: "近期4人给出好评",
          csNum: 400,
          cSRate: 95,
          cDiscount: 5.65,
          dCost: 25.4,
          oCost: 52.9
        },
        {
          cdPic: "../../static/yqc2.jpg",
          commodityName: "黑椒鸡扒饭",
          commodityEvaluate: "洪山区炸鸡排热销第二名",
          csNum: 100,
          cSRate: 96,
          cDiscount: 5.65,
          dCost: 25.9,
          oCost: 52.9
        },
        // 可以继续添加更多商品
        {
          cdPic: "../../static/yqc3.jpg",
          commodityName: "茄汁猪排芝士焗饭",
          commodityEvaluate: "洪山区焗饭热销第9名",
          csNum: 1000,
          cSRate: 95,
          cDiscount: 7.6,
          dCost: 24,
          oCost: 34
        },
        {
          cdPic: "../../static/yqc4.jpg",
          commodityName: "氧气层招牌蛋包饭",
          commodityEvaluate: "洪山区包饭热销第一名",
          csNum: 100,
          cSRate: 93,
          cDiscount: 7.71,
          dCost: 18.9,
          oCost: 24.5
        },
        {
          cdPic: "../../static/yqc5.jpg",
          commodityName: "德克萨斯烤牛肉披萨",
          commodityEvaluate: "洪山区披萨回头客第4名",
          csNum: 100,
          cSRate: 100,
          cDiscount: 7.27,
          dCost: 28.9,
          oCost: 39.9
        }
      ],
      items: [], // 初始化一个空的购物车商品数组
      merchantName: "氧气层（华科东校区店）",
      merchantGrade: 4.4,
      deliveryTime: 50,
      salesNum: 3000,
      noticeDescribe: "华科校内店，可送寝室楼下...",
      merchantImage: "../../static/indexCard1.jpg"
    };
  },
  methods: {
    backTab() {
      uni.switchTab({
        url: '/pages/discover/discover'
      });
    },
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
	},
    handleTabChose(index) {
      console.log('Selected Tab:', index);
      // 可以在这里处理选中tab后的逻辑
    },
    clearItems() {
      this.items = [];
    }
  },
  components: {
    deliveryMerchantCard,
    tabListVue,
    commodityCardVue,
    ShoppingCart
  }
};
</script>

<style>
.container {
  position: relative;
  background-color: whitesmoke;
  min-height: 100vh;
  width: 100%;
}

.container .background {
  width: 100%;
  height: 250rpx;
  z-index: 0;
}

.background .backgroundImg {
  width: 100%;
  height: 250rpx;
  z-index: 1;
}

.background .back {
  position: absolute;
  top: 10rpx;
  left: 10rpx;
  z-index: 2;
  padding: 10rpx;
  border-radius: 5rpx;
  font-size: 55rpx;
}

.nameCard {
  position: absolute;
  top: 200rpx;
  left: 41%;
  transform: translateX(-50%);
  width: 80%;
  z-index: 2;
}

.container .bottom {
  min-height: 80vh;
  margin-top: 180rpx;
  display: flex;
  flex-direction: row;
}

.tabListContainer {
  flex: 1;
  position: relative;
}

.bottom .bottomList {
  min-height: 80vh;
  flex: 3;
}

.bottomList .bottomListItem {
  width: 550rpx;
  height: 210rpx;
  display: flex;
  width: 100%;
  margin-left: -30rpx;
}
</style>
