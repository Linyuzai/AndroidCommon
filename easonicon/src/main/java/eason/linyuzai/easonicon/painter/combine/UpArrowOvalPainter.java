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
public class UpArrowOvalPainter extends SupportEasonPainterSet implements AuxiliaryScaleSupport, AuxiliaryColorSupport {

    public UpArrowOvalPainter() {
        this(Color.WHITE);
    }

    public UpArrowOvalPainter(int auxiliaryColor) {
        this(0.5f, auxiliaryColor);
    }

    public UpArrowOvalPainter(float auxiliaryScale, int auxiliaryColor) {
        addPainter(new OvalPainter());
        Painter painter = new UpArrowPainter();
        painter.setCenterPercent(auxiliaryScale);
        setAuxiliaryScalePainter(painter);
        addPainter(painter);
        //addInterceptor(new AuxiliaryStyleInterceptor());
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor));
    }
}
