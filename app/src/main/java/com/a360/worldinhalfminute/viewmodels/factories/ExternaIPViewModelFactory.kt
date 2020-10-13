package com.a360.worldinhalfminute.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a360.worldinhalfminute.repositories.ExternalIPRepository
import com.a360.worldinhalfminute.viewmodels.ExternaIPViewModel

class ExternaIPViewModelFactory(
    private val externalIPRepository: ExternalIPRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ExternaIPViewModel(externalIPRepository) as T
    }
}