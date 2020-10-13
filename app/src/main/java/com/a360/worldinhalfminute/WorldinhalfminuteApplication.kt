package com.a360.worldinhalfminute

import android.app.Application
import com.a360.worldinhalfminute.data.network.Externalapi
import com.a360.worldinhalfminute.data.network.LocationDataByIPapi
import com.a360.worldinhalfminute.data.network.WorldNewsApi
import com.a360.worldinhalfminute.repositories.ExternalIPRepository
import com.a360.worldinhalfminute.repositories.LocationDataByIPRepository
import com.a360.worldinhalfminute.repositories.WorldNewsRepository
import com.a360.worldinhalfminute.viewmodels.factories.ExternaIPViewModelFactory
import com.a360.worldinhalfminute.viewmodels.factories.LocationDataByIPFactory
import com.a360.worldinhalfminute.viewmodels.factories.WorldNewsFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class WorldinhalfminuteApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidCoreModule(this@WorldinhalfminuteApplication))

        bind() from singleton { Externalapi() }
        bind() from singleton { LocationDataByIPapi() }
        bind() from singleton { WorldNewsApi() }

        bind() from singleton { ExternalIPRepository(instance()) }
        bind() from singleton { LocationDataByIPRepository(instance()) }
        bind() from singleton { WorldNewsRepository(instance()) }

        bind() from provider { ExternaIPViewModelFactory(instance()) }
        bind() from provider { LocationDataByIPFactory(instance()) }
        bind() from provider { WorldNewsFactory(instance()) }


    }
}