package studio.eyesthetics.tetaexoplayerlesson.exoplayer.listener

import android.util.Log
import com.google.android.exoplayer2.analytics.AnalyticsListener
import com.google.android.exoplayer2.source.LoadEventInfo
import com.google.android.exoplayer2.source.MediaLoadData
import java.io.IOException

class PlayerAnalyticsListener : AnalyticsListener {
    override fun onRenderedFirstFrame(
        eventTime: AnalyticsListener.EventTime,
        output: Any,
        renderTimeMs: Long
    ) {
        Log.d(TAG, "$TAG.onRenderedFirstFrame: ")
        super.onRenderedFirstFrame(eventTime, output, renderTimeMs)
    }

    override fun onDroppedVideoFrames(
        eventTime: AnalyticsListener.EventTime,
        droppedFrames: Int,
        elapsedMs: Long
    ) {
        Log.d(TAG, "$TAG.onDroppedVideoFrames: ")
        super.onDroppedVideoFrames(eventTime, droppedFrames, elapsedMs)
    }

    override fun onLoadStarted(
        eventTime: AnalyticsListener.EventTime,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        Log.d(TAG, "$TAG.onLoadStarted: ")
        super.onLoadStarted(eventTime, loadEventInfo, mediaLoadData)
    }

    override fun onLoadCompleted(
        eventTime: AnalyticsListener.EventTime,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        Log.d(TAG, "$TAG.onLoadCompleted: ")
        super.onLoadCompleted(eventTime, loadEventInfo, mediaLoadData)
    }

    override fun onLoadCanceled(
        eventTime: AnalyticsListener.EventTime,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        Log.d(TAG, "$TAG.onLoadCanceled: ")
        super.onLoadCanceled(eventTime, loadEventInfo, mediaLoadData)
    }

    override fun onLoadError(
        eventTime: AnalyticsListener.EventTime,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData,
        error: IOException,
        wasCanceled: Boolean
    ) {
        Log.d(TAG, "$TAG.onLoadError: ")
        super.onLoadError(eventTime, loadEventInfo, mediaLoadData, error, wasCanceled)
    }

    companion object {
        private const val TAG = "PlayerAnalyticsListener"
    }
}