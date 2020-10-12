package com.a360.worldinhalfminute.data.network

import com.a360.worldinhalfminute.data.network.datamodels.ArticlesDataModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface WorldNewsApi {

    @GET("top-headlines?country={countryId}&apiKey=8dbe4e0919d14caaa504a516d10f7ffd")
    suspend fun getHeadlines(@Path("countryId") countryId: String): Response<ArticlesDataModel>

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