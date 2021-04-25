package com.ulanapp.network.responses

data class AccessTokenResponse(
        val result: Result,
        val accessToken: String
) {

    data class Result(
            val status: Int,
            val message: String,
            val messageDev: String,
            val codeResult: Int,
            val duration: Int,
            val idLog: String
    )
}