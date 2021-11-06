package com.ahkam.start.domain.usecase

import com.ahkam.start.data.model.Cart
import com.ahkam.start.domain.repository.CartRepository

class GetCartUseCase (private val cartRepository: CartRepository) {
    suspend fun execute(): Cart?=cartRepository.getCart()
}