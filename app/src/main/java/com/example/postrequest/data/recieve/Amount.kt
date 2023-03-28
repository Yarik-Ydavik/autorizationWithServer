package com.example.postrequest.data.recieve
@kotlinx.serialization.Serializable
data class Amount(
    val currency: String,
    val value: String
)