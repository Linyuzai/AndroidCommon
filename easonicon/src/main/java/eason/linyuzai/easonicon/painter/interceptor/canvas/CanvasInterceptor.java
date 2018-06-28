package eason.linyuzai.easonicon.painter.interceptor.canvas;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;

public abstract class CanvasInterceptor implements PainterInterceptor {
    @Override
    public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
        beforeDraw(painter, canvas, index);
    }

    @Override
    public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
        afterDraw(painter, canvas, index);
    }

    public abstract void beforeDraw(Painter painter, Canvas canvas, int index);


    public abstract void afterDraw(Painter painter, Canvas canvas, int index);
}
