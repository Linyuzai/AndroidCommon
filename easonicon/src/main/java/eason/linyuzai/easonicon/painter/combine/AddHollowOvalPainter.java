package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class AddHollowOvalPainter extends EasonPainterSet {

    public AddHollowOvalPainter() {
        this(0.5f);
    }

    public AddHollowOvalPainter(@AuxiliaryScaleField float addScale) {
        addPainter(new OvalPainter());
        Painter add = new AddPainter();
        add.setCenterPercent(addScale);
        addPainter(add);
    }
}
