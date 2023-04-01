package com.example.postrequest.network.request

import com.example.postrequest.network.ClientServer
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class Registration {
    suspend fun postRegistration(name: String, surname: String, mail: String, password: String): String {
        val responce : HttpResponse = ClientServer.client.post ("https://app.izumra.ru/api/user"){
            contentType(ContentType.Application.Json)
            setBody(
                com.example.postrequest.data.registration.Registration(
                    typeInvite = "registration",
                    email = mail,
                    password = password,
                    firstname = name,
                    surname = surname,
                )
            )
        }
        return responce.body()
    }
}