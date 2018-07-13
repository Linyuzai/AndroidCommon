package eason.linyuzai.easonicon.painter.basic.path;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

public abstract class CubicPainter extends PathPainter {

    private PointF startPoint;
    private PointF endPoint;
    private PointF[] controlPoint = new PointF[2];

    public CubicPainter() {
        this(new PointF(), new PointF());
    }

    public CubicPainter(PointF controlPoint1, PointF controlPoint2) {
        this(new PointF(), new PointF(), controlPoint1, controlPoint2);
    }

    public CubicPainter(PointF startPoint, PointF endPoint, PointF controlPoint1, PointF controlPoint2) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.controlPoint[0] = controlPoint1;
        this.controlPoint[1] = controlPoint2;
    }

    @Override
    public void configurePath(Path path, RectF draw, RectF original, Paint paint) {
        PointF startPoint = getCoordinate(this.startPoint, draw);
        PointF endPoint = getCoordinate(this.endPoint, draw);
        controlPoint[0] = getCoordinate(this.controlPoint[0], draw);
        controlPoint[1] = getCoordinate(this.controlPoint[1], draw);
        path.moveTo(startPoint.x, startPoint.y);
        path.cubicTo(controlPoint[0].x, controlPoint[0].y, controlPoint[1].x, controlPoint[1].y, endPoint.x, endPoint.y);
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

    public PointF[] getControlPoint() {
        return controlPoint;
    }

    public void setControlPoint(PointF controlPoint1, PointF controlPoint2) {
        this.controlPoint[0] = controlPoint1;
        this.controlPoint[1] = controlPoint2;
    }
}
