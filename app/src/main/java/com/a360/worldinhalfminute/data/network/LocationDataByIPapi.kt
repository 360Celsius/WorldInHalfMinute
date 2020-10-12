package com.a360.worldinhalfminute.data.network

import com.a360.worldinhalfminute.data.network.datamodels.LocationDataByIPDataModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationDataByIPapi {

    @GET("json/{ip}")
    suspend fun getLocationByIP(@Path ("ip") ip: String): Response<LocationDataByIPDataModel>

    companion object{
        operator fun invoke(): LocationDataByIPapi {
            return Retrofit.Builder()
                .baseUrl("https://freegeoip.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LocationDataByIPapi::class.java)
        }
    }

}