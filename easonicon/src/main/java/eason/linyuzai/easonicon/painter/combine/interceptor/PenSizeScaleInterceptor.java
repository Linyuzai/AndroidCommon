package eason.linyuzai.easonicon.painter.combine.interceptor;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.open.support.PenSizeScaleSupport;

public class PenSizeScaleInterceptor implements PainterInterceptor, PenSizeScaleSupport {

    private Painter painter;
    private float restorePenSize;
    private float penSizeScale;

    private float scale;

    public PenSizeScaleInterceptor(Painter painter, float penSizeScale, float scale) {
        this.painter = painter;
        this.penSizeScale = penSizeScale;
        this.scale = scale;
    }

    @Override
    public float getPenSizeScale() {
        return penSizeScale;
    }

    @Override
    public void setPenSizeScale(float penSizeScale) {
        this.penSizeScale = penSizeScale;
    }

    @Override
    public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
        if (this.painter == painter) {
            float size = Math.min(rectF.width(), rectF.height());
            restorePenSize = paint.getStrokeWidth();
            paint.setStrokeWidth(size * scale * penSizeScale);
        }
    }

    @Override
    public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
        if (this.painter == painter) {
            paint.setStrokeWidth(restorePenSize);
        }
    }
}
