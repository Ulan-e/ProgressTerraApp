package com.ulanapp.network.responses

import java.util.*

data class BonusInfoResponse(
        val resultOperation: ResultOperation,
        val data: Data
) {

    data class ResultOperation(
            val status: Int,
            val message: String,
            val messageDev: String,
            val codeResult: Int,
            val duration: Int,
            val idLog: String
    )

    data class Data(
            val typeBonusName: String,
            val currentQuantity: Int,
            val forBurningQuantity: Int,
            val dateBurning: Date
    )
}