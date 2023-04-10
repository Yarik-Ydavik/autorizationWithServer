package com.example.postrequest

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.postrequest.network.request.Payment
import kotlinx.coroutines.runBlocking
import ru.yoomoney.sdk.kassa.payments.Checkout
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.*
import java.math.BigDecimal
import java.util.*

@Composable
fun buttonPayment() {
    var context = LocalContext.current
    var text by remember { mutableStateOf("Loading") }

    val paymentParameters = PaymentParameters(
        amount = Amount(BigDecimal.valueOf(10.00), Currency.getInstance("RUB")),
        title = "Андрей",
        subtitle = "",
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
            runBlocking { text = Payment().postToken(token) }
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