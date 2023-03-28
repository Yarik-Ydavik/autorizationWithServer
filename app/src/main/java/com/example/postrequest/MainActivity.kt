package com.example.postrequest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.postrequest.data.recieve.RecieveModelX
import com.example.postrequest.data.recieve.RecieveModelXItem
import com.example.postrequest.data.token.Auth
import com.example.postrequest.data.token.DataModelX
import com.example.postrequest.network.ClientServer.client
import com.example.postrequest.network.request.Payment
import com.example.postrequest.ui.theme.PostRequestTheme
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import ru.yoomoney.sdk.kassa.payments.Checkout
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.*
import java.math.BigDecimal
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostRequestTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White), contentAlignment = Alignment.Center) {
                    buttonPayment()
                }
            }
        }
    }
}


@Composable
fun buttonPayment() {
    var context = LocalContext.current
    var text by remember { mutableStateOf("Loading") }

    val paymentParameters = PaymentParameters(
        amount = Amount(BigDecimal.valueOf(10.00), Currency.getInstance("RUB")),
        title = "Андрей Чернышёв",
        subtitle = "Студент ОКЭИ",
        clientApplicationKey = "test_MjAxMzIwxdkkzAEuA62MwZJBswL4idkF48kt7VfCD3c",
        shopId = "201320",
        savePaymentMethod = SavePaymentMethod.OFF,
        paymentMethodTypes = setOf(
            PaymentMethodType.GOOGLE_PAY,
            PaymentMethodType.BANK_CARD, PaymentMethodType.SBERBANK),
        userPhoneNumber = "+79871910893",
    )
    val uiParameters = UiParameters(
        showLogo = false
    )
    val launcher2 = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { result ->
            val resultCode = result.resultCode
            val data = result.data

            when (resultCode) {
                Activity.RESULT_OK -> {}
                Activity.RESULT_CANCELED -> return@rememberLauncherForActivityResult // Экран 3ds был закрыт
                Checkout.RESULT_ERROR -> {}
            }
        }
    )
    fun showError() {
        Toast.makeText(context, "Оплата отменена", Toast.LENGTH_SHORT).show()
    }
    fun showToken(data: Intent?) {
        if (data != null) {
            val token = Checkout.createTokenizationResult(data).paymentToken
            runBlocking {
                Payment().postToken(token)
                text = Payment().getConfirmUrl()
            }
            val inte = Checkout.createConfirmationIntent( context, text, PaymentMethodType.BANK_CARD )
            launcher2.launch(inte)
        } else {
            showError()
        }
    }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { result ->
            val data: Intent? = result.data
            if (result.resultCode == Activity.RESULT_OK) {
                showToken(data)
            } else {
                showError()
            }
        }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White), contentAlignment = Alignment.Center) {
        Column() {
            Button(onClick = {
                val intent = Checkout.createTokenizeIntent(context = context, paymentParameters,uiParameters = uiParameters)
                launcher.launch(intent)

            }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 13, green = 110, blue = 253)), modifier = Modifier.size(width = 200.dp, height = 80.dp)) {
                Text(text = "Купить", color = Color.White)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        
    }
}



