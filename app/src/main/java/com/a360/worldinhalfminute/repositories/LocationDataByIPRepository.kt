package com.a360.worldinhalfminute.repositories

import com.a360.worldinhalfminute.data.network.LocationDataByIPapi
import com.a360.worldinhalfminute.data.network.datamodels.LocationDataByIPDataModel
import retrofit2.Response

class LocationDataByIPRepository(
    private var locationDataByIPapi: LocationDataByIPapi
) {

    suspend fun getLocationDataBy_IP_FromApi(localIP:String):Response<LocationDataByIPDataModel>{
        val locationDataByIP: Response<LocationDataByIPDataModel> = locationDataByIPapi.getLocationByIP(localIP)
        return locationDataByIP
    }
}