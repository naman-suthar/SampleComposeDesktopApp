import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.ComposeDialog
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.key.NativeKeyEvent
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.w3c.dom.Text
import java.awt.Dimension


@Composable
@Preview
fun App() {

    MaterialTheme {
         Box(
             contentAlignment = Alignment.Center,
             modifier = Modifier.fillMaxSize()
         ){
             val stopWatch = remember { StopWatch() }
             StopWatchDisplay(
                 formattedTime = stopWatch.formattedTime,
                 onStartCLick = stopWatch::start,
                 onStopClick = stopWatch::pause,
                 onResetClick = stopWatch::reset
             )
         }




    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication) {

        App()
    }
}

/*
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OverlayScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        // Existing content goes here
        // ...

        // Overlay
        Canvas(
            modifier = Modifier.fillMaxSize()
                .pointerMoveFilter(onMove = { true }),
            onDraw = {
                drawOverlay(this, "Overlay Screen")
            }
        )
    }
}


private fun drawOverlay(drawScope: DrawScope, text: String) {
    // Draw translucent black overlay
    drawScope.drawRect(
        color = Color(0f, 0f, 0f, 0.5f),
        topLeft = Offset(0f, 0f),
        size = drawScope.size
    )

    drawScope.drawCircle(
        brush = Brush.linearGradient(listOf(Color.Blue, Color.Green)),
        radius = 50f,
        center = Offset(150f, 150f)
    )

}

@Composable
fun NewScreen(){
    Box(modifier = Modifier.fillMaxSize()) {
        OverlayScreen()
    }
}*/
/* var showDialog by remember { mutableStateOf(false) }
        if (showDialog) {

        }

        // add a button to trigger the overlay screen
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    println(showDialog)
                    showDialog = true
                },
                content = { Text("Show overlay screen") }
            )
        }*/