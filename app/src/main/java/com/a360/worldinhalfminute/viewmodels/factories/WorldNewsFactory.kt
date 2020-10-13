package com.a360.worldinhalfminute.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a360.worldinhalfminute.repositories.ExternalIPRepository
import com.a360.worldinhalfminute.repositories.LocationDataByIPRepository
import com.a360.worldinhalfminute.repositories.WorldNewsRepository
import com.a360.worldinhalfminute.viewmodels.ExternaIPViewModel
import com.a360.worldinhalfminute.viewmodels.LocationDataByIPViewModel
import com.a360.worldinhalfminute.viewmodels.WorldNewsViewModel

class WorldNewsFactory(
    private val worldNewsRepository: WorldNewsRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorldNewsViewModel(worldNewsRepository) as T
    }
}