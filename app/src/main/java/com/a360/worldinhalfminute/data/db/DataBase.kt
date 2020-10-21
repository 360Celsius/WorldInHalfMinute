package com.a360.worldinhalfminute.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.a360.worldinhalfminute.data.db.Entities.ExternalIPEntity
import com.a360.worldinhalfminute.data.db.Entities.WorldNewsEntity

@Database(
    entities = [ExternalIPEntity::class, WorldNewsEntity::class],
    version = 1
)

abstract class DataBase: RoomDatabase() {


    abstract fun getExternalIPDao(): ExternalIPDao
    abstract fun getWorldNewsDao(): WorldNewsDao

    companion object{

        @Volatile
        private var instance: DataBase? = null
        private val LOCK = Any() //Make sure to have one instance of the DB

        operator fun invoke (context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDataBase(context).also {
                instance = it
            }
        }

        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DataBase::class.java,
                "DataBase.db")
                .build()
    }

}