package eason.linyuzai.easonicon.painter.interceptor.canvas;

import android.graphics.Canvas;
import android.graphics.PointF;

import eason.linyuzai.easonicon.open.Painter;

public abstract class ScaleCanvasInterceptor extends CanvasInterceptor {

    private PointF pivotPoint = new PointF();
    private float[] scales = new float[2];

    @Override
    public void beforeDraw(Painter painter, Canvas canvas, int index) {
        canvas.save();
        PointF pivotPoint = getPivotPoint(this.pivotPoint, painter, index);
        float[] s = getScales(scales, painter, index);
        if (pivotPoint == null) {
            canvas.scale(s[0], s[1]);
        } else {
            canvas.scale(s[0], s[1], pivotPoint.x, pivotPoint.y);
        }
    }

    @Override
    public void afterDraw(Painter painter, Canvas canvas, int index) {
        canvas.restore();
    }

    public abstract float[] getScales(float[] scales, Painter painter, int index);

    public PointF getPivotPoint(PointF pivot, Painter painter, int index) {
        return null;
    }
}
