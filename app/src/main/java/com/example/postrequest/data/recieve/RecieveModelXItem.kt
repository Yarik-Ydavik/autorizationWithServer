package com.example.postrequest.data.recieve
@kotlinx.serialization.Serializable
data class RecieveModelXItem(
    val id_token: Int,
    val tokeninfo: Tokeninfo
)