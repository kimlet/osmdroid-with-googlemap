package com.topgether.sixfoot.osmdroid.overlays;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;

import org.osmdroid.util.LineBuilder;
import org.osmdroid.util.PointL;

import java.util.List;

/**
 * Created by kim on 2018/7/4.
 */
public class ColorLineDrawer extends LineBuilder {
    private Paint mPaint;
    private Canvas mCanvas;


    private List<Path> pathList;
    private List<Integer> colorList;
    private List<List<PointL>> startEndPoints;

    public ColorLineDrawer(int pMaxSize) {
        super(pMaxSize);
    }

    public void setPaint(Paint mPaint) {
        this.mPaint = mPaint;
    }

    public void setCanvas(Canvas mCanvas) {
        this.mCanvas = mCanvas;
    }

    public void setPathList(List<Path> pathList) {
        this.pathList = pathList;
    }

    public void setColorList(List<Integer> colorList) {
        this.colorList = colorList;
    }

    public void setStartEndPoints(List<List<PointL>> startEndPoints) {
        this.startEndPoints = startEndPoints;
    }

    @Override
    public void flush() {
        if (null != pathList && null != colorList) {
            for (int i = 0; i < pathList.size(); i++) {
                PointL pStart = startEndPoints.get(i).get(0);
                PointL pEnd = startEndPoints.get(i).get(1);

                int colorStart = colorList.get(i >= colorList.size() ? 0 : i);
                int colorEnd = colorList.get(i + 1 >= colorList.size() - 1 ? colorList.size() - 1 : i + 1);
                mPaint.setShader(new LinearGradient(pStart.x, pStart.y, pEnd.x, pEnd.y, colorStart, colorEnd, Shader.TileMode.CLAMP));

                mCanvas.drawPath(pathList.get(i), mPaint);
            }
        }
//        if (getSize() >= 4) {
//            mCanvas.drawLines(getLines(), 0, getSize(), mPaint);
//        }
    }
}
