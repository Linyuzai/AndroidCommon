package eason.linyuzai.easonicon.painter.basic.point;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

import eason.linyuzai.easonicon.painter.EasonPainter;

public class PointPainter extends EasonPainter {

    private PointF pointF = new PointF();

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        PointF p = getCoordinate(pointF, draw);
        canvas.drawPoint(p.x, p.y, paint);
    }
}
