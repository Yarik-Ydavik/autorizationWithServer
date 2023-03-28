package com.example.postrequest.data.recieve
@kotlinx.serialization.Serializable
data class Recipient(
    val account_id: String,
    val gateway_id: String
)