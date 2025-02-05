package com.krishal.canvas

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.sp

@Composable
fun bottle() {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var progress by remember {
            mutableStateOf(0.1f)
        }
        val animatedprogress: Float by animateFloatAsState(
            targetValue = progress,
            animationSpec = tween(1000)
        )


        Canvas(
            modifier = Modifier.size(150.dp, 350.dp) // Custom bottle size
        ) {
            val waterHeight = size.height * animatedprogress
            val bottleWidth = size.width
            val bottleHeight = size.height

            // **🔴 Draw Bottle**
            drawRoundRect(
                cornerRadius = CornerRadius(15f, 15f),
                size = Size(bottleWidth, bottleHeight - 50), // Leave space for birkro
                topLeft = Offset(0f, 50f), // Move bottle down
                color = Color.Red,
                style = Stroke(5f)
            )

            // **🔵 Draw Birkro (Bottle Opener)**
            drawRoundRect(
                cornerRadius = CornerRadius(10f, 10f),
                size = Size(bottleWidth * 0.7f, 50f), // Smaller than bottle width
                topLeft = Offset(bottleWidth * 0.15f, 0f), // Centered
                color = Color.Gray,
                style = Stroke(5f)
            )

            // **⚪ Draw Hole in Opener**
            drawCircle(
                color = Color.Black,
                radius = 15f,
                center = Offset(bottleWidth / 2, 25f) // Center of the opener
            )
            drawRoundRect(
                color = Color(0xFF2196F3),
                size = Size(size.width, waterHeight),
                topLeft = Offset(0f, size.height - waterHeight),
                cornerRadius = CornerRadius(15f, 15f) // ✅ Ensuring rounded corners for water fill
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "${(progress * 100).toInt()}%", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { progress = (progress + 0.1f).coerceIn(0f, 1f) }) {
            Text("Fill Water")
        }
    }
}