package com.ahkam.start.presentation.di.item

import com.ahkam.start.viewpager.screens.DrinksFragment
import com.ahkam.start.viewpager.screens.PizzaFragment
import com.ahkam.start.viewpager.screens.SushiFragment
import dagger.Subcomponent

@ItemScope
@Subcomponent(modules = [ItemModule::class])
interface ItemSubComponent {
    fun inject (pizzaFragment: PizzaFragment)
    fun inject (sushiFragment: SushiFragment)
    fun inject (drinksFragment: DrinksFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():ItemSubComponent
    }
}