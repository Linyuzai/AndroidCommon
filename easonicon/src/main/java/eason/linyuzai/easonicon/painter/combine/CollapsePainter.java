package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.SlopeNegativeLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopePositiveLinePainter;

public class CollapsePainter extends EasonPainterSet {
    public CollapsePainter() {
        Painter negative = new SlopeNegativeLinePainter();
        negative.setPercent(0.5f);
        negative.setOffsetPercentY(0.2f);
        addPainter(negative);
        Painter positive = new SlopePositiveLinePainter();
        positive.setPercent(0.5f);
        positive.setOffsetPercentX(0.5f);
        positive.setOffsetPercentY(0.2f);
        addPainter(positive);
    }
}
