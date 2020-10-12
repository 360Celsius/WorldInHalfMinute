package com.a360.worldinhalfminute.data.network

import com.a360.worldinhalfminute.data.network.datamodels.ExternaiIPDataModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Externalapi {

    @GET("./")
    suspend fun getExternalIP(): Response<ExternaiIPDataModel>

    companion object{
        operator fun invoke(): Externalapi {
            return Retrofit.Builder()
                .baseUrl("https://api.myip.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Externalapi::class.java)
        }
    }

}