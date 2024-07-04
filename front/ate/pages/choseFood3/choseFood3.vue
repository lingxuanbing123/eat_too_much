<template>
  <!-- 点单选菜页面 -->
  <view class="container">
    <view class="background">
      <view class="back" @click="backTab">
        <
      </view>
      <image class="backgroundImg" src="../../static/cFB3.jpg"></image>
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
          cdPic: "../../static/panda1.jpg",
          commodityName: "番茄鸡蛋盖码饭",
          commodityEvaluate: "近期4人给出好评",
          csNum: 100,
          cSRate: 98,
          cDiscount: 4.49,
          dCost: 17.9,
          oCost: 39.9
        },
        {
          cdPic: "../../static/panda2.jpg",
          commodityName: "农家小炒肉盖码饭",
          commodityEvaluate: "洪山区小炒肉热销第二名",
          csNum: 100,
          cSRate: 100,
          cDiscount: 5.48,
          dCost: 23,
          oCost: 42
        },
        // 可以继续添加更多商品
        {
          cdPic: "../../static/panda3.jpg",
          commodityName: "土豆回锅肉盖码饭",
          commodityEvaluate: "洪山区热销第9名",
          csNum: 81,
          cSRate: 95,
          cDiscount: 4.25,
          dCost: 23.8,
          oCost: 56
        },
        {
          cdPic: "../../static/panda4.jpg",
          commodityName: "梅菜扣肉饭",
          commodityEvaluate: "洪山区梅菜扣肉第一名",
          csNum: 100,
          cSRate: 93,
          cDiscount: 5.06,
          dCost: 24.8,
          oCost: 49
        },
        {
          cdPic: "../../static/panda5.jpg",
          commodityName: "五香把子肉盖饭",
          commodityEvaluate: "洪山区盖饭回头客第4名",
          csNum: 100,
          cSRate: 100,
          cDiscount: 3.37,
          dCost: 24.6,
          oCost: 66
        }
      ],
      items: [], // 初始化一个空的购物车商品数组
      merchantName: "熊猫盖码饭（华科校内店）",
      merchantGrade: 4.9,
      deliveryTime: 45,
      salesNum: 3000,
      noticeDescribe: "校内寝室楼下配送，主营湘味盖码饭...",
      merchantImage: "../../static/indexCard2.jpg"
    };
  },
  methods: {
    backTab() {
      uni.switchTab({
        url: '/pages/discover/discover'
      });
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
