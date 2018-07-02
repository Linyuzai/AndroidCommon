package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class DownArrowHollowOvalPainter extends EasonPainterSet {

    public DownArrowHollowOvalPainter() {
        this(0.5f);
    }

    public DownArrowHollowOvalPainter(@AuxiliaryScaleField float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new DownArrowPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
