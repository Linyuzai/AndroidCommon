package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Color;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.support.AuxiliaryColorSupport;
import eason.linyuzai.easonicon.open.support.AuxiliaryScaleSupport;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.combine.filler.PenColorHueFiller;
import eason.linyuzai.easonicon.painter.combine.filler.PenStyleHueFiller;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;

@AuxiliaryScaleField
@AuxiliaryColorField
public class RightArrowOvalPainter extends SupportEasonPainterSet implements AuxiliaryScaleSupport, AuxiliaryColorSupport {

    public RightArrowOvalPainter() {
        this(Color.WHITE);
    }

    public RightArrowOvalPainter(int auxiliaryColor) {
        this(0.5f, auxiliaryColor);
    }

    public RightArrowOvalPainter(float auxiliaryScale, int auxiliaryColor) {
        addPainter(new OvalPainter());
        Painter painter = new RightArrowPainter();
        painter.setCenterPercent(auxiliaryScale);
        setAuxiliaryScalePainter(painter);
        addPainter(painter);
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor));

        addInterceptor(new PenStyleHueFiller());
        addInterceptor(new PenColorHueFiller());
    }
}
