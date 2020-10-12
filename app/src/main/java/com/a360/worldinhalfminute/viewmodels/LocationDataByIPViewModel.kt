package com.a360.worldinhalfminute.viewmodels

import androidx.lifecycle.ViewModel
import com.a360.worldinhalfminute.repositories.ExternalIPRepository
import com.a360.worldinhalfminute.repositories.LocationDataByIPRepository

class LocationDataByIPViewModel (
    private val locationDataByIPRepository: LocationDataByIPRepository
): ViewModel() {
}