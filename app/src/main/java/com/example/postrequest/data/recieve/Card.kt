package com.example.postrequest.data.recieve
@kotlinx.serialization.Serializable
data class Card(
    val card_type: String,
    val expiry_month: String,
    val expiry_year: String,
    val first6: String,
    val issuer_country: String,
    val last4: String
)