package eason.linyuzai.easonicon.painter.interceptor.canvas;

import android.graphics.Canvas;
import android.graphics.PointF;

import eason.linyuzai.easonicon.open.Painter;

public abstract class RotateCanvasInterceptor extends CanvasInterceptor {

    private PointF pivotPoint = new PointF();

    @Override
    public void beforeDraw(Painter painter, Canvas canvas, int index) {
        canvas.save();
        PointF pivotPoint = getPivotPoint(this.pivotPoint, painter, index);
        if (pivotPoint == null) {
            canvas.rotate(getDegrees(painter, index));
        } else {
            canvas.rotate(getDegrees(painter, index), pivotPoint.x, pivotPoint.y);
        }
    }

    @Override
    public void afterDraw(Painter painter, Canvas canvas, int index) {
        canvas.restore();
    }

    public abstract float getDegrees(Painter painter, int index);

    public PointF getPivotPoint(PointF pivot, Painter painter, int index) {
        return null;
    }
}
