package eason.linyuzai.easonicon.open;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;

/**
 * 绘制拦截器
 */
public interface PainterInterceptor {
    int a = 1;
    /**
     * 绘制之前
     *
     * @param painter Painter
     * @param canvas  Canvas
     * @param paint   Paint
     * @param rectF   RectF
     */
    void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index);

    /**
     * 绘制之后
     *
     * @param painter Painter
     * @param canvas  Canvas
     * @param paint   Paint
     * @param rectF   RectF
     */
    void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index);
}
