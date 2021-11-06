package com.ahkam.start.data.repository.item.datasourceimpl

import com.ahkam.start.data.api.SOService
import com.ahkam.start.data.model.ItemsList
import com.ahkam.start.data.repository.item.datasource.ItemRemoteDataSource
import retrofit2.Response

class ItemRemoteDataSourceImpl(private val soService: SOService,private val category:String):
    ItemRemoteDataSource {
    override suspend fun getItems(): Response<ItemsList> = soService.getItemList(category)

}