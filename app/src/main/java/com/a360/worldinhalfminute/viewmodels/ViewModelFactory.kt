package com.a360.worldinhalfminute.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a360.worldinhalfminute.repositories.ExternalIPRepository
import com.a360.worldinhalfminute.repositories.LocationDataByIPRepository
import com.a360.worldinhalfminute.repositories.WorldNewsRepository

class ViewModelFactory(
    private val externalIPRepository: ExternalIPRepository,
    private val locationDataByIPRepository: LocationDataByIPRepository,
    private val worldNewsRepository: WorldNewsRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ExternaIPViewModel::class.java)) {
            return ExternaIPViewModel(externalIPRepository) as T
        }else if(modelClass.isAssignableFrom(LocationDataByIPViewModel::class.java)){
            return LocationDataByIPViewModel(locationDataByIPRepository) as T
        }else{
            return WorldNewsViewModel(worldNewsRepository) as T
        }
    }
}