package com.example.postrequest.data.recieve

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Confirmation(
    @SerialName("confirmation_url")
    val confirmation_url: String,
    val type: String
)