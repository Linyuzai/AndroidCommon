package eason.linyuzai.easonicon.painter.interceptor.canvas;

import android.graphics.Canvas;
import android.graphics.PointF;

import eason.linyuzai.easonicon.open.Painter;

public abstract class TranslateCanvasInterceptor extends CanvasInterceptor {

    private float[] translations = new float[2];

    @Override
    public void beforeDraw(Painter painter, Canvas canvas, int index) {
        canvas.save();
        float[] t = getTranslations(translations, painter, index);
        canvas.translate(t[0], t[1]);
    }

    @Override
    public void afterDraw(Painter painter, Canvas canvas, int index) {
        canvas.restore();
    }

    public abstract float[] getTranslations(float[] translations, Painter painter, int index);
}
