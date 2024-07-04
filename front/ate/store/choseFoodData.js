import { createStore } from 'vuex';

const store = createStore({
  state: {
    userDetails: {
      1: '', // Account
      2: '', // Password
      3: '', // Introduction
      4: ''  // Delivery Address
    },
    cartItems: [], // Items in the shopping cart
    orderItems: [], // Items in the order form
    commodities: [], // Items in the choseFood page
    deliveryMerchant: {
      merchantName: "",
      merchantGrade: 0,
      deliveryTime: 0,
      salesNum: 0,
      noticeDescribe: "",
      merchantImage: ""
    },
    backgroundImage: "" // Background image in the choseFood page
  },
  getters: {
    getUserDetail: state => id => {
      return state.userDetails[id];
    },
    cartItems: state => state.cartItems,
    cartItemCount: state => state.cartItems.reduce((count, item) => count + item.quantity, 0),
    cartTotalPrice: state => state.cartItems.reduce((total, item) => total + item.quantity * item.dCost, 0),
    orderItems: state => state.orderItems,
    getCommodities: state => state.commodities,
    getDeliveryMerchant: state => state.deliveryMerchant,
    getBackgroundImage: state => state.backgroundImage
  },
  mutations: {
    setUserDetail(state, { id, value }) {
      state.userDetails[id] = value;
    },
    ADD_TO_CART(state, item) {
      const cartItem = state.cartItems.find(i => i.commodityName === item.commodityName);
      if (cartItem) {
        cartItem.quantity++;
      } else {
        state.cartItems.push({ ...item, quantity: 1 });
      }
      console.log('ADD_TO_CART:', state.cartItems);
    },
    REMOVE_FROM_CART(state, item) {
      const cartItem = state.cartItems.find(i => i.commodityName === item.commodityName);
      if (cartItem && cartItem.quantity > 1) {
        cartItem.quantity--;
      } else {
        state.cartItems = state.cartItems.filter(i => i.commodityName !== item.commodityName);
      }
      console.log('REMOVE_FROM_CART:', state.cartItems);
    },
    CLEAR_CART(state) {
      state.cartItems = [];
      console.log('CLEAR_CART:', state.cartItems);
    },
    SET_ORDER_ITEMS(state, items) {
      state.orderItems = items;
      console.log('SET_ORDER_ITEMS:', state.orderItems);
    },
    setCommodities(state, commodities) {
      state.commodities = commodities;
    },
    setDeliveryMerchant(state, deliveryMerchant) {
      state.deliveryMerchant = deliveryMerchant;
    },
    setBackgroundImage(state, backgroundImage) {
      state.backgroundImage = backgroundImage;
    }
  },
  actions: {
    updateUserDetail({ commit }, payload) {
      commit('setUserDetail', payload);
    },
    addToCart({ commit }, item) {
      commit('ADD_TO_CART', item);
    },
    removeFromCart({ commit }, item) {
      commit('REMOVE_FROM_CART', item);
    },
    clearCart({ commit }) {
      commit('CLEAR_CART');
    },
    setOrderItems({ commit }, items) {
      commit('SET_ORDER_ITEMS', items);
    },
    updateCommodities({ commit }, commodities) {
      commit('setCommodities', commodities);
    },
    updateDeliveryMerchant({ commit }, deliveryMerchant) {
      commit('setDeliveryMerchant', deliveryMerchant);
    },
    updateBackgroundImage({ commit }, backgroundImage) {
      commit('setBackgroundImage', backgroundImage);
    }
  }
});

export default store;
