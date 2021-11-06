package com.ahkam.start.data.repository.cart.datasourceimpl

import com.ahkam.start.data.api.SOService
import com.ahkam.start.data.model.AddtoCart
import com.ahkam.start.data.repository.cart.datasource.AddToCartDataSource
import retrofit2.Response

class AddToCartDataSourceImpl(
    private val soService: SOService,
    private val item_id: Int,
    private val mobile_id: String,
    private val price: Double,
    private val quantity: Int,
    private val unit: String
) :
    AddToCartDataSource {
    override suspend fun updateCart(): Response<AddtoCart> = soService.updateCart(item_id, mobile_id, price, quantity, unit)
}