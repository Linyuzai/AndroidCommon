package eason.linyuzai.easonicon.painter.basic.circle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class CirclePainter extends OvalPainter {

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        RectF t = getRectF(draw);
        float radius = Math.min(t.width(), t.height()) * 0.5f;
        float ex = paint.getStrokeWidth() * 0.5f;
        canvas.drawCircle(t.centerX(), t.centerY(), radius - ex, paint);
    }
}
