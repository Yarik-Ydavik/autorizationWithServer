package com.example.postrequest.data.registration

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Registration(
    val email: String,
    val firstname: String,
    val password: String,
    val surname: String,
    val typeInvite: String
)