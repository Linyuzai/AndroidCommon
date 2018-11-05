package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.combine.filler.PenStyleHueFiller;

public class FemalePainter extends EasonPainterSet {
    public FemalePainter() {
        Painter oval = new OvalPainter();
        oval.setPercent(0.8f);
        oval.setOffsetPercentX(0.1f);
        addPainter(oval);
        Painter add = new AddPainter();
        add.setPercentX(0.4f);
        add.setPercentY(0.2f);
        add.setOffsetPercentX(0.3f);
        add.setOffsetPercentY(0.8f);
        addPainter(add);

        addInterceptor(new PenStyleHueFiller());
    }
}
