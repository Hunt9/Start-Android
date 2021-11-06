package com.ahkam.start.presentation

import android.annotation.SuppressLint
import android.app.Application
import android.provider.Settings.Secure
import android.util.Log
import com.ahkam.start.presentation.di.Injector
import com.ahkam.start.presentation.di.cart.CartSubComponent
import com.ahkam.start.presentation.di.core.*
import com.ahkam.start.presentation.di.item.ItemSubComponent

//https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default/dynamodb-writer


class App : Application(),Injector {

    private lateinit var appComponent: AppComponent

    private var android_id = ""

    override fun onCreate() {
        super.onCreate()

    }

    override fun createCartSubComponent(): CartSubComponent {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("http://dailyfresh.circlesltd.ml/Api/"))
            .remoteDataModule(RemoteDataModule("aeece1e5ca341c52"))
            .build()
        return appComponent.cartSubComponent().create()
    }

    override fun createItemSubComponent(): ItemSubComponent {
        return appComponent.itemSubComponent().create()
    }

    override fun createPizzaComponent(): ItemSubComponent {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .netModule(NetModule("http://dailyfresh.circlesltd.ml/Api/"))
                .remoteDataModule(RemoteDataModule("Pizzas"))
                .build()
        return appComponent.itemSubComponent().create()
    }

    override fun createSushiComponent(): ItemSubComponent {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .netModule(NetModule("http://dailyfresh.circlesltd.ml/Api/"))
                .remoteDataModule(RemoteDataModule("Sushis"))
                .build()
        return appComponent.itemSubComponent().create()
    }

    override fun createDrinkComponent(): ItemSubComponent {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .netModule(NetModule("http://dailyfresh.circlesltd.ml/Api/"))
                .remoteDataModule(RemoteDataModule("Drinks"))
                .build()
        return appComponent.itemSubComponent().create()
    }





}