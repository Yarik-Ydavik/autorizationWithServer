package com.example.postrequest.navigation.page

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.image_pick.PickConfiguration
import com.example.image_pick.data.PickImage
import com.example.image_pick.ui.Pick
import com.example.image_pick.ui.permission.Permission
import android.provider.Settings


@Composable
fun PhotoScreen(){
    val context = LocalContext.current

    fun goToAppSettings() {
        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:${context.packageName}")).apply {
            addCategory(Intent.CATEGORY_DEFAULT)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(this)
        }
    }

    var selectedImages = remember { mutableStateListOf<PickImage>() }
    var bolean = remember { mutableStateOf(false) }
    Permission(
        permissions = listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ),
        goToAppSettings = { goToAppSettings() }) {
        if (!bolean.value){
            Pick(
                pickConfiguration = PickConfiguration(true),
                onPhotoSelected ={ images ->
                    selectedImages.addAll(images)
                    bolean.value = true
                }
            )
        }
        else SelectedImages(selectedImages = selectedImages)
    }
}
@Composable
fun SelectedImages(selectedImages: List<PickImage>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {
        selectedImages.forEach { image ->
            Image(
                painter = rememberAsyncImagePainter(image.uri),
                contentDescription = null,
                modifier = Modifier.size(400.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}