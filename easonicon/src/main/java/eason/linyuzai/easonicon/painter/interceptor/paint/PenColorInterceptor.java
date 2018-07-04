package eason.linyuzai.easonicon.painter.interceptor.paint;

import android.graphics.Paint;

import eason.linyuzai.easonicon.open.Painter;

public abstract class PenColorInterceptor extends PaintInterceptor {

    private int restoreColor;

    @Override
    public void beforeDraw(Painter painter, Paint paint, int index) {
        restoreColor = paint.getColor();
        paint.setColor(getColor(painter, index, restoreColor));
    }

    @Override
    public void afterDraw(Painter painter, Paint paint, int index) {
        paint.setColor(restoreColor);
    }

    public abstract int getColor(Painter painter, int index, int original);
}
