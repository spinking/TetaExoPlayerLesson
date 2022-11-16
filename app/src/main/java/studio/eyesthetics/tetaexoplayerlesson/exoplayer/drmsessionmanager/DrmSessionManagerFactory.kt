package studio.eyesthetics.tetaexoplayerlesson.exoplayer.drmsessionmanager

import com.google.android.exoplayer2.drm.*
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util

class DrmSessionManagerFactory : IDrmSessionManagerFactory {
    override fun create(licenseUrl: String): DrmSessionManager {
        val uuid = Util.getDrmUuid(DRM_SCHEME) ?: throw IllegalStateException()
        val mediaDrm = FrameworkMediaDrm.newInstance(uuid)

        val dataSourceFactory = DefaultHttpDataSource.Factory()
        val drmCallback = HttpMediaDrmCallback(licenseUrl, dataSourceFactory)

        return DefaultDrmSessionManager.Builder()
            .setUuidAndExoMediaDrmProvider(uuid, ExoMediaDrm.AppManagedProvider(mediaDrm))
            .build(drmCallback)
    }

    companion object {
        private const val DRM_SCHEME = "widevine"
    }
}