package com.ahkam.start.data.repository.cart.datasource

import com.ahkam.start.data.model.Cart
import com.ahkam.start.data.model.Item

interface CartCacheDataSource {

    suspend fun getCartFromCache():Cart
    suspend fun saveCartFromCache(cart: Cart)
}