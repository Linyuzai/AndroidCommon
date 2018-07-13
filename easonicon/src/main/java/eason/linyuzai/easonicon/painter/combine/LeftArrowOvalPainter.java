package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Color;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.support.AuxiliaryColorSupport;
import eason.linyuzai.easonicon.open.support.AuxiliaryScaleSupport;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;

@AuxiliaryScaleField
@AuxiliaryColorField
public class LeftArrowOvalPainter extends SupportEasonPainterSet implements AuxiliaryScaleSupport, AuxiliaryColorSupport {

    public LeftArrowOvalPainter() {
        this(Color.WHITE);
    }

    public LeftArrowOvalPainter(int auxiliaryColor) {
        this(0.5f, auxiliaryColor);
    }

    public LeftArrowOvalPainter(float auxiliaryScale, int auxiliaryColor) {
        addPainter(new OvalPainter());
        Painter painter = new LeftArrowPainter();
        painter.setCenterPercent(auxiliaryScale);
        setAuxiliaryScalePainter(painter);
        addPainter(painter);
        //addInterceptor(new AuxiliaryStyleInterceptor());
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor));
    }
}
