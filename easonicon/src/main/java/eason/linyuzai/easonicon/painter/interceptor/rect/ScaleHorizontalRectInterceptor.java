package eason.linyuzai.easonicon.painter.interceptor.rect;

/**
 * 水平缩放拦截器
 */
public class ScaleHorizontalRectInterceptor extends PainterSetRectSupportInterceptor {
    public ScaleHorizontalRectInterceptor(float scale) {
        setPercentX(scale);
    }
}
