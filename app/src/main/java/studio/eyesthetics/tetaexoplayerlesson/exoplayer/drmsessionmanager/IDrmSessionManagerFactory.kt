package studio.eyesthetics.tetaexoplayerlesson.exoplayer.drmsessionmanager

import com.google.android.exoplayer2.drm.DrmSessionManager

interface IDrmSessionManagerFactory {
    fun create(licenseUrl: String): DrmSessionManager
}