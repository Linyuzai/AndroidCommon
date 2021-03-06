package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;

public class MenuPainter extends EasonPainterSet {

    public MenuPainter() {
        Painter hl1 = new HorizontalLinePainter();
        addPainter(hl1);
        Painter hl2 = new HorizontalLinePainter();
        hl2.setOffsetPercentY(0.5f);
        addPainter(hl2);
        Painter hl3 = new HorizontalLinePainter();
        hl3.setOffsetPercentY(1f);
        addPainter(hl3);
    }
}
