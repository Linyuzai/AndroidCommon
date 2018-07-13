package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopePositiveLinePainter;

public class SearchPainter extends EasonPainterSet {

    public SearchPainter() {
        Painter oval = new OvalPainter();
        oval.setPercent(0.8f);
        addPainter(oval);
        Painter line = new SlopePositiveLinePainter();
        line.setPercent(0.32f);
        line.setOffsetPercent(0.68f);
        addPainter(line);
    }
}
