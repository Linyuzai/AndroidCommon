package eason.linyuzai.easonicon.painter.interceptor.rect;

/**
 * 绘制区域竖直平移拦截器
 */
public class TranslationVerticalRectInterceptor extends PainterSetRectSupportInterceptor {
    public TranslationVerticalRectInterceptor(float percent, int offset) {
        setOffsetPercentY(percent);
        setOffsetY(offset);
    }

    public TranslationVerticalRectInterceptor(int offset) {
        setOffsetY(offset);
    }

    public TranslationVerticalRectInterceptor(float percent) {
        setOffsetPercentY(percent);
    }
}
