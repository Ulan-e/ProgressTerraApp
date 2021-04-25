package com.ulanapp.network.responses

data class RequestBody(
        val idClient: String,
        val accessToken: String,
        val paramName: String,
        val paramValue: String,
        val latitude: Int,
        val longitude: Int,
        val sourceQuery: Int
)