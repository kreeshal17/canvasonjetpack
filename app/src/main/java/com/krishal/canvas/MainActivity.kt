package com.krishal.canvas

import Greeting
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.krishal.canvas.ui.theme.CanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CanvasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                bottle(

                    )
                }
            }
        }
    }
}
//
//@Composable
//fun Greeting() {
//Canvas(modifier=Modifier.
//fillMaxSize().padding(50.dp)
//
//
//) {
//
//    val width= size.width
//    val height= size.height
//
////    drawCircle(
////       radius = 150f,
////        color= Color.Red
//
////    )
//    drawLine(
//        start =Offset(0f,height/2) ,
//        end = Offset(width,height/2),
//        color = Color.Red,
//        strokeWidth = 5.dp.toPx()



//    )















