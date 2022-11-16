package studio.eyesthetics.tetaexoplayerlesson.exoplayer

import android.net.Uri
import com.google.android.exoplayer2.source.dash.manifest.DashManifest
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser
import com.google.android.exoplayer2.source.dash.manifest.Period
import java.io.InputStream

class CustomDashManifestParser : DashManifestParser() {
    override fun parse(uri: Uri, inputStream: InputStream): DashManifest {
        val srcDashManifest = super.parse(uri, inputStream)
        return if (srcDashManifest.dynamic) {
            createLiveDashManifest(srcDashManifest)
        } else {
            srcDashManifest
        }
    }

    private fun createLiveDashManifest(srcDashManifest: DashManifest): DashManifest {
        val periods = mutableListOf<Period>()
        for (i in 0 until srcDashManifest.periodCount) {
            periods.add(srcDashManifest.getPeriod(i))
        }

        return DashManifest(
            srcDashManifest.availabilityStartTimeMs,
            srcDashManifest.durationMs,
            srcDashManifest.minBufferTimeMs,
            srcDashManifest.dynamic,
            srcDashManifest.minUpdatePeriodMs,
            srcDashManifest.timeShiftBufferDepthMs,
            srcDashManifest.timeShiftBufferDepthMs / 2,
            srcDashManifest.publishTimeMs,
            srcDashManifest.programInformation,
            srcDashManifest.utcTiming,
            srcDashManifest.serviceDescription,
            srcDashManifest.location,
            periods
        )
    }
}