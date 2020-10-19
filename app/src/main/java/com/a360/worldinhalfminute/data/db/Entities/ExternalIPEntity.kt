package com.a360.worldinhalfminute.data.db.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "external_ip_entity")
data class ExternalIPEntity(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "ip") var ip: String?,
    @ColumnInfo(name = "country") var country: String?,
    @ColumnInfo(name = "cc") var cc: String?
)