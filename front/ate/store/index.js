import { createStore } from 'vuex';
import { createApp } from 'vue'

const store = createStore({
  state: {
    cart: []
  },
  mutations: {
    ADD_TO_CART(state, item) {
      const existingItem = state.cart.find(cartItem => cartItem.commodityName === item.commodityName);
      if (existingItem) {
        existingItem.quantity += 1;
      } else {
        state.cart.push({ ...item, quantity: 1 });
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
    clearCart({ commit }) {
      commit('CLEAR_CART');
    }
  },
  getters: {
    cartItems: state => state.cart,
    cartItemCount: state => state.cart.reduce((count, item) => count + item.quantity, 0),
    cartTotalPrice: state => state.cart.reduce((total, item) => total + item.dCost * item.quantity, 0)
  }
});

export default store;
