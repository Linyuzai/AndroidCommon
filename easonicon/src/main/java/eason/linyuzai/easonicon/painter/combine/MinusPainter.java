package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;

public class MinusPainter extends EasonPainterSet {
    public MinusPainter() {
        Painter horizontal = new HorizontalLinePainter();
        horizontal.setOffsetPercentY(0.5f);
        addPainter(horizontal);
    }
}
