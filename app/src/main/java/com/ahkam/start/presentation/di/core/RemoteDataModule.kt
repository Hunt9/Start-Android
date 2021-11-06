package com.ahkam.start.presentation.di.core

import com.ahkam.start.data.api.SOService
import com.ahkam.start.data.repository.cart.datasource.CartRemoteDataSource
import com.ahkam.start.data.repository.cart.datasourceimpl.AddToCartDataSourceImpl
import com.ahkam.start.data.repository.cart.datasourceimpl.CartRemoteDataSourceImpl
import com.ahkam.start.data.repository.item.datasource.ItemRemoteDataSource
import com.ahkam.start.data.repository.item.datasourceimpl.ItemRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (private val param : String){

    @Singleton
    @Provides
    fun provideItemRemoteDataSource(soService: SOService) : ItemRemoteDataSource {

        return ItemRemoteDataSourceImpl(soService,param)
    }

    @Singleton
    @Provides
    fun provideCartRemoteDataSource(soService: SOService) : CartRemoteDataSource {

        return CartRemoteDataSourceImpl(soService,param)
    }

}