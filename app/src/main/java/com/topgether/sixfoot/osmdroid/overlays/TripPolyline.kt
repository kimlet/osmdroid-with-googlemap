package com.topgether.sixfoot.osmdroid.overlays

import android.view.MotionEvent
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Polyline

/**
 * Created by kim on 2018/7/5.
 *
 */
class TripPolyline(mapView: MapView?) : Polyline(mapView) {

    override fun onSingleTapConfirmed(event: MotionEvent, mapView: MapView): Boolean {
//        val pj = mapView.getProjection()
//        val eventPos = pj.fromPixels(event.getX().toInt(), event.getY().toInt()) as GeoPoint
//        val tolerance = (this.mPaint.strokeWidth * this.density).toDouble()
//        val touched = this.isCloseTo(eventPos, tolerance, mapView)
//        return if (touched) {
//            if (this.mOnClickListener == null) this.onClickDefault(this, mapView, eventPos) else this.mOnClickListener.onClick(this, mapView, eventPos)
//        } else {
//            touched
//        }
        return false
    }
}