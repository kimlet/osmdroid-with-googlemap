package com.topgether.sixfoot.osmdroid.tile;

import android.content.Context;

import org.osmdroid.tileprovider.IRegisterReceiver;
import org.osmdroid.tileprovider.MapTileCache;
import org.osmdroid.tileprovider.MapTileProviderArray;
import org.osmdroid.tileprovider.MapTileProviderBasic;
import org.osmdroid.tileprovider.modules.IFilesystemCache;
import org.osmdroid.tileprovider.modules.MapTileDownloader;
import org.osmdroid.tileprovider.modules.MapTileModuleProviderBase;
import org.osmdroid.tileprovider.modules.NetworkAvailabliltyCheck;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.tileprovider.util.SimpleRegisterReceiver;

/**
 * Created by kim on 26/04/2018.
 */

public class SixfootFileMapTileProvider extends MapTileProviderArray {

    private IFilesystemCache tileWriter;

    /**
     * Creates a {@link MapTileProviderBasic}.
     */
    public SixfootFileMapTileProvider(final Context pContext, final ITileSource pTileSource) {
        this(pContext, pTileSource, new SimpleRegisterReceiver(pContext));
    }


    protected SixfootFileMapTileProvider(final Context pContext, ITileSource pTileSource, IRegisterReceiver pRegisterReceiver) {
        super(pTileSource, pRegisterReceiver);
        tileWriter = new SixfootTileWriter();
        final SixfootMapTileFilesystemProvider filesystemProvider = new SixfootMapTileFilesystemProvider(pRegisterReceiver, pTileSource);

        final MapTileDownloader downloaderProvider = new MapTileDownloader(pTileSource, tileWriter, new NetworkAvailabliltyCheck(pContext));
        mTileProviderList.add(filesystemProvider);
        mTileProviderList.add(downloaderProvider);
    }

    public SixfootFileMapTileProvider(ITileSource pTileSource, IRegisterReceiver aRegisterReceiver, MapTileModuleProviderBase[] pTileProviderArray) {
        super(pTileSource, aRegisterReceiver, pTileProviderArray);
    }

    @Override
    public IFilesystemCache getTileWriter() {
        return tileWriter;
    }

    @Override
    public MapTileCache getTileCache() {
        return super.getTileCache();
    }
}
