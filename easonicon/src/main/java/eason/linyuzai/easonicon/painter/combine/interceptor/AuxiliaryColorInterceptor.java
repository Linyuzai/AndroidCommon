package eason.linyuzai.easonicon.painter.combine.interceptor;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.support.AuxiliaryColorSupport;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenColorInterceptor;

public class AuxiliaryColorInterceptor extends PenColorInterceptor implements AuxiliaryColorSupport {
    private int auxiliaryColor;

    public AuxiliaryColorInterceptor(int auxiliaryColor) {
        setAuxiliaryColor(auxiliaryColor);
    }

    @Override
    public int getColor(Painter painter, int index, int original) {
        return 0 == index ? original : auxiliaryColor;
    }

    @Override
    public int getAuxiliaryColor() {
        return auxiliaryColor;
    }

    @Override
    public void setAuxiliaryColor(int auxiliaryColor) {
        this.auxiliaryColor = auxiliaryColor;
    }
}
