package eason.linyuzai.easonicon.painter.interceptor.canvas;

import eason.linyuzai.easonicon.open.Painter;

public abstract class TranslateYCanvasInterceptor extends TranslateCanvasInterceptor {

    @Override
    public float[] getTranslations(float[] translations, Painter painter, int index) {
        translations[0] = 0f;
        translations[1] = getTranslationY(painter, index);
        return translations;
    }

    public abstract float getTranslationY(Painter painter, int index);
}
