package com.a360.worldinhalfminute.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.a360.worldinhalfminute.data.db.Entities.ExternalIPEntity

@Dao
interface ExternalIPDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExternalIpInToDB(externalIPEntty: ExternalIPEntity)

    @Query("SELECT * FROM external_ip_entity")
    fun getExternalIPDataFromDB(): LiveData<ExternalIPEntity>
}