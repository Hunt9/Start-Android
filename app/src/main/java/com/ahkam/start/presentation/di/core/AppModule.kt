package com.ahkam.start.presentation.di.core

import android.content.Context
import com.ahkam.start.presentation.di.cart.CartSubComponent
import com.ahkam.start.presentation.di.item.ItemSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [CartSubComponent::class,ItemSubComponent::class])
class AppModule (private val context:Context){


    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }


}