package eason.linyuzai.easonicon.painter.basic.path;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

public abstract class CubicPainter extends PathPainter {

    @Override
    public void configurePath(Path path, RectF draw, RectF original, Paint paint) {
        PointF startPoint = getCoordinate(getStartPoint(draw, paint), draw);
        PointF endPoint = getCoordinate(getEndPoint(draw, paint), draw);
        PointF[] controlPoint = getControlPoints(draw, paint);
        controlPoint[0] = getCoordinate(controlPoint[0], draw);
        controlPoint[1] = getCoordinate(controlPoint[1], draw);
        path.moveTo(startPoint.x, startPoint.y);
        path.cubicTo(controlPoint[0].x, controlPoint[0].y, controlPoint[1].x, controlPoint[1].y, endPoint.x, endPoint.y);
    }

    public PointF getStartPoint(RectF rectF, Paint paint) {
        return new PointF(0f, 0f);
    }

    public PointF getEndPoint(RectF rectF, Paint paint) {
        return new PointF(rectF.width(), rectF.height());
    }

    public abstract PointF[] getControlPoints(RectF rectF, Paint paint);
}
