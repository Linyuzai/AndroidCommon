package eason.linyuzai.easonicon.painter.basic.path;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

public class UnlimitedQuadPainter extends QuadPainter {

    private PointF startPoint = new PointF();
    private PointF endPoint = new PointF();
    private PointF controlPoint = new PointF();

    public UnlimitedQuadPainter() {
    }

    public UnlimitedQuadPainter(float endX, float endY, float controlX, float controlY) {
        this(0f, 0f, endX, endY, controlX, controlY);
    }

    public UnlimitedQuadPainter(float startX, float startY, float endX, float endY, float controlX, float controlY) {
        setStart(startX, startY);
        setEnd(endX, endY);
        setControl(controlX, controlY);
    }

    public void setStart(float x, float y) {
        startPoint.x = x;
        startPoint.y = y;
    }

    public void setEnd(float x, float y) {
        endPoint.x = x;
        endPoint.y = y;
    }

    public void setControl(float x, float y) {
        controlPoint.x = x;
        controlPoint.y = y;
    }

    @Override
    public PointF getStartPoint(RectF rectF, Paint paint) {
        return startPoint;
    }

    @Override
    public PointF getEndPoint(RectF rectF, Paint paint) {
        return endPoint;
    }

    @Override
    public PointF getControlPoint(RectF rectF, Paint paint) {
        return controlPoint;
    }
}
