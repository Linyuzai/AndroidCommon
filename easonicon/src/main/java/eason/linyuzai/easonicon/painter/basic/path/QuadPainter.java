package eason.linyuzai.easonicon.painter.basic.path;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

public abstract class QuadPainter extends PathPainter {

    @Override
    public void configurePath(Path path, RectF draw, RectF original, Paint paint) {
        PointF startPoint = getCoordinate(getStartPoint(draw, paint), draw);
        PointF endPoint = getCoordinate(getEndPoint(draw, paint), draw);
        PointF controlPoint = getCoordinate(getControlPoint(draw, paint), draw);
        path.moveTo(startPoint.x, startPoint.y);
        path.quadTo(controlPoint.x, controlPoint.y, endPoint.x, endPoint.y);
    }

    public PointF getStartPoint(RectF rectF, Paint paint) {
        return new PointF(0f, 0f);
    }

    public PointF getEndPoint(RectF rectF, Paint paint) {
        return new PointF(rectF.width(), rectF.height());
    }

    public abstract PointF getControlPoint(RectF rectF, Paint paint);
}
