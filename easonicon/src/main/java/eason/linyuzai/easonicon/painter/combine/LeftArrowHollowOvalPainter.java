package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class LeftArrowHollowOvalPainter extends EasonPainterSet {

    public LeftArrowHollowOvalPainter() {
        this(0.5f);
    }

    public LeftArrowHollowOvalPainter(@AuxiliaryScaleField float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new LeftArrowPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
