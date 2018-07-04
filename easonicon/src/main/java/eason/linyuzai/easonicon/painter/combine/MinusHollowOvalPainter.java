package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class MinusHollowOvalPainter extends EasonPainterSet {

    public MinusHollowOvalPainter() {
        this(0.5f);
    }

    public MinusHollowOvalPainter(@AuxiliaryScaleField float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new MinusPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
