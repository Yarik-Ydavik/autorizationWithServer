package com.example.postrequest.network.request

import com.example.postrequest.network.ClientServer
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class Autorization {
    suspend fun postAutorization(mail: String, password: String):String {
        val responce: HttpResponse = ClientServer.client.post("https://app.izumra.ru/api/user"){
            contentType(ContentType.Application.Json)
            setBody(
                com.example.postrequest.data.autorization.Autorization(
                    typeInvite = "login",
                    email = mail,
                    password = password,
                )
            )
        }
        return responce.body()
    }
}