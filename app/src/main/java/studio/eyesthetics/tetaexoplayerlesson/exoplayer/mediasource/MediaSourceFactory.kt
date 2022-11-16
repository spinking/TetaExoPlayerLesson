package studio.eyesthetics.tetaexoplayerlesson.exoplayer.mediasource

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.CustomDashManifestParser
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.datasource.LoggableHttpDataSource
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.drmsessionmanager.IDrmSessionManagerFactory
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.listener.MediaSourceEventLogger
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.loaderrorhandling.ILoadErrorHandlingFactory

class MediaSourceFactory(
    private val context: Context,
    private val loadErrorHandlingFactory: ILoadErrorHandlingFactory,
    private val drmSessionManagerFactory: IDrmSessionManagerFactory
) : IMediaSourceFactory {
    override fun create(streamUrl: String, licenseUrl: String): MediaSource {
        val mediaItem = MediaItem.fromUri(streamUrl)
        val loadErrorHandlingPolicy = loadErrorHandlingFactory.create()

        val manifestDataSourceFactory = DefaultDataSource.Factory(context)

        val chunkDataSourceFactory = LoggableHttpDataSource.Factory()
        val dashChunkSourceFactory = DefaultDashChunkSource.Factory(chunkDataSourceFactory)

        val mediaSourceFactory = DashMediaSource.Factory(
            dashChunkSourceFactory,
            manifestDataSourceFactory
        ).apply {
            setLoadErrorHandlingPolicy(loadErrorHandlingPolicy)
            setManifestParser(CustomDashManifestParser())
        }

        val drmSessionManager = drmSessionManagerFactory.create(licenseUrl)
        mediaSourceFactory.setDrmSessionManagerProvider { drmSessionManager }

        return mediaSourceFactory.createMediaSource(mediaItem).apply {
            addEventListener(Handler(Looper.getMainLooper()), MediaSourceEventLogger())
        }
    }
}