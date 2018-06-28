package eason.linyuzai.easonicon.painter.basic.arc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.annotation.ArcField;
import eason.linyuzai.easonicon.painter.EasonPainter;

public class ArcPainter extends EasonPainter {

    private float startAngle;
    private float sweepAngle;

    private boolean useCenter;

    public ArcPainter(@ArcField float sweepAngle) {
        this(sweepAngle, false);
    }

    public ArcPainter(@ArcField float sweepAngle, @ArcField boolean useCenter) {
        this(0f, sweepAngle, useCenter);
    }

    public ArcPainter(@ArcField float startAngle, @ArcField float sweepAngle) {
        this(startAngle, sweepAngle, false);
    }

    public ArcPainter(@ArcField float startAngle, @ArcField float sweepAngle, @ArcField boolean useCenter) {
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
        this.useCenter = useCenter;
    }

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        canvas.drawArc(getTransformRectF(draw, paint), startAngle, sweepAngle, useCenter, paint);
    }

    public float getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
    }

    public float getSweepAngle() {
        return sweepAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
    }

    public boolean isUseCenter() {
        return useCenter;
    }

    public void setUseCenter(boolean useCenter) {
        this.useCenter = useCenter;
    }
}
