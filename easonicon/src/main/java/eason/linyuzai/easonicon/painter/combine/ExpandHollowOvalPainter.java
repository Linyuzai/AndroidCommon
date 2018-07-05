package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

@AuxiliaryScaleField
public class ExpandHollowOvalPainter extends EasonPainterSet {

    public ExpandHollowOvalPainter() {
        this(0.5f);
    }

    public ExpandHollowOvalPainter(float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new ExpandPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
