package eason.linyuzai.easonicon.painter.interceptor.paint;

import android.graphics.Paint;

import eason.linyuzai.easonicon.open.Painter;

public abstract class PenStyleInterceptor extends PaintInterceptor {

    private Paint.Style restoreStyle;

    @Override
    public void beforeDraw(Painter painter, Paint paint, int index) {
        restoreStyle = paint.getStyle();
        paint.setStyle(getStyle(painter, index, restoreStyle));
    }

    @Override
    public void afterDraw(Painter painter, Paint paint, int index) {
        paint.setStyle(restoreStyle);
    }

    public abstract Paint.Style getStyle(Painter painter, int index, Paint.Style original);
}
