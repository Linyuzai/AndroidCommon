package eason.linyuzai.easonicon.painter.interceptor.rect;

/**
 * 缩放并居中绘制区域拦截器
 */
public class ScaleCenterRectInterceptor extends PainterSetRectSupportInterceptor {
    public ScaleCenterRectInterceptor(float scale) {
        setCenterPercent(scale);
    }
}
