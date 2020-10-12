package com.a360.worldinhalfminute.repositories

import com.a360.worldinhalfminute.data.network.Externalapi
import com.a360.worldinhalfminute.data.network.datamodels.ExternaiIPDataModel
import retrofit2.Response

class ExternalIPRepository (
    private var externalapi: Externalapi
){

    suspend fun getExternal_IP_FromAPI() : Response<ExternaiIPDataModel> {
        val externalIP: Response<ExternaiIPDataModel> = externalapi.getExternalIP()
        return externalIP
    }

}