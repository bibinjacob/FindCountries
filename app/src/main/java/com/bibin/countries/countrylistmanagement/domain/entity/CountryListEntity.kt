package com.bibin.countries.countrylistmanagement.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryListEntity(
    val name: String? = "",
    val flag: String? = "",
    val capital: String? = "",
    val region: String? = ""
) : Parcelable
