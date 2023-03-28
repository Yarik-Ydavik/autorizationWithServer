package com.example.postrequest.network.request

import com.example.postrequest.data.recieve.RecieveModelXItem
import com.example.postrequest.data.token.Amount
import com.example.postrequest.data.token.Auth
import com.example.postrequest.data.token.DataModelX
import com.example.postrequest.network.ClientServer
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class Payment {
    suspend fun postToken(token: String): String {
        val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val randomString = (1..20)
            .map { chars.random() }
            .joinToString("")

        val responce: HttpResponse = ClientServer.client.post("https://app.izumra.ru/api/token"){
            contentType(ContentType.Application.Json)
            setBody(
                DataModelX(
                    idempotencekey = randomString,
                    payment_token = token,
                    description = "Test",
                    amount = Amount(
                        value = "10.00",
                        currency = "RUB",
                    ),
                    auth = Auth(
                        shopId = "201320",
                        secretKey = "test_dpWti8pKGx94UJ1qAGZCEl65h0KN8w2viOK6l8esnqc",
                    ),
                )
            )
        }
        return responce.body()
    }
    // ----------------------------------------------------------------------------------------
    suspend fun getConfirmUrl(): String {
        val infoPayment : MutableList<RecieveModelXItem> = ClientServer.client.get("http://app.izumra.ru/api/token").body()
        return infoPayment.last().tokeninfo.confirmation.confirmation_url
    }
}