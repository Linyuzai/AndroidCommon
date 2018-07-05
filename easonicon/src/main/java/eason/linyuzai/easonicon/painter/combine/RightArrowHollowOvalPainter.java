package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

@AuxiliaryScaleField
public class RightArrowHollowOvalPainter extends EasonPainterSet {

    public RightArrowHollowOvalPainter() {
        this(0.5f);
    }

    public RightArrowHollowOvalPainter(float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new RightArrowPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
