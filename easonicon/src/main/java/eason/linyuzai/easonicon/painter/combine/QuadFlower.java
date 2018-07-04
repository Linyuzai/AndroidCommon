package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.polygon.QuadPolygonPainter;

public class QuadFlower extends EasonPainterSet {

    private QuadPolygonPainter polygon;

    public QuadFlower() {
        this(6);
    }

    public QuadFlower(int edgeCount) {
        polygon = new QuadPolygonPainter();
        setEdgeCount(edgeCount);
        addPainter(polygon);
        addInterceptor(new QuadFlowerInterceptor());
    }

    public int getEdgeCount() {
        return polygon.getEdgeCount();
    }

    public void setEdgeCount(int edgeCount) {
        if (edgeCount < 6)
            edgeCount = 6;
        if (edgeCount > 10)
            edgeCount = 10;
        polygon.setEdgeCount(edgeCount);
    }

    public float getExtraOffsetRate(int edgeCount) {
        switch (edgeCount) {
            case 5:
                return 0.76f;
            case 6:
                return 0.78f;
            case 7:
                return 0.81f;
            case 8:
                return 0.84f;
            case 9:
                return 0.87f;
            case 10:
                return 0.89f;
        }
        return 0f;
    }

    private class QuadFlowerInterceptor implements PainterInterceptor {

        @Override
        public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            if (painter instanceof QuadPolygonPainter) {
                float size = Math.min(rectF.width(), rectF.height());
                polygon.setExtraOffset(-1f * getExtraOffsetRate(polygon.getEdgeCount()) * size);
            }
        }

        @Override
        public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {

        }
    }
}
