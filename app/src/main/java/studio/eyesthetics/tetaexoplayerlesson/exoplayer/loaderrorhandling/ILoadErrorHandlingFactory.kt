package studio.eyesthetics.tetaexoplayerlesson.exoplayer.loaderrorhandling

import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy

interface ILoadErrorHandlingFactory {
    fun create(): LoadErrorHandlingPolicy
}