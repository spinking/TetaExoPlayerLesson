package studio.eyesthetics.tetaexoplayerlesson.ui.player

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoPlayer(
    exoPlayer: ExoPlayer,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(modifier = modifier) {
        DisposableEffect(key1 = Unit) { onDispose { exoPlayer.release() } }

        AndroidView(
            factory = {
                StyledPlayerView(context).apply {
                    player = exoPlayer
                    layoutParams =
                        FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                }
            }
        )
    }
}