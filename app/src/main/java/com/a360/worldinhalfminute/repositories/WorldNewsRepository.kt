package com.a360.worldinhalfminute.repositories

import com.a360.worldinhalfminute.data.db.DataBase
import com.a360.worldinhalfminute.data.network.WorldNewsApi
import com.a360.worldinhalfminute.data.network.datamodels.ArticlesDataModel
import retrofit2.Response

class WorldNewsRepository (
    private var worldNewsApi: WorldNewsApi,
    private var db: DataBase
) {

    val newsApiKey: String = "8dbe4e0919d14caaa504a516d10f7ffd"

    suspend fun getWorldNewsFromApi(countryId: String): Response<ArticlesDataModel>{
        val worldNews: Response<ArticlesDataModel> = worldNewsApi.getHeadlines(countryId,newsApiKey)
        return worldNews
    }
}