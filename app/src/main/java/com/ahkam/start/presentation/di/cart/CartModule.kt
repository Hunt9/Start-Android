package com.ahkam.start.presentation.di.cart

import com.ahkam.start.domain.usecase.GetCartUseCase
import com.ahkam.start.domain.usecase.UpdateCartUseCase
import com.ahkam.start.presentation.cart.CartViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CartModule {

    @CartScope
    @Provides
    fun provideCartViewModelFactory(
        getCartUseCase: GetCartUseCase,
        updateCartUseCase: UpdateCartUseCase
    ): CartViewModelFactory{

        return CartViewModelFactory(getCartUseCase, updateCartUseCase)
    }

}