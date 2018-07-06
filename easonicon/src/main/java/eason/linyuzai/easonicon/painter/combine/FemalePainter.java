package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;

public class FemalePainter extends EasonPainterSet {
    public FemalePainter() {
        Painter circle = new CirclePainter();
        circle.setPercent(0.5f);
        circle.setOffsetPercentX(0.25f);
        circle.setOffsetPercentY(0.1f);
        addPainter(circle);
        Painter add = new AddPainter();
        add.setPercentX(0.4f);
        add.setPercentY(0.3f);
        add.setOffsetPercentX(0.3f);
        add.setOffsetPercentY(0.6f);
        addPainter(add);
    }
}
