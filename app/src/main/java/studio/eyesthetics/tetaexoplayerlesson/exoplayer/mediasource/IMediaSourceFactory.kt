package studio.eyesthetics.tetaexoplayerlesson.exoplayer.mediasource

import com.google.android.exoplayer2.source.MediaSource

interface IMediaSourceFactory {
    fun create(
        streamUrl: String,
        licenseUrl: String
    ): MediaSource
}