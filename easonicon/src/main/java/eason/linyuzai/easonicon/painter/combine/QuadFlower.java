package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Size;

import eason.linyuzai.easonicon.annotation.EdgeCountField;
import eason.linyuzai.easonicon.annotation.PenSizeScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.open.support.EdgeCountSupport;
import eason.linyuzai.easonicon.open.support.PenSizeScaleSupport;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.polygon.QuadPolygonPainter;
import eason.linyuzai.easonicon.painter.combine.interceptor.PenSizeScaleInterceptor;

@EdgeCountField
@PenSizeScaleField
public class QuadFlower extends SupportEasonPainterSet implements EdgeCountSupport, PenSizeScaleSupport {

    private QuadPolygonPainter polygon;

    public QuadFlower() {
        this(5);
    }

    public QuadFlower(@Size(min = 5, max = 10) int edgeCount) {
        this(edgeCount, 1f);
    }

    public QuadFlower(@Size(min = 5, max = 10) int edgeCount, float penSizeScale) {
        polygon = new QuadPolygonPainter();
        addPainter(polygon);
        setEdgeCount(edgeCount);
        addInterceptor(new QuadFlowerInterceptor());
        addInterceptor(new PenSizeScaleInterceptor(polygon, penSizeScale, 0.03f));
    }

    @Override
    public void setEdgeCount(int edgeCount) {
        if (edgeCount < 5)
            edgeCount = 5;
        if (edgeCount > 10)
            edgeCount = 10;
        super.setEdgeCount(edgeCount);
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
