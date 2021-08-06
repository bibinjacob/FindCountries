package com.bibin.countries.base.domain.entity

data class ResponseEntity<T>(
    val results:List<T>? = null,
    val message: String? = "",
    val status: String? = "",
    val statusCode: Int? = 0,
    val errors: List<String>? = null
)