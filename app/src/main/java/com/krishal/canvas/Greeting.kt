import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
fun Greeting() {
    var progress by remember { mutableStateOf(0.3f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(1000), label = ""
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(modifier = Modifier.size(150.dp, 250.dp)) {
            val waterHeight = size.height * animatedProgress
            val cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx()) // ✅ Fixed corner radius

            // Draw bottle outline
            drawRoundRect(
                color = Color.Black,
                size = size,
                cornerRadius = cornerRadius,
                style = Stroke(width = 4f)

            )

            // Draw water inside
            drawRoundRect(
                color = Color(0xFF2196F3),
                size = Size(size.width, waterHeight),
                topLeft = Offset(0f, size.height - waterHeight),
                cornerRadius = cornerRadius // ✅ Ensuring rounded corners for water fill
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "${(animatedProgress * 100).toInt()}%", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { progress = (progress + 0.1f).coerceIn(0f, 1f) }) {
            Text("Fill Water")
        }
    }
}
