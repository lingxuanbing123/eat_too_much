
// 回退版本
// import { createStore } from 'vuex';

// // 定义原有的 state、getters、mutations 和 actions
// const state = {
//   cartItems: [],
//   orderItems: [] // 新增订单数据状态
// };

// const getters = {
//   cartItems: state => state.cartItems,
//   cartItemCount: state => state.cartItems.reduce((count, item) => count + item.quantity, 0),
//   cartTotalPrice: state => state.cartItems.reduce((total, item) => total + item.dCost * item.quantity, 0),
//   orderItems: state => state.orderItems // 新增订单数据getter
// };

// const mutations = {
//   ADD_TO_CART(state, item) {
//     const existingItem = state.cartItems.find(cartItem => cartItem.commodityName === item.commodityName);
//     if (existingItem) {
//       existingItem.quantity += 1;
//     } else {
//       state.cartItems.push({ ...item, quantity: 1 });
//     }
//   },
//   CLEAR_CART(state) {
//     state.cartItems = [];
//   },
//   UPDATE_CART_ITEM_QUANTITY(state, { commodityName, quantity }) {
//     const item = state.cartItems.find(cartItem => cartItem.commodityName === commodityName);
//     if (item) {
//       item.quantity = quantity;
//     }
//   },
//   SET_ORDER_ITEMS(state, items) {
//     state.orderItems = items;
//   },
//   // 其他 mutations...
// };

// const actions = {
//   addToCart({ commit }, item) {
//     commit('ADD_TO_CART', item);
//   },
//   clearCart({ commit }) {
//     commit('CLEAR_CART');
//   },
//   updateCartItemQuantity({ commit }, payload) {
//     commit('UPDATE_CART_ITEM_QUANTITY', payload);
//   },
//   setOrderItems({ commit }, items) {
//     commit('SET_ORDER_ITEMS', items);
//   },
//   // 其他 actions...
// };

// // 导出整合后的 Vuex Store
// export default createStore({
//   state,
//   getters,
//   mutations,
//   actions
// });

// store/index.js
import { createStore } from 'vuex';

const store = createStore({
  state: {
    cart: []
  },
  getters: {
    cartItems: state => state.cart,
    cartItemCount: state => state.cart.reduce((count, item) => count + item.quantity, 0),
    cartTotalPrice: state => state.cart.reduce((total, item) => total + item.quantity * item.dCost, 0)
  },
  mutations: {
    ADD_TO_CART(state, item) {
      const cartItem = state.cart.find(i => i.commodityName === item.commodityName);
      if (cartItem) {
        cartItem.quantity++;
      } else {
        state.cart.push({ ...item, quantity: 1 });
      }
    },
    REMOVE_FROM_CART(state, item) {
      const cartItem = state.cart.find(i => i.commodityName === item.commodityName);
      if (cartItem && cartItem.quantity > 1) {
        cartItem.quantity--;
      } else {
        state.cart = state.cart.filter(i => i.commodityName !== item.commodityName);
      }
    },
    CLEAR_CART(state) {
      state.cart = [];
    }
  },
  actions: {
    addToCart({ commit }, item) {
      commit('ADD_TO_CART', item);
    },
    removeFromCart({ commit }, item) {
      commit('REMOVE_FROM_CART', item);
    },
    clearCart({ commit }) {
      commit('CLEAR_CART');
    }
  }
});

export default store;
