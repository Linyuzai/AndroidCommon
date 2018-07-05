package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

@AuxiliaryScaleField
public class UpArrowHollowOvalPainter extends EasonPainterSet {

    public UpArrowHollowOvalPainter() {
        this(0.5f);
    }

    public UpArrowHollowOvalPainter(float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new UpArrowPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
