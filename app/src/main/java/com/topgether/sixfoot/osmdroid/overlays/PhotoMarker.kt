package com.topgether.sixfoot.osmdroid.overlays

import android.content.Context
import android.view.MotionEvent
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

/**
 * Created by kim on 2018/7/4.
 *
 */
class PhotoMarker(mapView: MapView?) : Marker(mapView) {

    constructor(mapView: MapView?, context: Context) : this(mapView) {

    }

    override fun onSingleTapConfirmed(event: MotionEvent?, mapView: MapView?): Boolean {
        val touched = hitTest(event, mapView)
        if (touched) {
            return if (mOnMarkerClickListener == null) {
                onMarkerClickDefault(this, mapView)
            } else {
                mOnMarkerClickListener.onMarkerClick(this, mapView)
            }
        } else {
            closeInfoWindow()
        }
        return touched
    }
}