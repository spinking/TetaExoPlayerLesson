package studio.eyesthetics.tetaexoplayerlesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import studio.eyesthetics.tetaexoplayerlesson.ui.player.VideoPlayer
import studio.eyesthetics.tetaexoplayerlesson.ui.theme.TetaExoPlayerLessonTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TetaExoPlayerLessonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VideoPlayer()
                }
            }
        }
    }
}