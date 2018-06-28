package eason.linyuzai.easonicon.painter.interceptor.canvas;

import eason.linyuzai.easonicon.open.Painter;

public abstract class ScaleYCanvasInterceptor extends ScaleCanvasInterceptor {

    @Override
    public float[] getScales(float[] scales, Painter painter, int index) {
        scales[0] = 1f;
        scales[1] = getScaleY(painter, index);
        return scales;
    }

    public abstract float getScaleY(Painter painter, int index);
}
