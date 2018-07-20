package eason.linyuzai.easonicon.painter.interceptor.rect;

import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;

/**
 * 绘制区域适配拦截器
 */
public abstract class RectAdapterInterceptor extends PainterSetRectSupportInterceptor {

    @Override
    public void beforeDraw(Painter painter, RectF rectF, int index) {
        saveRect(rectF);
        if (setRect(painter, rectF, index))
            return;
        changeRect(rectF);
    }

    /**
     * 设置RectF
     *
     * @param painter Painter
     * @param rectF   RectF
     * @param index   下标
     * @return 是否拦截 changeRect
     * @see RectAdapterInterceptor#changeRect(RectF)
     */
    public abstract boolean setRect(Painter painter, RectF rectF, int index);
}
