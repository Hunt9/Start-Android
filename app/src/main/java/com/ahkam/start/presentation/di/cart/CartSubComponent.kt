package com.ahkam.start.presentation.di.cart

import com.ahkam.start.CardFragment
import dagger.Subcomponent

@CartScope
@Subcomponent(modules = [CartModule::class])
interface CartSubComponent {
//    fun inject (cartFragment: CartFragment)
    fun inject (cardFragment: CardFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():CartSubComponent
    }
}