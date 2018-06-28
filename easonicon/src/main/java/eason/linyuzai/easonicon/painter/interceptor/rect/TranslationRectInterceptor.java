package eason.linyuzai.easonicon.painter.interceptor.rect;

/**
 * 绘制区域xy平移拦截器
 */
public class TranslationRectInterceptor extends PainterSetRectSupportInterceptor {
    public TranslationRectInterceptor(float percent, int offset) {
        setOffsetPercent(percent);
        setOffset(offset);
    }

    public TranslationRectInterceptor(int offset) {
        setOffset(offset);
    }

    public TranslationRectInterceptor(float percent) {
        setOffsetPercent(percent);
    }
}
