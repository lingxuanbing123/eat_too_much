<template>
  <view class="container">
    <!-- 外卖商家信息展示卡片 -->
    <!-- <deliveryMerchantCardVue /> -->
    <tabListVue :tabLists="tabLists" @tab-chose="handleTabChose" />
  </view>
</template>

<script>
import tabListVue from '@/components/tabList.vue'
// import deliveryMerchantCardVue from '@/components/deliveryMerchantCard.vue'

export default {
  components: {
    // deliveryMerchantCardVue,
    tabListVue
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
      ]
    }
  },
  methods: {
    handleTabChose(index) {
      console.log('Selected Tab:', index);
      // 可以在这里处理选中tab后的逻辑
    }
  }
}
</script>

<style scoped>
.container {
  background-color: whitesmoke;  
  min-height: 100vh;
  width: 750rpx;
}
</style>
