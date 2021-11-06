package com.ahkam.start.data.repository.cart.datasource

import com.ahkam.start.data.model.AddtoCart
import retrofit2.Response

interface AddToCartDataSource {
    suspend fun updateCart(): Response<AddtoCart>
}