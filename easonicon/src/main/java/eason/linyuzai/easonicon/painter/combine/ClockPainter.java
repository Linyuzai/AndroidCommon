package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.VerticalLinePainter;
import eason.linyuzai.easonicon.painter.combine.filler.PenColorHueFiller;
import eason.linyuzai.easonicon.painter.combine.filler.PenStyleHueFiller;

public class ClockPainter extends EasonPainterSet {

    public ClockPainter() {
        Painter oval = new OvalPainter();
        addPainter(oval);
        Painter vl = new VerticalLinePainter();
        vl.setPercentY(0.35f);
        vl.setOffsetPercentX(0.5f);
        vl.setOffsetPercentY(0.15f);
        addPainter(vl);
        Painter hl = new HorizontalLinePainter();
        hl.setPercentX(0.35f);
        hl.setOffsetPercentX(0.5f);
        hl.setOffsetPercentY(0.5f);
        addPainter(hl);

        addInterceptor(new PenStyleHueFiller());
        addInterceptor(new PenColorHueFiller());
    }
}
