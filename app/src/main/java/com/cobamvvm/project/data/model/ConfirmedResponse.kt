package com.cobamvvm.project.data.model

class ConfirmedResponse : ArrayList<ConfirmedResponseItem>()

data class ConfirmedResponseItem(
    val active: Int,
    val admin2: String,
    val combinedKey: String,
    val confirmed: Int,
    val countryRegion: String,
    val deaths: Int,
    val fips: String,
    val incidentRate: Double,
    val iso2: String,
    val iso3: String,
    val lastUpdate: Long,
    val lat: Double,
    val long: Double,
    val peopleHospitalized: Any,
    val peopleTested: Any,
    val provinceState: String,
    val recovered: Int,
    val uid: Int
)