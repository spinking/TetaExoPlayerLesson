package studio.eyesthetics.tetaexoplayerlesson.exoplayer.player

import com.google.android.exoplayer2.ExoPlayer

interface IPlayerFactory {
    fun create(
        streamUrl: String,
        licenseUrl: String
    ): ExoPlayer
}