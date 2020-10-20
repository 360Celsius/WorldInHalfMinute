package com.a360.worldinhalfminute

import android.app.Application
import com.a360.worldinhalfminute.data.db.DataBase
import com.a360.worldinhalfminute.data.network.Externalapi
import com.a360.worldinhalfminute.data.network.WorldNewsApi
import com.a360.worldinhalfminute.repositories.ExternalIPRepository
import com.a360.worldinhalfminute.repositories.WorldNewsRepository
import com.a360.worldinhalfminute.viewmodels.factories.ExternaIPViewModelFactory
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
        bind() from singleton { WorldNewsApi() }

        bind() from singleton { DataBase(instance()) }


        bind() from singleton { ExternalIPRepository(instance(),instance()) }
        bind() from singleton { WorldNewsRepository(instance(),instance()) }

        bind() from provider { ExternaIPViewModelFactory(instance()) }
        bind() from provider { WorldNewsFactory(instance()) }


    }
}