package com.a360.worldinhalfminute.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.a360.worldinhalfminute.data.db.Entities.ExternalIPEntity
import com.a360.worldinhalfminute.data.db.Entities.WorldNewsEntity

@Dao
interface WorldNewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorldNewsToDB(worldNewsEntity: WorldNewsEntity)

    @Query("SELECT * FROM world_news")
    fun getWorldNewsFromDB(): LiveData<List<WorldNewsEntity>>
}