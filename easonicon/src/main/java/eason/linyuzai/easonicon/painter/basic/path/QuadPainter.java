package eason.linyuzai.easonicon.painter.basic.path;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

public abstract class QuadPainter extends PathPainter {

    private PointF startPoint;
    private PointF endPoint;
    private PointF controlPoint;

    public QuadPainter() {
        this(new PointF());
    }

    public QuadPainter(PointF controlPoint) {
        this(new PointF(), new PointF(), controlPoint);
    }

    public QuadPainter(PointF startPoint, PointF endPoint, PointF controlPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.controlPoint = controlPoint;
    }

    @Override
    public void configurePath(Path path, RectF draw, RectF original, Paint paint) {
        PointF startPoint = getCoordinate(this.startPoint, draw);
        PointF endPoint = getCoordinate(this.endPoint, draw);
        PointF controlPoint = getCoordinate(this.controlPoint, draw);
        path.moveTo(startPoint.x, startPoint.y);
        path.quadTo(controlPoint.x, controlPoint.y, endPoint.x, endPoint.y);
    }

    public PointF getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(PointF startPoint) {
        this.startPoint = startPoint;
    }

    public PointF getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(PointF endPoint) {
        this.endPoint = endPoint;
    }

    public PointF getControlPoint() {
        return controlPoint;
    }

    public void setControlPoint(PointF controlPoint) {
        this.controlPoint = controlPoint;
    }
}
