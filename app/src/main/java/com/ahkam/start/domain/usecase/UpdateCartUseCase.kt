package com.ahkam.start.domain.usecase

import com.ahkam.start.data.model.AddtoCart
import com.ahkam.start.domain.repository.CartRepository

class UpdateCartUseCase(
    private val cartRepository: CartRepository,
    private val item_id: Int,
    private val mobile_id: String,
    private val price: Double,
    private val quantity: Int,
    private val unit: String
) {
    suspend fun execute(): AddtoCart? = cartRepository.updateCart(
        item_id,
        mobile_id,
        price,
        quantity,
        unit
    )
}