package com.a360.worldinhalfminute.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.a360.worldinhalfminute.repositories.WorldNewsRepository
import com.a360.worldinhalfminute.utils.Coroutines

class WorldNewsViewModel (
    private val worldNewsRepository: WorldNewsRepository
): ViewModel() {

    fun getWorldNews(countryId: String){
        Coroutines.backGround {
            var worldNews = worldNewsRepository.getWorldNewsFromApi(countryId)

            Log.e("test", worldNews.body()?.articles?.get(0)?.title)
        }
    }

}