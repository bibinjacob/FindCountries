package com.bibin.countries.countrylistmanagement.domain

import com.bibin.countries.base.domain.entity.ResponseEntity
import com.bibin.countries.countrylistmanagement.data.CountryListManageRepository
import com.bibin.countries.countrylistmanagement.domain.entity.CountryListEntity
import io.reactivex.Single
import javax.inject.Inject

class CountryListManageUseCase @Inject constructor(private val countryListManageRepository: CountryListManageRepository) {

    fun getCountryList(): Single<ResponseEntity<CountryListEntity>> {
        return countryListManageRepository.getCountryList()
    }
}