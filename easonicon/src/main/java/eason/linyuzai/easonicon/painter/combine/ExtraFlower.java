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
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.polygon.ExtraPolygonPainter;

@EdgeCountField
@PenSizeScaleField
public class ExtraFlower extends SupportEasonPainterSet implements EdgeCountSupport {

    private ExtraPolygonPainter polygon;

    private float penSizeScale;

    public ExtraFlower(@Size(min = 4) int edgeCount) {
        this(edgeCount, 1f);
    }

    public ExtraFlower(@Size(min = 4) int edgeCount, float penSizeScale) {
        polygon = new ExtraPolygonPainter();
        setEdgeCount(edgeCount);
        setPenSizeScale(penSizeScale);
        addPainter(polygon);
        addInterceptor(new ExtraFlowerInterceptor());
    }

    @Override
    public void setEdgeCount(int edgeCount) {
        if (edgeCount < 4)
            edgeCount = 4;
        super.setEdgeCount(edgeCount);
    }

    public void setPenSizeScale(float penSizeScale) {
        this.penSizeScale = penSizeScale;
    }

    public float getPenSizeScale() {
        return penSizeScale;
    }

    private class ExtraFlowerInterceptor implements PainterInterceptor {

        private float penSize;

        @Override
        public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            if (painter instanceof ExtraPolygonPainter) {
                float size = Math.min(rectF.width(), rectF.height());
                polygon.setExtraOffset(-0.78f * size);
                penSize = paint.getStrokeWidth();
                paint.setStrokeWidth(Math.min(rectF.width(), rectF.height()) * 0.01f * getPenSizeScale());
            }
        }

        @Override
        public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            if (painter instanceof ExtraPolygonPainter) {
                paint.setStrokeWidth(penSize);
            }
        }
    }
}
