package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;

public class FemalePainter extends EasonPainterSet {
    public FemalePainter() {
        Painter circle = new CirclePainter();
        circle.setPercent(0.55f);
        circle.setOffsetPercentX(0.225f);
        circle.setOffsetPercentY(0.11f);
        addPainter(circle);
        Painter add = new AddPainter();
        add.setPercentX(0.36f);
        add.setPercentY(0.22f);
        add.setOffsetPercentX(0.32f);
        add.setOffsetPercentY(0.66f);
        addPainter(add);
    }
}
