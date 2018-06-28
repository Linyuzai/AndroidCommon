package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.VerticalLinePainter;

public class AddPainter extends EasonPainterSet {
    public AddPainter() {
        addPainter(new HorizontalLinePainter());
        addPainter(new VerticalLinePainter());
    }
}
