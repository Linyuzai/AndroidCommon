package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryStyleInterceptor;

public class RightArrowSolidOvalPainter extends EasonPainterSet {

    public RightArrowSolidOvalPainter(@AuxiliaryColorField int auxiliaryColor, @AuxiliaryColorField int circleColor) {
        this(0.5f, auxiliaryColor, circleColor);
    }

    public RightArrowSolidOvalPainter(@AuxiliaryScaleField float auxiliaryScale, @AuxiliaryColorField int auxiliaryColor,
                                      @AuxiliaryColorField int circleColor) {
        addPainter(new OvalPainter());
        Painter painter = new RightArrowPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
        addInterceptor(new AuxiliaryStyleInterceptor());
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor, circleColor));
    }
}
