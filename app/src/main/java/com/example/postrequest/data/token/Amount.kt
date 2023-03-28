package com.example.postrequest.data.token
@kotlinx.serialization.Serializable
data class Amount(
    val currency: String,
    val value: String
)