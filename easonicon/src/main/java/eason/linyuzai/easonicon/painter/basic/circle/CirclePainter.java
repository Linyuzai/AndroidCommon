package eason.linyuzai.easonicon.painter.basic.circle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class CirclePainter extends OvalPainter {

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        RectF t = getRectF(draw, paint);
        float min = Math.min(t.width(), t.height());
        t.right = t.left + min;
        t.bottom = t.top + min;
        float radius = min * 0.5f;
        //float ex = paint.getStrokeWidth() * 0.5f;
        canvas.drawCircle(t.centerX(), t.centerY(), radius, paint);
    }
}
