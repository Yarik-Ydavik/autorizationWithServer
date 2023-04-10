package com.example.postrequest.navigation.page

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.image_pick.data.PickImage
import com.example.image_pick.ui.Pick
import com.example.postrequest.buttonPayment

@Composable
fun PaymentScreen(navController: NavHostController) {
    var selectedImages = remember { mutableStateListOf<PickImage>() }
    var boolean = remember { mutableStateOf(false) }
    Column() {
        buttonPayment()

    }
}