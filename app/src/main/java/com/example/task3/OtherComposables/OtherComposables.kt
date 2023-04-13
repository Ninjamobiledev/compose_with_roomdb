package com.example.task3.OtherComposables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalUnitApi::class)
@Composable
fun TopBar(canGoBack: Boolean, onBackPress: (() -> Unit)? = null) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(4.dp, Color.Black)

    ) {
        if (canGoBack) {
            IconButton(onClick = {
                onBackPress!!.invoke()
            }, modifier = Modifier.padding(end = 3.dp)) {
                Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = "Back icon"
                )
            }
        }
        Text(
            text = "UserDirectory", modifier = Modifier.align(Alignment.CenterVertically).padding(10.dp), style = TextStyle(
                fontSize = TextUnit(
                    20f,
                    TextUnitType.Sp
                ), fontWeight = FontWeight.Bold
            )
        )
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun TitleText(text: String) {
    Text(
        text = text, modifier = Modifier.padding(15.dp), style = TextStyle(
            fontSize = TextUnit(
                20f,
                TextUnitType.Sp
            ), color = Color.Black
        )
    )
}
@Composable
fun VerticalSpacer(value:Int){
    Spacer(modifier = Modifier.height(value.dp))
}
@Composable
fun HorizontalSpacer(value:Int){
    Spacer(modifier = Modifier.width(value.dp))
}
@OptIn(ExperimentalUnitApi::class)
@Composable
fun CustomButton(text:String,onClick:()->Unit){

    Button(onClick = { onClick.invoke()}, modifier = Modifier.fillMaxWidth().padding(30.dp).clip(
        RoundedCornerShape(20.dp)
    )) {
        Text(text = text,modifier=Modifier.padding(5.dp), style = TextStyle(fontSize = TextUnit(20f, TextUnitType.Sp)))
    }
}
@OptIn(ExperimentalUnitApi::class)
@Composable
fun CustomText(text:String,textSize:Float){
    Text(text=text,modifier=Modifier.padding(2.dp), style = TextStyle(fontSize = TextUnit(textSize,
        TextUnitType.Sp), color = Color.Gray)
    )
}