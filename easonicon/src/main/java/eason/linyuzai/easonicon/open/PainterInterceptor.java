package eason.linyuzai.easonicon.open;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.ex.Debugger;
import eason.linyuzai.easonicon.open.ex.SupportConverter;

/**
 * 绘制拦截器
 */
public interface PainterInterceptor extends SupportConverter, Debugger {
    /**
     * 绘制之前
     *
     * @param painter Painter
     * @param canvas  画布
     * @param paint   画笔
     * @param rectF   绘制区域
     * @param index   下标
     */
    void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index);

    /**
     * 绘制之后
     *
     * @param painter Painter
     * @param canvas  画布
     * @param paint   画笔
     * @param rectF   绘制区域
     * @param index   下标
     */
    void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index);

    default boolean isHueFiller() {
        return false;
    }
}
