package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class CollapseHollowOvalPainter extends EasonPainterSet {

    public CollapseHollowOvalPainter() {
        this(0.5f);
    }

    public CollapseHollowOvalPainter(@AuxiliaryScaleField float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new CollapsePainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
