package com.example.postrequest.data.autorization

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class User(
    @SerialName("avatar")
    val avatar: String,
    val email: String,
    val firstname: String,
    val id_user: Int,
    val pass: String,
    val secondname: String
)