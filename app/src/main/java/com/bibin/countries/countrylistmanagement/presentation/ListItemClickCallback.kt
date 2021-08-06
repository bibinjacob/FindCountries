package com.bibin.countries.countrylistmanagement.presentation

import com.bibin.countries.countrylistmanagement.domain.entity.CountryListEntity

interface ListItemClickCallback {

    fun onItemClick(country: CountryListEntity)
}