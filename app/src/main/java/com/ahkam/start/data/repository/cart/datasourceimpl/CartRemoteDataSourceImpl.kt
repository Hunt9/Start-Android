package com.ahkam.start.data.repository.cart.datasourceimpl

import com.ahkam.start.data.api.SOService
import com.ahkam.start.data.model.AddtoCart
import com.ahkam.start.data.model.Cart
import com.ahkam.start.data.model.ItemsList
import com.ahkam.start.data.repository.cart.datasource.AddToCartDataSource
import com.ahkam.start.data.repository.cart.datasource.CartRemoteDataSource
import com.ahkam.start.data.repository.item.datasource.ItemRemoteDataSource
import retrofit2.Response

class CartRemoteDataSourceImpl(private val soService: SOService, private val mobile_id:String):
CartRemoteDataSource {
    override suspend fun getCart(): Response<Cart> = soService.getCartItemList(mobile_id)
}
