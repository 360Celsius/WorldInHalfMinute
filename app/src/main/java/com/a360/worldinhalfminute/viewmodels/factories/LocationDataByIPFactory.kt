package com.a360.worldinhalfminute.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a360.worldinhalfminute.repositories.ExternalIPRepository
import com.a360.worldinhalfminute.repositories.LocationDataByIPRepository
import com.a360.worldinhalfminute.viewmodels.ExternaIPViewModel
import com.a360.worldinhalfminute.viewmodels.LocationDataByIPViewModel

class LocationDataByIPFactory(
    private val locationDataByIPRepository: LocationDataByIPRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LocationDataByIPViewModel(locationDataByIPRepository) as T
    }
}