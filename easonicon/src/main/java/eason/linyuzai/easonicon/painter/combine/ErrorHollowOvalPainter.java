package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class ErrorHollowOvalPainter extends EasonPainterSet {

    public ErrorHollowOvalPainter() {
        this(0.5f);
    }

    public ErrorHollowOvalPainter(@AuxiliaryScaleField float auxiliaryScale) {
        addPainter(new OvalPainter());
        Painter painter = new ErrorPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
