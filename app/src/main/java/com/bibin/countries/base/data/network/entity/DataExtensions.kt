package com.bibin.countries.base.data.network.entity

import com.bibin.countries.base.domain.entity.ResponseEntity
import com.bibin.countries.countrylistmanagement.data.entity.CountryListData
import com.bibin.countries.countrylistmanagement.domain.entity.CountryListEntity


fun List<CountryListData>.mapCountryListDataToCountryListEntity(): ResponseEntity<CountryListEntity> {
    return ResponseEntity(
        results = this.mapToResponseEntity()
    )
}

fun List<CountryListData>.mapToResponseEntity(): List<CountryListEntity> {
    val countryList: MutableList<CountryListEntity> = mutableListOf()

    this.map {
        countryList.add(it.mapToEntityData())
    }
    return countryList
}

private fun CountryListData.mapToEntityData(): CountryListEntity {
    return CountryListEntity(
        name = this.name,
        capital = this.capital,
        region = this.region,
        flag = this.flag
    )
}

