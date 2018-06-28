package eason.linyuzai.easonicon.painter.interceptor.paint;

import android.graphics.Paint;
import android.graphics.PathEffect;

import eason.linyuzai.easonicon.open.Painter;

public abstract class PathEffectInterceptor extends PaintInterceptor {

    private PathEffect restoreEffect;

    @Override
    public void beforeDraw(Painter painter, Paint paint, int index) {
        restoreEffect = paint.getPathEffect();
        paint.setPathEffect(getPathEffect(painter, index));
    }

    @Override
    public void afterDraw(Painter painter, Paint paint, int index) {
        paint.setPathEffect(restoreEffect);
    }

    public abstract PathEffect getPathEffect(Painter painter, int index);
}
