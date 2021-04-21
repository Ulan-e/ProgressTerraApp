package com.ulanapp.network.responses

data class BonusInfoResponse(
    var resultOperation: ResultOperation? = null,
    var data: Data? = null
)

data class ResultOperation(
    var status: Int? = null,
    var message: String? = null,
    var messageDev: String? = null,
    var codeResult: Int? = null,
    var duration: Int? = null,
    var idLog: String? = null
)

data class Data(
    var typeBonusName: String? = null,
    var currentQuantity: Int? = null,
    var forBurningQuantity: Int? = null,
    var dateBurning: String? = null
)