package studio.eyesthetics.tetaexoplayerlesson.exoplayer.listener

import android.util.Log
import com.google.android.exoplayer2.source.LoadEventInfo
import com.google.android.exoplayer2.source.MediaLoadData
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MediaSourceEventListener
import java.io.IOException

class MediaSourceEventLogger : MediaSourceEventListener {

    override fun onLoadStarted(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        Log.d(TAG, "$TAG.onLoadStarted: ")
        super.onLoadStarted(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData)
    }

    override fun onLoadCompleted(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        Log.d(TAG, "$TAG.onLoadCompleted: ")
        super.onLoadCompleted(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData)
    }

    override fun onLoadCanceled(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        Log.d(TAG, "$TAG.onLoadCanceled: ")
        super.onLoadCanceled(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData)
    }

    override fun onLoadError(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData,
        error: IOException,
        wasCanceled: Boolean
    ) {
        Log.d(TAG, "$TAG.onLoadError: ")
        super.onLoadError(
            windowIndex,
            mediaPeriodId,
            loadEventInfo,
            mediaLoadData,
            error,
            wasCanceled
        )
    }

    override fun onUpstreamDiscarded(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId,
        mediaLoadData: MediaLoadData
    ) {
        Log.d(TAG, "$TAG.onUpstreamDiscarded: ")
        super.onUpstreamDiscarded(windowIndex, mediaPeriodId, mediaLoadData)
    }

    override fun onDownstreamFormatChanged(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        mediaLoadData: MediaLoadData
    ) {
        Log.d(TAG, "$TAG.onDownstreamFormatChanged: ")
        super.onDownstreamFormatChanged(windowIndex, mediaPeriodId, mediaLoadData)
    }

    companion object {
        private const val TAG = "MediaSourceEventLogger"
    }
}