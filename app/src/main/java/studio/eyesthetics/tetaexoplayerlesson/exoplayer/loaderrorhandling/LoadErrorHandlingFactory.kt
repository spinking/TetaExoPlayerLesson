package studio.eyesthetics.tetaexoplayerlesson.exoplayer.loaderrorhandling

import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy

class LoadErrorHandlingFactory : ILoadErrorHandlingFactory {
    override fun create(): LoadErrorHandlingPolicy {
        return object : DefaultLoadErrorHandlingPolicy() {
            override fun getRetryDelayMsFor(loadErrorInfo: LoadErrorHandlingPolicy.LoadErrorInfo): Long {
                return if (loadErrorInfo.errorCount >= DEFAULT_ERROR_COUNT) {
                    C.TIME_UNSET
                } else {
                    (loadErrorInfo.errorCount - 1) * DEFAULT_TIME_LAG
                }
            }

            override fun getMinimumLoadableRetryCount(dataType: Int): Int {
                return DEFAULT_ERROR_COUNT
            }
        }
    }

    companion object {
        private const val DEFAULT_ERROR_COUNT = 4
        private const val DEFAULT_TIME_LAG = 3000L
    }
}