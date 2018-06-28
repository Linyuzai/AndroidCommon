package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.SlopeNegativeLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopePositiveLinePainter;

public class ErrorPainter extends EasonPainterSet {

    public ErrorPainter() {
        addPainter(new SlopePositiveLinePainter());
        addPainter(new SlopeNegativeLinePainter());
    }
}
