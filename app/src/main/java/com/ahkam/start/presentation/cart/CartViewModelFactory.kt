package com.ahkam.start.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahkam.start.domain.usecase.GetCartUseCase
import com.ahkam.start.domain.usecase.UpdateCartUseCase

class CartViewModelFactory (
    private val getCartUseCase: GetCartUseCase,
    private val updateCartUseCase: UpdateCartUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(getCartUseCase,updateCartUseCase) as T
    }
}