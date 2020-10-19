package com.a360.worldinhalfminute.repositories

import androidx.lifecycle.LiveData
import com.a360.worldinhalfminute.data.db.DataBase
import com.a360.worldinhalfminute.data.db.Entities.ExternalIPEntity
import com.a360.worldinhalfminute.data.network.Externalapi
import com.a360.worldinhalfminute.data.network.datamodels.ExternaiIPDataModel
import retrofit2.Response

class ExternalIPRepository (
    private var externalapi: Externalapi,
    private var db: DataBase
){

    suspend fun getExternal_IP_FromAPI() : Response<ExternaiIPDataModel> {
        val externalIP: Response<ExternaiIPDataModel> = externalapi.getExternalIP()
        return externalIP
    }

    suspend fun saveExternalIpDataToDB(exteranlIpData: ExternalIPEntity){
        db.getExternalIPDao().insertExternalIpInToDB(exteranlIpData)
    }

    fun getExternalIpDataFromDB(): LiveData<ExternalIPEntity> {
        return db.getExternalIPDao().getExternalIPDataFromDB()
    }

}