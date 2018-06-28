package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.SlopeNegativeLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopePositiveLinePainter;

public class ExpandPainter extends EasonPainterSet {
    public ExpandPainter() {
        Painter positive = new SlopePositiveLinePainter();
        positive.setPercent(0.5f);
        addPainter(positive);
        Painter negative = new SlopeNegativeLinePainter();
        negative.setPercent(0.5f);
        negative.setOffsetPercentX(0.5f);
        addPainter(negative);
        setOffsetPercentY(0.25f);
    }
}
