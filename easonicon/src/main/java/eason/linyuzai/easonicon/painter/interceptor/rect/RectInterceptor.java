package eason.linyuzai.easonicon.painter.interceptor.rect;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;

/**
 * 绘制区域拦截器
 */
public abstract class RectInterceptor implements PainterInterceptor {

    @Override
    public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
        beforeDraw(painter, rectF, index);
    }

    @Override
    public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
        afterDraw(painter, rectF, index);
    }

    public abstract void beforeDraw(Painter painter, RectF rectF, int index);

    public abstract void afterDraw(Painter painter, RectF rectF, int index);
}
