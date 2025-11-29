package com.3dplayer.ui.mobile.gestures

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.Toast

class TouchGestureController(context: Context, private val videoPlayer: VideoPlayer) : 
    View.OnTouchListener {

    private val gestureDetector: GestureDetector
    private val scaleGestureDetector: ScaleGestureDetector

    init {
        gestureDetector = GestureDetector(context, GestureListener())
        scaleGestureDetector = ScaleGestureDetector(context, ScaleListener())
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        scaleGestureDetector.onTouchEvent(event)
        return gestureDetector.onTouchEvent(event) || event.pointerCount > 1
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onDoubleTap(e: MotionEvent?): Boolean {
            val width = videoPlayer.videoWidth
            val tapX = e?.x ?: return false
            val isSeekForward = tapX > width / 2
            videoPlayer.seekTo(if (isSeekForward) videoPlayer.currentPosition + 10000 else videoPlayer.currentPosition - 10000)
            Toast.makeText(videoPlayer.context, if (isSeekForward) "Seeked forward" else "Seeked backward", Toast.LENGTH_SHORT).show()
            return true
        }

        override fun onLongPress(e: MotionEvent?) {
            // Implement long press behavior (e.g., show options)
            Toast.makeText(videoPlayer.context, "Long Press detected", Toast.LENGTH_SHORT).show()
        }
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            // Handle pinch zoom
            videoPlayer.setZoomLevel(videoPlayer.currentZoomLevel * detector.scaleFactor)
            return true
        }
    }
}