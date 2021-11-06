package com.ahkam.start.presentation.di.core

import com.ahkam.start.data.repository.cart.CartRepositoryImpl
import com.ahkam.start.data.repository.cart.datasource.AddToCartDataSource
import com.ahkam.start.data.repository.cart.datasource.CartCacheDataSource
import com.ahkam.start.data.repository.cart.datasource.CartRemoteDataSource
import com.ahkam.start.data.repository.item.ItemRepositoryImpl
import com.ahkam.start.data.repository.item.datasource.ItemCacheDataSource
import com.ahkam.start.data.repository.item.datasource.ItemRemoteDataSource
import com.ahkam.start.domain.repository.CartRepository
import com.ahkam.start.domain.repository.ItemRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideItemRepository(
        itemRemoteDataSource: ItemRemoteDataSource,
        itemCacheDataSource: ItemCacheDataSource
    ):ItemRepository
    {
        return ItemRepositoryImpl(itemRemoteDataSource,itemCacheDataSource)
    }

    @Provides
    @Singleton
    fun providecartRepository(
        cartRemoteDataSource: CartRemoteDataSource,
        cartCacheDataSource: CartCacheDataSource,
        addToCartDataSource: AddToCartDataSource
    ): CartRepository
    {
        return CartRepositoryImpl(cartRemoteDataSource,cartCacheDataSource,addToCartDataSource)
    }



}