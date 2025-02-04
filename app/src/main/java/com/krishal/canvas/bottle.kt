package com.krishal.canvas

import android.widget.Space
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp


@Composable
fun bottle()
{
    var waterprogress by remember {
        mutableStateOf(0.2f)
    }


    val wateranimation by animateFloatAsState(
        targetValue =waterprogress ,
        animationSpec = tween(1000),
        )

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement =Arrangement.Center, horizontalAlignment =Alignment.CenterHorizontally
    ) {

        Canvas(modifier = Modifier.size(150.dp,250.dp)) {
            val waterheight = size.height * waterprogress
            val cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
            drawRoundRect(
                color = Color.Black,
                size = size,
                style = Stroke(5f),
                cornerRadius = cornerRadius

            )

            drawRoundRect(
                color = Color(0xFF2196F3),
                cornerRadius = cornerRadius,
                size = Size(size.width, waterheight),
                topLeft = Offset(0f, size.height - waterheight)


            )


        }
        Text(text="${waterprogress*100}%")
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick ={
            waterprogress=(waterprogress+0.1f).coerceIn(0f,1f)


        } ) {


            Text(text="click me")
        }


        }




    }


