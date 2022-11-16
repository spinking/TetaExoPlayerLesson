package studio.eyesthetics.tetaexoplayerlesson.exoplayer.listener

import android.util.Log
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Tracks

class PlayerListener : Player.Listener {
    override fun onPlayerError(error: PlaybackException) {
        Log.d(TAG, "$TAG.onPlayerError: ")
        super.onPlayerError(error)
    }

    override fun onPlaybackStateChanged(playbackState: Int) {
        Log.d(TAG, "$TAG.onPlaybackStateChanged: ")
        super.onPlaybackStateChanged(playbackState)
    }

    override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
        Log.d(TAG, "$TAG.onPlayWhenReadyChanged: ")
        super.onPlayWhenReadyChanged(playWhenReady, reason)
    }

    override fun onTracksChanged(tracks: Tracks) {
        Log.d(TAG, "$TAG.onTracksChanged: ")
        super.onTracksChanged(tracks)
    }

    companion object {
        private const val TAG = "PlayerListener"
    }
}