package eason.linyuzai.easonicon.painter.interceptor.rect;

/**
 * 竖直缩放拦截器
 */
public class ScaleVerticalRectInterceptor extends PainterSetRectSupportInterceptor {
    public ScaleVerticalRectInterceptor(float scale) {
        setPercentY(scale);
    }
}
