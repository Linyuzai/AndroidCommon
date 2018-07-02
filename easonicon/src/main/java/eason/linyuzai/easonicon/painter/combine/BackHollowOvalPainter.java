package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class BackHollowOvalPainter extends EasonPainterSet {

    public BackHollowOvalPainter() {
        this(0.5f);
    }

    public BackHollowOvalPainter(@AuxiliaryScaleField float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new BackPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
