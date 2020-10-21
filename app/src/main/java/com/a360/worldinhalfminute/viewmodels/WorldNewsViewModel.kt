package com.a360.worldinhalfminute.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.a360.worldinhalfminute.data.db.Entities.WorldNewsEntity
import com.a360.worldinhalfminute.repositories.WorldNewsRepository
import com.a360.worldinhalfminute.utils.Coroutines

class WorldNewsViewModel (
    private val worldNewsRepository: WorldNewsRepository
): ViewModel() {

    fun getWorldNews(countryId: String){
        Coroutines.backGround {

            var worldNews = worldNewsRepository.getWorldNewsFromApi(countryId)

            val worldNewsArraySize: Int? = worldNews.body()?.articles?.size?.minus(1)

            for (i in 0..(worldNewsArraySize?:0)){

                val worldNewsEntity: WorldNewsEntity = WorldNewsEntity(
                    i.plus(1),
                    worldNews.body()?.articles?.get(i)?.source?.name,
                    worldNews.body()?.articles?.get(i)?.author,
                    worldNews.body()?.articles?.get(i)?.title,
                    worldNews.body()?.articles?.get(i)?.description,
                    worldNews.body()?.articles?.get(i)?.url,
                    worldNews.body()?.articles?.get(i)?.urlToImage,
                    worldNews.body()?.articles?.get(i)?.publishedAt,
                    worldNews.body()?.articles?.get(i)?.content
                )

                worldNewsRepository.saveWorldNewsToDB(worldNewsEntity)

            }


            Log.e("test", worldNews.body()?.articles?.get(0)?.title)
        }
    }


    fun getWorldNewsFromDB(): LiveData<WorldNewsEntity> {
        val worldNewsData: LiveData<WorldNewsEntity> = worldNewsRepository.getWorldNewsFromDB()
        return worldNewsData
    }

}