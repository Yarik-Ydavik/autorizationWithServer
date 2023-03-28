package com.example.postrequest.data.recieve
@kotlinx.serialization.Serializable
data class PaymentMethod(
    val card: Card,
    val id: String,
    val saved: Boolean,
    val title: String,
    val type: String
)