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
        circle.setPercent(0.55f);
        circle.setOffsetPercentX(0.15f);
        circle.setOffsetPercentY(0.3f);
        addPainter(circle);
        Painter snl = new SlopeNegativeLinePainter();
        snl.setPercent(0.17f);
        snl.setOffsetPercentX(0.62f);
        snl.setOffsetPercentY(0.22f);
        addPainter(snl);
        Painter hl = new HorizontalLinePainter();
        hl.setPercent(0.15f);
        hl.setOffsetPercentX(0.64f);
        hl.setOffsetPercentY(0.22f);
        addPainter(hl);
        Painter vl = new VerticalLinePainter();
        vl.setOffsetPercentX(0.79f);
        vl.setOffsetPercentY(0.22f);
        vl.setPercent(0.15f);
        addPainter(vl);
    }
}
