import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class StopWatch {
    var formattedTime by mutableStateOf("00:00:00:000")
    private var coroutineScope = CoroutineScope(Dispatchers.Default)

    private var isClockActive = false

    private var timeInMillis = 0L
    private var lastTimeStamp = 0L

    fun start(){
        if (isClockActive) return

        coroutineScope.launch {
            lastTimeStamp = System.currentTimeMillis()
            isClockActive = true
            while (isClockActive){
                delay(10L)
                timeInMillis += System.currentTimeMillis() - lastTimeStamp
                lastTimeStamp  = System.currentTimeMillis()
                formattedTime = formatTime(timeInMillis)

            }
        }
    }

    fun pause(){
        isClockActive = false
    }

    fun reset(){
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Default)
        timeInMillis = 0L
        lastTimeStamp = 0L
        formattedTime = "00:00:00:000"
    }
    private fun formatTime(timeInMillis: Long): String {
        val localDateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timeInMillis),
            ZoneId.systemDefault()
        )

        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSS", Locale.getDefault())
        return localDateTime.format(formatter)
    }

}