package com.example.postrequest.navigation.page

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.postrequest.data.listObject.Object
import com.example.postrequest.navigation.Screens

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StartScreen(
    listOfobject: List<Object>,
    navController: NavHostController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        LazyColumn{
            items(listOfobject){ item: com.example.postrequest.data.listObject.Object ->
                objectCard(
                    obj = item,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun objectCard(
    obj: Object,
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    Card(
        elevation = 6.dp,
        backgroundColor = Color.White,
        border = BorderStroke(1.dp,Color.Gray),
        modifier = modifier
            .padding(vertical = 5.dp)
            .clickable {
                navController.navigate(Screens.Object.route+"/${obj.index}")
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(10.dp)
        ) {
            Column(horizontalAlignment = Alignment.Start, modifier = modifier.weight(1f), verticalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = obj.nameObject,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp,
                )
                Spacer(modifier = modifier.height(8.dp))
                Column() {
                    Text(
                        text = obj.status,
                        color = Color.Black,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .drawBehind {
                                drawRoundRect(
                                    obj.colorStat,
                                    cornerRadius = CornerRadius(5.dp.toPx())
                                )
                            }
                            .padding(4.dp)
                    )
                    Text(
                        text = "Дата начала: "+obj.data,
                        color = Color.Black,
                        fontSize = 12.sp,
                    )
                }

            }

            Image(
                painter = painterResource(id = obj.imageObject),
                contentDescription = "My Image",
                modifier
                    .size(75.dp)
                    .clip(shape = RoundedCornerShape(10)),
                contentScale = ContentScale.Crop
            )
        }

    }
}