package com.example.postrequest.data.autorization
@kotlinx.serialization.Serializable
data class Autorization(
    val typeInvite:String,
    val email:String,
    val password:String
)
