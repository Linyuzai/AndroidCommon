package eason.linyuzai.easonicon.painter.combine.interceptor;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenColorInterceptor;

public class AuxiliaryColorInterceptor extends PenColorInterceptor {
    private int auxiliaryColor;
    private int circleColor;

    public AuxiliaryColorInterceptor(int auxiliaryColor, int circleColor) {
        this.auxiliaryColor = auxiliaryColor;
        this.circleColor = circleColor;
    }

    @Override
    public int getColor(Painter painter, int index) {
        return 0 == index ? circleColor : auxiliaryColor;
    }
}
