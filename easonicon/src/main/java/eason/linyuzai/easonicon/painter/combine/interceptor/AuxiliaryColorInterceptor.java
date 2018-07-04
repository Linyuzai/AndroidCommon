package eason.linyuzai.easonicon.painter.combine.interceptor;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenColorInterceptor;

public class AuxiliaryColorInterceptor extends PenColorInterceptor {
    private int auxiliaryColor;

    public AuxiliaryColorInterceptor(int auxiliaryColor) {
        this.auxiliaryColor = auxiliaryColor;
    }

    @Override
    public int getColor(Painter painter, int index, int original) {
        return 0 == index ? original : auxiliaryColor;
    }
}
