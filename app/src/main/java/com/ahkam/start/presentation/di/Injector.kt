package com.ahkam.start.presentation.di

import com.ahkam.start.presentation.di.cart.CartSubComponent
import com.ahkam.start.presentation.di.item.ItemSubComponent

interface Injector {
    fun createCartSubComponent():CartSubComponent
    fun createItemSubComponent(): ItemSubComponent
    fun createPizzaComponent(): ItemSubComponent
    fun createSushiComponent(): ItemSubComponent
    fun createDrinkComponent(): ItemSubComponent




}