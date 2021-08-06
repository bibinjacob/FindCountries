package com.bibin.countries.base.presentation

import com.bibin.countries.base.domain.entity.ResponseEntity

fun <T> ResponseEntity<T>.responseEntityToResponse(): Response {
    return Response(
        status = this.status,
        statusCode = this.statusCode,
        message = this.message,
        errors = this.errors
    )
}