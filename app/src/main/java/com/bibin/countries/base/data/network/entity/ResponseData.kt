package com.bibin.countries.base.data.network.entity

data class ResponseData<T>(
    var results: T? = null,
    val message: String? = "",
    val status: String? = "",
    val statusCode: Int? = 0,
    val errors: List<String>?=null
)