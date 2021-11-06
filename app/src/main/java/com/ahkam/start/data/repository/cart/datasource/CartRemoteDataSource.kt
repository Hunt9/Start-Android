package com.ahkam.start.data.repository.cart.datasource

import com.ahkam.start.data.model.Cart
import retrofit2.Response

interface CartRemoteDataSource {

    suspend fun getCart(): Response<Cart>
}