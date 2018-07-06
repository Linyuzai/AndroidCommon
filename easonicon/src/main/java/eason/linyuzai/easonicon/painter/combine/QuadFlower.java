package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Size;

import eason.linyuzai.easonicon.annotation.EdgeCountField;
import eason.linyuzai.easonicon.annotation.PenSizeScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.polygon.QuadPolygonPainter;

@EdgeCountField
@PenSizeScaleField
public class QuadFlower extends EasonPainterSet {

    private QuadPolygonPainter polygon;

    private float penSizeScale = 1f;

    public QuadFlower(@Size(min = 5, max = 10) int edgeCount) {
        this(edgeCount, 1f);
    }

    public QuadFlower(@Size(min = 5, max = 10) int edgeCount, float penSizeScale) {
        polygon = new QuadPolygonPainter();
        setEdgeCount(edgeCount);
        setPenSizeScale(penSizeScale);
        addPainter(polygon);
        addInterceptor(new QuadFlowerInterceptor());
    }

    public int getEdgeCount() {
        return polygon.getEdgeCount();
    }

    public void setEdgeCount(int edgeCount) {
        if (edgeCount < 5)
            edgeCount = 5;
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

    public float getPenSizeScale() {
        return penSizeScale;
    }

    public void setPenSizeScale(float penSizeScale) {
        this.penSizeScale = penSizeScale;
    }

    private class QuadFlowerInterceptor implements PainterInterceptor {

        private float penSize;

        @Override
        public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            if (painter instanceof QuadPolygonPainter) {
                float size = Math.min(rectF.width(), rectF.height());
                polygon.setExtraOffset(-1f * getExtraOffsetRate(polygon.getEdgeCount()) * size);
                penSize = paint.getStrokeWidth();
                paint.setStrokeWidth(Math.min(rectF.width(), rectF.height()) * 0.03f * getPenSizeScale());
            }
        }

        @Override
        public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            if (painter instanceof QuadPolygonPainter) {
                paint.setStrokeWidth(penSize);
            }
        }
    }
}
