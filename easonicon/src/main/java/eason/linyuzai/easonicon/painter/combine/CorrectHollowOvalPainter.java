package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class CorrectHollowOvalPainter extends EasonPainterSet {

    public CorrectHollowOvalPainter() {
        this(0.5f);
    }

    public CorrectHollowOvalPainter(@AuxiliaryScaleField float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new CorrectPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
