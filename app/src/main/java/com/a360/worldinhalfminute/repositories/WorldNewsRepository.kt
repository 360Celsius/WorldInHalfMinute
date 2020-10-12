package com.a360.worldinhalfminute.repositories

import com.a360.worldinhalfminute.data.network.datamodels.ArticlesDataModel
import retrofit2.Response

class WorldNewsRepository (
    private var worldNewsApiRepositories: WorldNewsRepository
) {

    suspend fun getWorldNewsFromApi(countryId: String): Response<ArticlesDataModel>{
        val worldNews: Response<ArticlesDataModel> = worldNewsApiRepositories.getWorldNewsFromApi(countryId = countryId)
        return worldNews
    }
}