package com.ahkam.start.data.repository.cart.datasourceimpl

import com.ahkam.start.data.model.Cart
import com.ahkam.start.data.repository.cart.datasource.CartCacheDataSource

class CartCacheDataSourceImpl : CartCacheDataSource {

    private lateinit var cart:Cart

    override suspend fun getCartFromCache(): Cart {
        return cart
    }

    override suspend fun saveCartFromCache(cart: Cart) {
        this.cart = cart
    }
}