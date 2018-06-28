package eason.linyuzai.easonicon.painter.basic.path;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

public class UnlimitedCubicPainter extends CubicPainter {

    private PointF startPoint = new PointF();
    private PointF endPoint = new PointF();
    private PointF[] controlPoint = new PointF[]{new PointF(), new PointF()};

    public UnlimitedCubicPainter() {
    }

    public UnlimitedCubicPainter(float endX, float endY, float controlX1, float controlY1, float controlX2, float controlY2) {
        this(0f, 0f, endX, endY, controlX1, controlY1, controlX2, controlY2);
    }

    public UnlimitedCubicPainter(float startX, float startY, float endX, float endY, float controlX1, float controlY1,
                                 float controlX2, float controlY2) {
        setStart(startX, startY);
        setEnd(endX, endY);
        setControl(controlX1, controlY1, controlX2, controlY2);
    }

    public void setStart(float x, float y) {
        startPoint.x = x;
        startPoint.y = y;
    }

    public void setEnd(float x, float y) {
        endPoint.x = x;
        endPoint.y = y;
    }

    public void setControl(float x1, float y1, float x2, float y2) {
        controlPoint[0].x = x1;
        controlPoint[0].y = y1;
        controlPoint[1].x = x2;
        controlPoint[1].y = y2;
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
    public PointF[] getControlPoints(RectF rectF, Paint paint) {
        return controlPoint;
    }
}
