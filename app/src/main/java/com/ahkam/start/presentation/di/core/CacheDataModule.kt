package com.ahkam.start.presentation.di.core

import com.ahkam.start.data.repository.cart.datasource.CartCacheDataSource
import com.ahkam.start.data.repository.cart.datasourceimpl.CartCacheDataSourceImpl
import com.ahkam.start.data.repository.item.datasource.ItemCacheDataSource
import com.ahkam.start.data.repository.item.datasourceimpl.ItemCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideItemCacheDataSource():ItemCacheDataSource{
        return ItemCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideCartCacheDataSource(): CartCacheDataSource {
        return CartCacheDataSourceImpl()
    }
}