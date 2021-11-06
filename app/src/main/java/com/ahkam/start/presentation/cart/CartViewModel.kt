package com.ahkam.start.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ahkam.start.domain.usecase.GetCartUseCase
import com.ahkam.start.domain.usecase.UpdateCartUseCase

class CartViewModel(
        private val getCartUseCase: GetCartUseCase,
        private val updateCartUseCase: UpdateCartUseCase
) : ViewModel() {

    fun getCart() = liveData {
        val cart = getCartUseCase.execute()
        emit(cart)
    }

    fun updateCart() = liveData {
        val myUpdatedCart = updateCartUseCase.execute()
        emit(myUpdatedCart)
    }


}