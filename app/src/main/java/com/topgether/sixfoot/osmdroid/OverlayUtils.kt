package com.topgether.sixfoot.osmdroid

import android.content.Context
import android.graphics.*
import com.topgether.sixfoot.osmdroid.overlays.ColorPolyline
import com.topgether.sixfoot.osmdroid.overlays.TripPolyline
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Polyline
import org.osmdroid.views.overlay.milestones.*
import java.util.*

/**
 * Created by kim on 2018/7/4.
 *
 */
class OverlayUtils {

    companion object {
        fun render10km(mMapView: MapView, context: Context) {

            mMapView.controller.setZoom(13.2)
            mMapView.controller.setCenter(GeoPoint(48.85792514768071, 2.342640914879439))


            val line = ColorPolyline(mMapView)
            line.paint.strokeCap = Paint.Cap.ROUND
            line.paint.strokeJoin = Paint.Join.ROUND
            line.width = 10f
            line.color = Color.BLUE
            val pts = ArrayList<GeoPoint>()
            pts.add(GeoPoint(48.85546563875735, 2.359844067173981, 1.0)) // saint paul
            pts.add(GeoPoint(48.85737826660179, 2.351524365470226, 3.0))// hôtel de ville
            pts.add(GeoPoint(48.86253652215784, 2.3354870181106264,4.0)) // louvre 1
            pts.add(GeoPoint(48.86292409137066, 2.3356209116511195, 3.3)) // louvre 2
            pts.add(GeoPoint(48.86989982398147, 2.332474413449688, 5.3)) // opéra loop 1
            pts.add(GeoPoint(48.87019045840439, 2.3327154218225985, 6.3)) // opéra loop 2
            pts.add(GeoPoint(48.87100070303335, 2.332420856033508, 7.3)) // opéra loop 3
            pts.add(GeoPoint(48.871987070089496, 2.3330367663197364, 8.3)) // opéra loop 4
            pts.add(GeoPoint(48.87285012531207, 2.3319923967039813, 9.3)) // opéra loop 5
            pts.add(GeoPoint(48.87270041271832, 2.33134970770962, 13.3)) // opéra loop 6
            pts.add(GeoPoint(48.87166121883793, 2.330720408069368, 23.3)) // opéra loop 7
            pts.add(GeoPoint(48.87096547527885, 2.331885281871564, 33.3)) // opéra loop 8
            pts.add(GeoPoint(48.87003193074662, 2.3321932370146783, 43.3)) // opéra loop 9
            pts.add(GeoPoint(48.86989982398147, 2.332474413449688, 53.3)) // opéra loop 10
            pts.add(GeoPoint(48.864306984328245, 2.3350719481351234, 63.3)) // rue de l'échelle 1
            pts.add(GeoPoint(48.86316191644713, 2.3338401275626666, 73.3)) // rue de l'échelle 2
            pts.add(GeoPoint(48.866209500723855, 2.3235169355912433, 83.3)) // rivoli
            pts.add(GeoPoint(48.866729156977776, 2.3223118937268623, 93.3)) // concorde
            pts.add(GeoPoint(48.86901910330005, 2.3239721736289027, 113.3)) // madeleine loop 1
            pts.add(GeoPoint(48.8691952486765, 2.3249897645366104, 32.3)) // madeleine loop 2
            pts.add(GeoPoint(48.87022568670458, 2.325927019319977, 31.3)) // madeleine loop 3
            pts.add(GeoPoint(48.870489898165346, 2.32583329384164, 30.3)) // madeleine loop 4
            pts.add(GeoPoint(48.87073649426996, 2.3250165432446863, 23.3)) // madeleine loop 5
            pts.add(GeoPoint(48.87075410823092, 2.3247085881016005, 13.3)) // madeleine loop 6
            pts.add(GeoPoint(48.86957395913612, 2.323570493007452, 23.3)) // madeleine loop 7
            pts.add(GeoPoint(48.86901910330005, 2.3239721736289027, 3.3)) // madeleine loop 8
            pts.add(GeoPoint(48.86664988772853, 2.3224457872673554, 31.3)) // concorde 1
            pts.add(GeoPoint(48.866183077380335, 2.3231420336778967, 32.3)) // concorde 2
            pts.add(GeoPoint(48.865610568177935, 2.3231688123859726, 33.3)) // concorde 3
            pts.add(GeoPoint(48.86398108306007, 2.321307692173235, 34.3)) // concorde 4
            pts.add(GeoPoint(48.863531864319754, 2.3216022579623257, 35.3)) // concorde 5
            pts.add(GeoPoint(48.86047157217769, 2.3306186871927252, 36.3)) // pont césaire
            pts.add(GeoPoint(48.859105908108276, 2.336824405441064, 37.3)) // mitterrand 1
            pts.add(GeoPoint(48.858679130445125, 2.3402407938844476, 38.3)) // mitterrand 2
            pts.add(GeoPoint(48.85792514768071, 2.342640914879439, 39.3)) // pont neuf
            pts.add(GeoPoint(48.8563361600739, 2.3489338967683864, 40.3)) // pont notre dame
            pts.add(GeoPoint(48.85582206974299, 2.3509713700276507, 41.3)) // pont d'arcole
            pts.add(GeoPoint(48.85403498622509, 2.3547049339593116, 43.3)) // pont louis philippe
            pts.add(GeoPoint(48.85303073607055, 2.3575358780393856, 44.3)) // pont marie
            pts.add(GeoPoint(48.852894107137885, 2.358500835434853, 45.3)) // quai des célestins 1
            pts.add(GeoPoint(48.85275705072659, 2.3589590819111095, 50.3)) // quai des célestins 2
            pts.add(GeoPoint(48.852639573503986, 2.3594411333991445, 60.3)) // quai des célestins 3
            pts.add(GeoPoint(48.85244769344759, 2.3598755748636506, 70.3)) // quai des célestins 4
            pts.add(GeoPoint(48.85215399805951, 2.360375480110463, 90.3)) // quai des célestins 5
            line.points = pts
            val managers = ArrayList<MilestoneManager>()
            val backgroundPaint = Paint()
            backgroundPaint.strokeWidth = 3.0f
            backgroundPaint.color = Color.WHITE
            backgroundPaint.style = Paint.Style.FILL_AND_STROKE
            backgroundPaint.isAntiAlias = true
            backgroundPaint.strokeCap = Paint.Cap.ROUND
            backgroundPaint.strokeJoin = Paint.Join.ROUND

            val backgroundRadius = 20f
            val textPaint = Paint()
            textPaint.color = Color.BLUE
            textPaint.strokeWidth = 1.5f
            textPaint.style = Paint.Style.STROKE
            textPaint.textSize = 20f
            textPaint.isAntiAlias = true
            val finishPaint = Paint()
            finishPaint.color = Color.RED
            finishPaint.strokeWidth = 2f
            finishPaint.style = Paint.Style.STROKE
            finishPaint.isAntiAlias = true
            val arrowPath = Path() // a simple arrow towards the right
//            arrowPath.moveTo(-5f, -5f)
//            arrowPath.lineTo(5f, 0f)
//            arrowPath.lineTo(-5f, 5f)
            arrowPath.moveTo(0f, 2f)
            arrowPath.lineTo(10f, 2f)
            arrowPath.lineTo(5f, 6f)
            arrowPath.lineTo(20f, 0f)
            arrowPath.lineTo(5f, -6f)
            arrowPath.lineTo(10f, -2f)
            arrowPath.lineTo(0f, -2f)
            arrowPath.close()
            managers.add(MilestoneManager( // display an arrow at 500m every 1km
                    MilestoneMeterDistanceLister(500.0),
                    object : MilestonePathDisplayer(0.0, true, arrowPath, backgroundPaint) {
                        override fun draw(pCanvas: Canvas, pParameter: Any?) {
                            val halfKilometers = Math.round(pParameter as Double / 500).toInt()
                            if (halfKilometers % 2 == 0) {
                                return
                            }
                            super.draw(pCanvas, pParameter)
                        }
                    }
            ))
            managers.add(MilestoneManager( // display the kilometers
                    MilestoneMeterDistanceLister(1000.0),
                    object : MilestoneDisplayer(0.0, false) {
                        override fun draw(pCanvas: Canvas, pParameter: Any) {
                            val kilometers = Math.round(pParameter as Double / 1000).toInt()
                            val text = "" + kilometers + ""
                            val rect = Rect()
                            textPaint.getTextBounds(text, 0, text.length, rect)
                            pCanvas.drawCircle(0f, 0f, backgroundRadius, backgroundPaint)
                            pCanvas.drawText(text, (-rect.left - rect.width() / 2).toFloat(), (rect.height() / 2 - rect.bottom).toFloat(), textPaint)
                            if (kilometers == 10) {
                                pCanvas.drawCircle(0f, 0f, backgroundRadius + 1, finishPaint)
                            }
                        }
                    }
            ))
            val bitmap = BitmapFactory.decodeResource(context.getResources(), org.osmdroid.library.R.drawable.next)
            managers.add(MilestoneManager( // display the start
                    MilestoneVertexLister(),
                    object : MilestoneBitmapDisplayer(0.0, true, bitmap, bitmap.width / 2, bitmap.height / 2) {
                        override fun draw(pCanvas: Canvas, pParameter: Any?) {
                            if (0 != pParameter as Int) { // we only draw the start
                                return
                            }
                            super.draw(pCanvas, pParameter)
                        }
                    }
            ))
//            managers.add(MilestoneManager(
//                    MilestoneMeterDistanceLister(10.0),
//                    object : MilestoneDisplayer(0.0, false) {
//                        override fun draw(pCanvas: Canvas, pParameter: Any) {
//                            val kilometers = Math.round(pParameter as Double / 1000).toInt()
//                            val text = "" + kilometers + ""
//                            val rect = Rect()
//                            textPaint.getTextBounds(text, 0, text.length, rect)
//                            pCanvas.drawCircle(0f, 0f, backgroundRadius, backgroundPaint)
//                            pCanvas.drawText(text, (-rect.left - rect.width() / 2).toFloat(), (rect.height() / 2 - rect.bottom).toFloat(), textPaint)
//                            if (kilometers == 10) {
//                                pCanvas.drawCircle(0f, 0f, backgroundRadius + 1, finishPaint)
//                            }
//                        }
//                    }
//
//            ))
            line.setMilestoneManagers(managers)
            line.closeInfoWindow()
            mMapView.getOverlayManager().add(line)
        }
    }
}