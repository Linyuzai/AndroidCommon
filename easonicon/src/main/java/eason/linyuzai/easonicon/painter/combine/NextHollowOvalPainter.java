package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class NextHollowOvalPainter extends EasonPainterSet {

    public NextHollowOvalPainter() {
        this(0.5f);
    }

    public NextHollowOvalPainter(@AuxiliaryScaleField float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new NextPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
