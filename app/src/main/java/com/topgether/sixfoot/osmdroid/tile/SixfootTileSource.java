package com.topgether.sixfoot.osmdroid.tile;

import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.util.MapTileIndex;

/**
 * Created by kim on 26/04/2018.
 */

public class SixfootTileSource extends OnlineTileSourceBase {
    public SixfootTileSource(String aName, int aZoomMinLevel, int aZoomMaxLevel, int aTileSizePixels, String aImageFilenameEnding, String[] aBaseUrl) {
        super(aName, aZoomMinLevel, aZoomMaxLevel, aTileSizePixels, aImageFilenameEnding, aBaseUrl);
    }

    public SixfootTileSource(String aName, int aZoomMinLevel, int aZoomMaxLevel, int aTileSizePixels, String aImageFilenameEnding, String[] aBaseUrl, String copyyright) {
        super(aName, aZoomMinLevel, aZoomMaxLevel, aTileSizePixels, aImageFilenameEnding, aBaseUrl, copyyright);
    }

    private static final String strGalileo = new String("Galileo");

    @Override
    public String getTileURLString(final long pMapTileIndex) {
        int x = MapTileIndex.getX(pMapTileIndex);
        int y = MapTileIndex.getY(pMapTileIndex);
        String url = new StringBuilder()
                .append(getBaseUrl())
                .append("&src=app&x=")
                .append(x)
                .append("&y=")
                .append(y)
                .append("&z=")
                .append(MapTileIndex.getZoom(pMapTileIndex))
                .append("&scale=")
                .append(2)
                .append("&gl=cn")
                .append("&hl=zh-CN")
                .append("&s=")
                .append(strGalileo.substring(0, (x * 3 + y) % 8))
                .toString();
//        return getBaseUrl() + MapTileIndex.getZoom(pMapTileIndex) + "/" + MapTileIndex.getX(pMapTileIndex) + "/" + MapTileIndex.getY(pMapTileIndex)
//                + mImageFilenameEnding;
        return url;
    }
}
