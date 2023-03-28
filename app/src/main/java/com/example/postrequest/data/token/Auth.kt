package com.example.postrequest.data.token

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Auth(
    @SerialName("secretKey")
    val secretKey: String,
    val shopId: String
)