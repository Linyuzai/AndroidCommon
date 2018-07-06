package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopeNegativeLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.VerticalLinePainter;

public class MalePainter extends EasonPainterSet {

    public MalePainter() {
        Painter circle = new CirclePainter();
        circle.setPercent(0.5f);
        circle.setOffsetPercentX(0.15f);
        circle.setOffsetPercentY(0.35f);
        addPainter(circle);
        Painter snl = new SlopeNegativeLinePainter();
        snl.setPercent(0.2f);
        snl.setOffsetPercentX(0.575f);
        snl.setOffsetPercentY(0.225f);
        addPainter(snl);
        Painter hl = new HorizontalLinePainter();
        hl.setPercent(0.15f);
        hl.setOffsetPercentX(0.625f);
        hl.setOffsetPercentY(0.225f);
        addPainter(hl);
        Painter vl = new VerticalLinePainter();
        vl.setOffsetPercentX(0.775f);
        vl.setOffsetPercentY(0.225f);
        vl.setPercent(0.15f);
        addPainter(vl);
    }
}
