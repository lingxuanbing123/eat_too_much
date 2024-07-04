<!-- myDetails -->
<!-- 点击myDetail后显示密码，简介，收货地址页面  -->
<template>
  <view class="container">
    <view class="title">
      <view class="back" @click="backMyDetails">
        <
      </view>
      <view class="head">
        {{ name }}
      </view>
      <view v-if="id !== 1" class="addhead" @click="toChangeDetails">
        修改{{ name }}
      </view>
    </view>
    <view class="mainPage">
      {{ inputValue }}
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
      id: null,
      name: '',
      inputValue: '',
    }
  },
  onLoad(options) {
    this.id = parseInt(options.id);
    this.name = options.name;
  },
  methods: {
    backMyDetails() {
      uni.switchTab({
        url: '/pages/MyDetails/MyDetails'
      });
    },
	fetchData(){
			  fetch('http://localhost:8089/info')
			      .then(res => res.json())
			      .then(data => {
			        if (this.id === 1) {
			          console.log(data.userid); // 假设您想打印对象的 userid 属性
			          // 其他处理逻辑
					  //const storedValues1 = uni.getStorageSync('storedValues') || {};
					  this.inputValue = data.userid; 
					            // 赋值操作
			        }
					if (this.id === 2){
						console.log(data.password); // 假设您想打印对象的 userid 属性
						this.inputValue = data.password;
					}
			      })
			      .catch(e => {
			        console.error(e)
			        uni.navigateTo({
			          url: `/pages/logIn/logIn`
			        });
			      });

	},
    toChangeDetails() {
      uni.navigateTo({
        url: `/pages/changeDetails/changeDetails?id=${this.id}&name=${this.name}`
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

.container .title {
  width: 100%;
  height: 100rpx;
  background-color: cadetblue;
  font-size: 40rpx;
  display: flex;
  flex-direction: row;
}

.title .back {
  width: 150rpx;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 50rpx;
}

.title .head {
  width: 450rpx;
  display: flex;
  justify-content: center;
  align-items: center;
}

.title .addhead {
  width: 150rpx;
  display: flex;
  justify-content: center;
  align-items: center;
}

.container .mainPage{
	width: 700rpx;
	height: 100rpx;
	background-color: white;
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 100rpx 0 0 25rpx;
}
</style>