package com.a360.worldinhalfminute.viewmodels

import androidx.lifecycle.ViewModel
import com.a360.worldinhalfminute.repositories.WorldNewsRepository

class WorldNewsViewModel (
    private val worldNewsRepository: WorldNewsRepository
): ViewModel() {
}