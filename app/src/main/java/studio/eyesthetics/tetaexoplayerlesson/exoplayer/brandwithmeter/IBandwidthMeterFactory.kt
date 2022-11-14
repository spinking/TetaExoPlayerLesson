package studio.eyesthetics.tetaexoplayerlesson.exoplayer.brandwithmeter

import com.google.android.exoplayer2.upstream.BandwidthMeter

interface IBandwidthMeterFactory {
    fun create(): BandwidthMeter
}