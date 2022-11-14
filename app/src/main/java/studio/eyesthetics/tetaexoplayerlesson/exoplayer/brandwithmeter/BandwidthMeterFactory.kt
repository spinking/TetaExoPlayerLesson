package studio.eyesthetics.tetaexoplayerlesson.exoplayer.brandwithmeter

import android.content.Context
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter

class BandwidthMeterFactory(
    private val context: Context
) : IBandwidthMeterFactory {
    override fun create(): BandwidthMeter {
        return DefaultBandwidthMeter.Builder(context)
            .setInitialBitrateEstimate(DEFAULT_BITRATE)
            .build()
    }

    companion object {
        private const val DEFAULT_BITRATE = 6000000L / 20
    }
}