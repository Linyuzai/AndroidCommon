package eason.linyuzai.easonicon.painter.interceptor.canvas;

import eason.linyuzai.easonicon.open.Painter;

public abstract class ScaleXCanvasInterceptor extends ScaleCanvasInterceptor {

    @Override
    public float[] getScales(float[] scales, Painter painter, int index) {
        scales[0] = getScaleX(painter, index);
        scales[1] = 1f;
        return scales;
    }

    public abstract float getScaleX(Painter painter, int index);
}
