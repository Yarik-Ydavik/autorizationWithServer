package com.example.postrequest.navigation.page

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postrequest.data.listObject.Object
import com.example.postrequest.elementsUI.dropDownField
import com.example.postrequest.elementsUI.textField

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.postrequest.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun ObjectScreen(
    modifier: Modifier = Modifier,
    cardinfo: Object,
    navController: NavHostController,
){
    var context = LocalContext.current

    var okrug by remember { mutableStateOf("") }
    var rayon by remember { mutableStateOf("") }
    var adres by remember { mutableStateOf("") }

    var type by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var square by remember { mutableStateOf("") }

    var sobstvennik by remember { mutableStateOf("") }
    var polzovatel by remember { mutableStateOf("") }

    val Orenburg = LatLng(1.35, 103.87)
    val OrenburgState = MarkerState (position = Orenburg)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(Orenburg, 10f)
    }

    Column(modifier = modifier
        .verticalScroll(rememberScrollState())
        .padding(10.dp)) {
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxWidth()) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(red = 8, green = 166, blue = 106)
                ),
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Обновить", color = Color.White)
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(red = 205, green = 6, blue = 53)
                ),
                onClick = { /*TODO*/ },

            ) {
                Text(text = "Удалить", color = Color.White)
            }

        }
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxWidth()) {
            Text(
                text = cardinfo.nameObject,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Документы объекта",
                color = Color.Black,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
                modifier = modifier.clickable {
                    // Открытие страницы с документами объекта
                }
            )
        }

        Spacer(modifier = modifier.height(10.dp))
        // 1 блок местоположение объекта
        Column() {
            Text(
                text = "Местоположение объекта",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = modifier.height(10.dp))
            textField(label = "Округ", text = okrug, onTextChange = {it -> okrug = it}, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = modifier.height(10.dp))
            textField(label = "Район", text = rayon, onTextChange = {it -> rayon = it}, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = modifier.height(10.dp))
            textField(label = "Адрес", text = adres, onTextChange = {it -> adres = it}, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = modifier.height(10.dp))

        }

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(10.dp))
        // 2 блок Характеристики
        Column() {
            Spacer(modifier = modifier.height(10.dp))
            Text(
                text = "Характеристики объекта",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = modifier.height(10.dp))
            dropDownField(
                label = "Собственник",
                text = type,
                onTextChange = {it -> type = it},
                param1 = "Жилой дом",
                param2 = "Торговый центр",
                param3 = "Гос. учреждение",
                param4 = "Закрытое",
            )
            Spacer(modifier = modifier.height(10.dp))
            dropDownField(
                label = "Состояние объекта",
                text = status,
                onTextChange = {it -> status = it},
                param1 = "В работе",
                param2 = "Новый",
                param3 = "Работы завершены",
                param4 = "",
            )
            Spacer(modifier = modifier.height(10.dp))
            textField(label = "Площадь", text = square, onTextChange = {it -> square = it}, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = modifier.height(10.dp))


        }
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(10.dp))

        // 3 блок прочее
        Column() {
            Spacer(modifier = modifier.height(10.dp))

            Text(
                text = "Прочее",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = modifier.height(10.dp))
            textField(label = "Собственник", text = sobstvennik, onTextChange = {it -> sobstvennik = it}, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = modifier.height(10.dp))
            textField(label = "Фактический пользователь", text = polzovatel, onTextChange = {it -> polzovatel = it}, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = modifier.height(10.dp))
        }
        Spacer(modifier = modifier.height(10.dp))

        val singapore = LatLng(1.35, 103.87)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(singapore, 10f)
        }


        Spacer(modifier = modifier.height(10.dp))
        Image(painter = painterResource(id = R.drawable.map), contentDescription = null, modifier = modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
        Spacer(modifier = modifier.height(10.dp))
        Image(painter = painterResource(id = cardinfo.imageObject), contentDescription = null)
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue
            ),
            onClick = { navController.navigate("gallery") },
        ) {
            Text(text = "Добавить картинку", color = Color.White)
        }
    }
}
