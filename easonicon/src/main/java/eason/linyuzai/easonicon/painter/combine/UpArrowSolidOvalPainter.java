package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.support.AuxiliaryColorSupport;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryStyleInterceptor;

@AuxiliaryScaleField
@AuxiliaryColorField
public class UpArrowSolidOvalPainter extends SupportEasonPainterSet implements AuxiliaryColorSupport{

    public UpArrowSolidOvalPainter(int auxiliaryColor) {
        this(0.5f, auxiliaryColor);
    }

    public UpArrowSolidOvalPainter(float auxiliaryScale, int auxiliaryColor) {
        addPainter(new OvalPainter());
        Painter painter = new RightArrowPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
        addInterceptor(new AuxiliaryStyleInterceptor());
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor));
    }
}
