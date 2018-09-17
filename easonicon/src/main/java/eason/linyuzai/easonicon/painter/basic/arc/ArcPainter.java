package eason.linyuzai.easonicon.painter.basic.arc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.annotation.ArcField;
import eason.linyuzai.easonicon.open.support.ArcSupport;
import eason.linyuzai.easonicon.painter.EasonPainter;

@ArcField
public class ArcPainter extends EasonPainter implements ArcSupport {

    private float startAngle;
    private float sweepAngle;

    private boolean useCenter;

    public ArcPainter(float sweepAngle) {
        this(sweepAngle, false);
    }

    public ArcPainter(float sweepAngle, boolean useCenter) {
        this(0f, sweepAngle, useCenter);
    }

    public ArcPainter(float startAngle, float sweepAngle) {
        this(startAngle, sweepAngle, false);
    }

    public ArcPainter(float startAngle, float sweepAngle, boolean useCenter) {
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
        this.useCenter = useCenter;
    }

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        canvas.drawArc(getRectF(draw, paint), startAngle, sweepAngle, useCenter, paint);
    }

    @Override
    public float getStartAngle() {
        return startAngle;
    }

    @Override
    public void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
    }

    @Override
    public float getSweepAngle() {
        return sweepAngle;
    }

    @Override
    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
    }

    @Override
    public boolean isUseCenter() {
        return useCenter;
    }

    @Override
    public void setUseCenter(boolean useCenter) {
        this.useCenter = useCenter;
    }
}
