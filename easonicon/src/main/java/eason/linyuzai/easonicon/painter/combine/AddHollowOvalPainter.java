package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class AddHollowOvalPainter extends EasonPainterSet {

    public AddHollowOvalPainter() {
        this(0.5f);
    }

    public AddHollowOvalPainter(@AuxiliaryScaleField float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new AddPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
