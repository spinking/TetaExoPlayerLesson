package studio.eyesthetics.tetaexoplayerlesson.exoplayer.datasource

import android.util.Log
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DataSpec
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class LoggableHttpDataSource : DefaultHttpDataSource() {
    override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
        Log.d(TAG, "$TAG.read: ")
        return super.read(buffer, offset, length)
    }

    override fun open(dataSpec: DataSpec): Long {
        Log.d(TAG, "$TAG.open: ")
        return super.open(dataSpec)
    }

    override fun close() {
        Log.d(TAG, "$TAG.close: ")
        super.close()
    }

    class Factory : DataSource.Factory {
        override fun createDataSource(): DataSource {
            return LoggableHttpDataSource()
        }
    }

    companion object {
        private const val TAG = "LoggableHttpDataSource"
    }
}