package eason.linyuzai.easonicon.painter.interceptor.rect;

/**
 * 缩放绘制区域拦截器
 */
public class ScaleRectInterceptor extends PainterSetRectSupportInterceptor {

    public ScaleRectInterceptor(float scale) {
        setPercent(scale);
    }
}
