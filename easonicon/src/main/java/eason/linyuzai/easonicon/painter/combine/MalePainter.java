package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopeNegativeLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.VerticalLinePainter;

public class MalePainter extends EasonPainterSet {

    public MalePainter() {
        Painter oval = new OvalPainter();
        oval.setPercent(0.8f);
        oval.setOffsetPercentY(0.2f);
        addPainter(oval);
        Painter snl = new SlopeNegativeLinePainter();
        snl.setPercent(0.32f);
        snl.setOffsetPercentX(0.68f);
        addPainter(snl);
        Painter hl = new HorizontalLinePainter();
        hl.setPercentX(0.25f);
        hl.setOffsetPercentX(0.75f);
        addPainter(hl);
        Painter vl = new VerticalLinePainter();
        vl.setPercentY(0.25f);
        vl.setOffsetPercentX(1f);
        addPainter(vl);
    }
}
