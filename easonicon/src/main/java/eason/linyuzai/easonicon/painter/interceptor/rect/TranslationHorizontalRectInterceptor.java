package eason.linyuzai.easonicon.painter.interceptor.rect;

/**
 * 绘制区域水平平移拦截器
 */
public class TranslationHorizontalRectInterceptor extends PainterSetRectSupportInterceptor {
    public TranslationHorizontalRectInterceptor(float percent, int offset) {
        setOffsetPercentX(percent);
        setOffsetX(offset);
    }

    public TranslationHorizontalRectInterceptor(int offset) {
        setOffsetX(offset);
    }

    public TranslationHorizontalRectInterceptor(float percent) {
        setOffsetPercentX(percent);
    }
}
