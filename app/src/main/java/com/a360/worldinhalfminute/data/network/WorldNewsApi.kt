package com.a360.worldinhalfminute.data.network

import com.a360.worldinhalfminute.data.network.datamodels.ArticlesDataModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WorldNewsApi {//8dbe4e0919d14caaa504a516d10f7ffd

    @GET("top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<ArticlesDataModel>

    companion object{
        operator fun invoke(): WorldNewsApi {
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WorldNewsApi::class.java)
        }
    }

}