package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.SlopeNegativeLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopePositiveLinePainter;

public class CorrectPainter extends EasonPainterSet {
    public CorrectPainter() {
        Painter positive = new SlopePositiveLinePainter();
        positive.setPercent(1f / 3f);
        positive.setOffsetPercentY(2f / 3f);
        addPainter(positive);
        Painter negative = new SlopeNegativeLinePainter();
        negative.setPercent(2f / 3f);
        negative.setOffsetPercent(1f / 3f);
        addPainter(negative);
        setOffsetPercentY(-1f / 6f);
    }
}
