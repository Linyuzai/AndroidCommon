package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryStyleInterceptor;

public class NextSolidOvalPainter extends EasonPainterSet {

    public NextSolidOvalPainter(@AuxiliaryColorField int auxiliaryColor) {
        this(0.5f, auxiliaryColor);
    }

    public NextSolidOvalPainter(@AuxiliaryScaleField float auxiliaryScale, @AuxiliaryColorField int auxiliaryColor) {
        addPainter(new OvalPainter());
        Painter painter = new NextPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
        addInterceptor(new AuxiliaryStyleInterceptor());
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor));
    }
}