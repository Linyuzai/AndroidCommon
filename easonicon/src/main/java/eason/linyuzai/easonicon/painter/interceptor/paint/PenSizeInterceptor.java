package eason.linyuzai.easonicon.painter.interceptor.paint;

import android.graphics.Paint;

import eason.linyuzai.easonicon.open.Painter;

public abstract class PenSizeInterceptor extends PaintInterceptor {

    private float restorePenSize;

    @Override
    public void beforeDraw(Painter painter, Paint paint, int index) {
        restorePenSize = paint.getStrokeWidth();
        paint.setStrokeWidth(getPenSize(painter, index));
    }

    @Override
    public void afterDraw(Painter painter, Paint paint, int index) {
        paint.setStrokeWidth(restorePenSize);
    }

    public abstract float getPenSize(Painter painter, int index);
}
