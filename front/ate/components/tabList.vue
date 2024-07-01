<!-- TabList.vue -->
<template>
 
    <view class="tabList">
      <view 
        v-for="(item, index) in tabLists" 
        :key="index" 
        @click="tabChose(index)" 
        :class="['tabListItem', { active: selectedTab === index }]"
      >
        {{ item.text }}
      </view>
    </view>

</template>

<script>
export default {
  name: 'TabList',
  props: {
    tabLists: {
      type: Array,
      required: true,
      default: () => []
    }
  },
  data() {
    return {
      selectedTab: null // 用于跟踪当前选中的tab
    };
  },
  methods: {
    tabChose(index) {
      this.selectedTab = index; // 更新选中的tab索引
      this.$emit('tab-chose', index); // 向父组件发出事件，通知选中的tab
    }
  }
};
</script>

<style scoped>

  
.tabList {
  width: 200rpx;
  /* min-height: 100vh; */
  height: 800rpx;
  background-color: #F2F2F2;
  display: flex;
  flex-direction: column;
}

.tabList .tabListItem {
  padding: 20rpx;
  height: 100rpx;
  /* background-color: beige; */
  cursor: pointer;
}

.tabList .tabListItem.active {
  background-color: white;
}
</style>
