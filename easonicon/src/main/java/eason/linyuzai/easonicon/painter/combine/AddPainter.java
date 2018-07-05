package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.VerticalLinePainter;

public class AddPainter extends EasonPainterSet {
    public AddPainter() {
        Painter horizontal = new HorizontalLinePainter();
        horizontal.setOffsetPercentY(0.5f);
        addPainter(horizontal);
        Painter vertical = new VerticalLinePainter();
        vertical.setOffsetPercentX(0.5f);
        addPainter(vertical);
    }
}
