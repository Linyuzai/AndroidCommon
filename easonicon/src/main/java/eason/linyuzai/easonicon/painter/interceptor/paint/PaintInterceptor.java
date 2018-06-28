package eason.linyuzai.easonicon.painter.interceptor.paint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;

public abstract class PaintInterceptor implements PainterInterceptor {
    @Override
    public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
        beforeDraw(painter, paint, index);
    }

    @Override
    public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
        afterDraw(painter, paint, index);
    }

    public abstract void beforeDraw(Painter painter, Paint paint, int index);

    public abstract void afterDraw(Painter painter, Paint paint, int index);
}
