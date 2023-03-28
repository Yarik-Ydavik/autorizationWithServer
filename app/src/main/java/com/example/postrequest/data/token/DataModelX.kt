package com.example.postrequest.data.token

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataModelX(
    val amount: Amount,
    val auth: Auth,
    val description: String,
    @SerialName("idempotencekey")
    val idempotencekey: String,
    @SerialName("payment_token")
    val payment_token: String
)