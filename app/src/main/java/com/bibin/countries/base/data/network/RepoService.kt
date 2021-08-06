package com.bibin.countries.base.data.network

import com.bibin.countries.countrylistmanagement.data.entity.CountryListData
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Retrofit class for apis
 * */
interface RepoService {

    @GET("rest/v2/all")
    fun getCountryList(): Single<List<CountryListData>>
}