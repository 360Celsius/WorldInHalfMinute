package com.a360.worldinhalfminute.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.a360.worldinhalfminute.data.db.Entities.ExternalIPEntity
import com.a360.worldinhalfminute.repositories.ExternalIPRepository
import com.a360.worldinhalfminute.utils.Coroutines

class ExternaIPViewModel (
    private val externalIPRepository: ExternalIPRepository
): ViewModel() {

    fun getexternalIP(){
        Coroutines.backGround {
            var externalIP = externalIPRepository.getExternal_IP_FromAPI()

            val externalIpData: ExternalIPEntity = ExternalIPEntity(0, externalIP.body()?.ip, externalIP.body()?.country, externalIP.body()?.cc)

            externalIPRepository.saveExternalIpDataToDB(externalIpData)

            Log.e("test", externalIP.body()?.country)

        }
    }

    fun getExternalIpDataFromDB(): LiveData<ExternalIPEntity>{
        val externalIpData: LiveData<ExternalIPEntity> = externalIPRepository.getExternalIpDataFromDB()
        return externalIpData
    }
}