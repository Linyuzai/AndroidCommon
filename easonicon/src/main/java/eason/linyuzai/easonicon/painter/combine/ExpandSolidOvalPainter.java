package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryStyleInterceptor;

public class ExpandSolidOvalPainter extends EasonPainterSet {

    public ExpandSolidOvalPainter(@AuxiliaryColorField int auxiliaryColor) {
        this(0.5f, auxiliaryColor);
    }

    public ExpandSolidOvalPainter(@AuxiliaryScaleField float auxiliaryScale, @AuxiliaryColorField int auxiliaryColor) {
        addPainter(new OvalPainter());
        Painter painter = new ExpandPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
        addInterceptor(new AuxiliaryStyleInterceptor());
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor));
    }
}
