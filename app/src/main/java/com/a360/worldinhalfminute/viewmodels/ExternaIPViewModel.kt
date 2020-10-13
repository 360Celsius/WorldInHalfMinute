package com.a360.worldinhalfminute.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.a360.worldinhalfminute.repositories.ExternalIPRepository
import com.a360.worldinhalfminute.utils.Coroutines

class ExternaIPViewModel (
    private val externalIPRepository: ExternalIPRepository
): ViewModel() {

    fun getexternalIP(){
        Coroutines.backGround {
            var externalIP = externalIPRepository.getExternal_IP_FromAPI()

            Log.e("test", externalIP.body()?.country)

        }
    }
}