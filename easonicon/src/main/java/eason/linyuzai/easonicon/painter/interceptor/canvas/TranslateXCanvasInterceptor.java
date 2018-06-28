package eason.linyuzai.easonicon.painter.interceptor.canvas;

import eason.linyuzai.easonicon.open.Painter;

public abstract class TranslateXCanvasInterceptor extends TranslateCanvasInterceptor {

    @Override
    public float[] getTranslations(float[] translations, Painter painter, int index) {
        translations[0] = getTranslationX(painter, index);
        translations[1] = 0f;
        return translations;
    }

    public abstract float getTranslationX(Painter painter, int index);
}
