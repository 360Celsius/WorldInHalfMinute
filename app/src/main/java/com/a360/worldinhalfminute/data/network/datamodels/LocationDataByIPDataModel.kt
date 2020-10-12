package com.a360.worldinhalfminute.data.network.datamodels

data class LocationDataByIPDataModel (

    var ip: String?,
    var country_code: String?,
    var country_name: String?,
    var region_code: String?,
    var region_name: String?,
    var city: String?,
    var zip_code: String?,
    var time_zone: String?,
    var latitude: Double?,
    var longitude: Double?,
    var metro_code: Double?
)