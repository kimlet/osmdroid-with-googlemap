package com.topgether.sixfoot.osmdroid.overlays

import android.graphics.Canvas
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.OverlayWithIW

/**
 * Created by kim on 2018/7/5.
 *
 */
class GrayOverlay : OverlayWithIW() {
    override fun draw(canvas: Canvas, p1: MapView?, p2: Boolean) {
        canvas.drawARGB(90, 0, 0, 0)
    }
}