package com.a360.worldinhalfminute.repositories

import com.a360.worldinhalfminute.data.network.WorldNewsApi
import com.a360.worldinhalfminute.data.network.datamodels.ArticlesDataModel
import retrofit2.Response

class WorldNewsRepository (
    private var worldNewsApi: WorldNewsApi
) {

    suspend fun getWorldNewsFromApi(countryId: String): Response<ArticlesDataModel>{
        val worldNews: Response<ArticlesDataModel> = worldNewsApi.getHeadlines(countryId)
        return worldNews
    }
}