package eason.linyuzai.easonicon.painter.interceptor.paint;

import android.graphics.Paint;

import eason.linyuzai.easonicon.open.Painter;

public abstract class PenCapInterceptor extends PaintInterceptor {

    private Paint.Cap restoreCap;

    @Override
    public void beforeDraw(Painter painter, Paint paint, int index) {
        restoreCap = paint.getStrokeCap();
        paint.setStrokeCap(getCap(painter, index));
    }

    @Override
    public void afterDraw(Painter painter, Paint paint, int index) {
        paint.setStrokeCap(restoreCap);
    }

    public abstract Paint.Cap getCap(Painter painter, int index);
}
