package com.bibin.countries.countrylistmanagement.data

import com.bibin.countries.base.data.network.RepoService
import com.bibin.countries.base.data.network.entity.mapCountryListDataToCountryListEntity
import com.bibin.countries.base.domain.entity.ResponseEntity
import com.bibin.countries.countrylistmanagement.domain.entity.CountryListEntity
import io.reactivex.Single
import javax.inject.Inject

class CountryListManageRepository @Inject constructor(private var repoService: RepoService) {

    fun getCountryList(): Single<ResponseEntity<CountryListEntity>> {

        return repoService.getCountryList().map {
            it.mapCountryListDataToCountryListEntity()
        }
    }
}