package com.ahkam.start.data.repository.item

import android.util.Log
import com.ahkam.start.data.model.Item
import com.ahkam.start.data.model.ItemsList
import com.ahkam.start.data.repository.item.datasource.ItemCacheDataSource
import com.ahkam.start.data.repository.item.datasource.ItemRemoteDataSource
import com.ahkam.start.domain.repository.ItemRepository
import retrofit2.Response
import java.lang.Exception

class ItemRepositoryImpl (
    private val itemRemoteDataSource: ItemRemoteDataSource,
    private val itemCacheDataSource: ItemCacheDataSource
): ItemRepository {
    override suspend fun getItems(): List<Item> {
        return getItemsFromCache()
    }

    suspend fun getItemsFromAPI():List<Item>
    {
        lateinit var itemsList: List<Item>

        itemsList = emptyList()

        try{
            val response : Response<ItemsList> = itemRemoteDataSource.getItems()
            val body:ItemsList = response.body()!!

            if(body.statusMessage.equals("Successfull."))
            {
                itemsList = body.items
            }

        }catch (exception:Exception)
        {
            Log.i("MyTag----",exception.message.toString())
        }

        return itemsList
    }


    suspend fun getItemsFromCache():List<Item>
    {
        lateinit var itemsList: List<Item>
        try{
            itemsList = itemCacheDataSource.getItemsFromCache()

        }catch (exception:Exception)
        {
            Log.i("MyTag",exception.message.toString())
        }

        if(itemsList.size>0)
        {
            return itemsList
        }else{
            itemsList = getItemsFromAPI()
            itemCacheDataSource.saveItemsFromCache(itemsList)
        }

        return itemsList

    }

}