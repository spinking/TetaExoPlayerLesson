package studio.eyesthetics.tetaexoplayerlesson.exoplayer.player

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.brandwithmeter.IBandwidthMeterFactory
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.listener.PlayerAnalyticsListener
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.listener.PlayerListener
import studio.eyesthetics.tetaexoplayerlesson.exoplayer.mediasource.IMediaSourceFactory

class PlayerFactory(
    private val context: Context,
    private val mediaSourceFactory: IMediaSourceFactory,
    private val bandwidthMeterFactory: IBandwidthMeterFactory
) : IPlayerFactory {
    override fun create(streamUrl: String, licenseUrl: String): ExoPlayer {
        val mediaSource = mediaSourceFactory.create(streamUrl, licenseUrl)
        val bandwidthMeter = bandwidthMeterFactory.create()
        return ExoPlayer.Builder(context)
            .setBandwidthMeter(bandwidthMeter)
            .build().apply {
                setMediaSource(mediaSource)
                addAnalyticsListener(PlayerAnalyticsListener())
                addListener(PlayerListener())
            }
    }
}