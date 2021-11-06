package com.ahkam.start.presentation.di.core

import com.ahkam.start.presentation.di.cart.CartSubComponent
import com.ahkam.start.presentation.di.item.ItemSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RemoteDataModuleForCart::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun cartSubComponent():CartSubComponent.Factory
    fun itemSubComponent():ItemSubComponent.Factory

}