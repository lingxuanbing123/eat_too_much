<!-- 登录界面 -->
<template>
	<view class="container">
		<view class="title">
			登录
		</view>
		<view class="logInCard">
			<view class="accountCard">
				<input class="account" type="text" placeholder="请输入账号" v-model="username" />
			</view>
			<view class="passwordCard">
				<input class="password" type="password" placeholder="请输入密码" v-model="pwd"/>
			</view>
			<view class="register" @click="regiTo">
				<view class="registerLeft">
				</view>
				注册
			</view>
			<view class="logInBtn" @click="login">
				登录
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				username:'',
				pwd:''
			}
		},
		methods: {
			regiTo(){
				uni.navigateTo({
				  url: `/pages/signIn/signIn`
				});
			},
			login() {
			        const username = this.username;
			        const pwd = this.pwd;
			        if(!username||!pwd){
			            alert("请填写完整的用户名和密码");
			            return
			        }
			        fetch('http://localhost:8089/login',{
			            method: 'POST',
			            headers: {
			                "Content-Type": "application/json;charset=UTF-8"
			            },
			            body: JSON.stringify({username:username,password: pwd})
			        }).then(res =>res.text()).then(res => {
			            ///console.log(res);
			            if (res){
			                console.log(res)
			                let json = JSON.parse(res)
			                if(json.id){
			                    alert("登录成功")
			                    uni.switchTab({
			                      url: `/pages/index/index`
			                    });
			                }
			            }else {
			                alert("用户名或密码错误")
			            }
			        })
			    }
			
		}
	}
</script>

<style>
.container {
  min-height: 100vh;
  background-color: whitesmoke;
}

.container .title{
	width: 100%;
	height: 100rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 40rpx;
	color: white;
	background-color: cadetblue;
}

.container .logInCard{
	width: 700rpx;
	height: 700rpx;
	background-color: white;
	margin: 180rpx 0 0 25rpx;
	display: flex;
	flex-direction: column;
	border-radius: 20rpx;
}

.logInCard .accountCard{
	width: 700rpx;
	height: 100rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	margin:50rpx 0 0 0rpx;
}

.accountCard .account{
	width: 600rpx;
	height: 60rpx;
	border-bottom: 2rpx solid gray;
}

.logInCard .passwordCard{
	width: 700rpx;
	height: 100rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	margin:50rpx 0 0 0rpx;
}

.passwordCard .password{
	width: 600rpx;
	height: 60rpx;
	border-bottom: 2rpx solid gray;
}

.logInCard .register{
	width: 700rpx;
	height: 50rpx;
	display: flex;
	justify-content:center;
	align-items: center;
	margin:20rpx 0 0 0rpx;
}

.register .registerLeft{
	width: 500rpx;
}

.logInCard .logInBtn{
	width: 500rpx;
	height: 100rpx;
	background-color: cadetblue;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 35rpx;
	margin:150rpx 0 0 100rpx;
	border-radius: 20rpx;
	color:white;
	
}

</style>
