package studio.eyesthetics.tetaexoplayerlesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.brandwithmeter.BandwidthMeterFactory
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.drmsessionmanager.DrmSessionManagerFactory
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.loaderrorhandling.LoadErrorHandlingFactory
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.mediasource.MediaSourceFactory
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.player.PlayerFactory
import studio.eyesthetics.tetaexoplayerlesson.ui.player.VideoPlayer
import studio.eyesthetics.tetaexoplayerlesson.ui.theme.TetaExoPlayerLessonTheme

class MainActivity : ComponentActivity() {

    private val factory by lazy {
        PlayerFactory(
            context = this,
            mediaSourceFactory = MediaSourceFactory(
                context = this,
                loadErrorHandlingFactory = LoadErrorHandlingFactory(),
                drmSessionManagerFactory = DrmSessionManagerFactory()
            ),
            bandwidthMeterFactory = BandwidthMeterFactory(
                context = this
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TetaExoPlayerLessonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VideoPlayer(
                        exoPlayer = factory.create(STREAM_URL, DRM_URL)
                    )
                }
            }
        }
    }

    companion object {
        private const val STREAM_URL = "https://bitmovin-a.akamaihd.net/content/MI201109210084_1/mpds/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.mpd"
        private const val DRM_URL = ""
    }
}