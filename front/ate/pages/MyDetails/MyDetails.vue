<template>
  <view class="container">
    <view class="myHead">
      个人资料
    </view>
    <view class="basicMes">
      基础信息
    </view>
    <view class="bMList">
      <view class="bMListItem" v-for="(item, index) in bMList" :key="item.id" @click="detailsTo(item)">
        <view class="itemName">
          {{ item.name }}
        </view>
        <view class="rightBtn">
          >
        </view>
      </view>
    </view>
  </view>
</template>

<script>
export default {
created() {
	    this.fetchData();
	  },
  data() {
    return {
      bMList: [
        { id: 1, name: '账号' },
        { id: 2, name: '密码' },
        { id: 3, name: '简介' },
        { id: 4, name: '收货地址' }
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
	  },
    detailsTo(item) {
      uni.navigateTo({
        url: `/pages/myDetailsTo/myDetailsTo?id=${item.id}&name=${item.name}`
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
}

.container .myHead {
  width: 100%;
  height: 100rpx;
  display: flex;
  flex-direction: row;
  background-color: #FFFFFF;
  justify-content: space-around;
  align-items: center;
  font-size: 35rpx;
}

.container .basicMes {
  width: 100%;
  height: 80rpx;
  display: flex;
  align-items: center;
}

.container .bMList {
  width: 100%;
  height: 300rpx;
}

.bMList .bMListItem {
  width: 100%;
  height: 80rpx;
  display: flex;
  flex-direction: row;
  background-color: #FFFFFF;
  border-bottom: 2rpx solid #F5F5F5;
}

.bMListItem .itemName {
  width: 700rpx;
  display: flex;
  justify-content: start;
  align-items: center;
  font-size: 30rpx;
}

.bMListItem .rightBtn {
  width: 50rpx;
  display: flex;
  justify-content: start;
  align-items: center;
  font-size: 40rpx;
}
</style>
