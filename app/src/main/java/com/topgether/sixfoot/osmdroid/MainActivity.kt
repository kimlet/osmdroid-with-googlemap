package com.topgether.sixfoot.osmdroid

import android.os.Bundle
import android.os.Environment
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.topgether.sixfoot.osmdroid.overlays.GrayOverlay
import com.topgether.sixfoot.osmdroid.overlays.PhotoMarker
import com.topgether.sixfoot.osmdroid.tile.SixfootFileMapTileProvider
import com.topgether.sixfoot.osmdroid.tile.SixfootTileSource
import kotlinx.android.synthetic.main.activity_main.*
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Marker
import java.io.File

class MainActivity : AppCompatActivity() {


    val googleMap: OnlineTileSourceBase = SixfootTileSource(
            "googlemap",
            0,
            19,
            512,
            ".png",
            arrayOf("http://mt2.google.cn/vt/"),
            "Sixfoot"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //handle permissions first, before map is created. not depicted here

        //load/initialize the osmdroid configuration, this can be done
        val ctx = applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        //setting this before the layout is inflated is a good idea
        //it 'should' ensure that the map has a writable location for the map cache, even without permissions
        //if no tiles are displayed, you can try overriding the cache path using Configuration.getInstance().setCachePath
        //see also StorageUtils
        //note, the load method also sets the HTTP User Agent to your application's package name, abusing osm's tile servers will get you banned based on this string

        //inflate and create the map
        setContentView(R.layout.activity_main)


        Configuration.getInstance().osmdroidTileCache = File(mainFolder)

        map.setMultiTouchControls(true)
        map.tileProvider = SixfootFileMapTileProvider(this, googleMap)
        map.setTileSource(googleMap)
        map.overlayManager.add(GrayOverlay())

        addMarker()
    }

    private fun addMarker() {
        val startMarker = PhotoMarker(map)
        startMarker.position = GeoPoint(48.85792514768071, 2.342640914879439)

        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        startMarker.setIcon(resources.getDrawable(R.mipmap.ic_launcher))
        startMarker.title = "title"
        startMarker.snippet = "snippet"
        startMarker.subDescription = "description"

        map.overlays.add(startMarker)

    }


    fun onClick10km(view: View) {
        OverlayUtils.render10km(map, this)
    }

    public override fun onResume() {
        super.onResume()
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        map.onResume() //needed for compass, my location overlays, v6.0.0 and up
    }

    public override fun onPause() {
        super.onPause()
        map.onPause()
    }

    companion object {

        private val MAIN_FOLDER_NAME = "6foots"
        private var mainFile: File? = null

        val mainFolder: String
            get() {
                if (null == mainFile) {
                    val extStore = Environment.getExternalStorageDirectory()
                    val path = extStore.absolutePath + File.separator + MAIN_FOLDER_NAME
                    mainFile = File(path)
                    if (!mainFile!!.exists())
                        mainFile!!.mkdirs()
                }
                return mainFile!!.absolutePath
            }
    }
}
