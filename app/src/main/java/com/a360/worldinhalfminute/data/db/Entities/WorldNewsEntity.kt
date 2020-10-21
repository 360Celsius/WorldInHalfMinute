package com.a360.worldinhalfminute.data.db.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "world_news")
data class WorldNewsEntity (

    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "source") var source: String?,
    @ColumnInfo(name = "author") var author: String?,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "url") var url: String?,
    @ColumnInfo(name = "urlToImage") var urlToImage: String?,
    @ColumnInfo(name = "publishedAt") var publishedAt: String?,
    @ColumnInfo(name = "content") var content: String?

)


