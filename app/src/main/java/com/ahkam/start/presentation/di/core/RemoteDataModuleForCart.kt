package com.ahkam.start.presentation.di.core

import com.ahkam.start.data.api.SOService
import com.ahkam.start.data.repository.cart.datasourceimpl.AddToCartDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModuleForCart(private val item_id: Int,
                              private val mobile_id: String,
                              private val price: Double,
                              private val quantity: Int,
                              private val unit: String) {


    @Singleton
    @Provides
    fun provideAddToCartRemoteDataSource(soService: SOService): AddToCartDataSourceImpl {

        return AddToCartDataSourceImpl(soService,item_id,mobile_id,price,quantity,unit)
    }

}