package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.VerticalLinePainter;

public class DownloadPainter extends EasonPainterSet {

    public DownloadPainter() {
        Painter arrow = new DownArrowPainter();
        arrow.setPercentX(0.5f);
        arrow.setPercentY(0.55f);
        arrow.setOffsetPercentX(0.25f);
        arrow.setOffsetPercentY(0.15f);
        addPainter(arrow);
        Painter lvl = new VerticalLinePainter();
        lvl.setPercentY(0.35f);
        lvl.setOffsetPercentY(0.55f);
        addPainter(lvl);
        Painter hl = new HorizontalLinePainter();
        hl.setOffsetPercentY(0.9f);
        addPainter(hl);
        Painter rvl = new VerticalLinePainter();
        rvl.setPercentY(0.35f);
        rvl.setOffsetPercentX(1f);
        rvl.setOffsetPercentY(0.55f);
        addPainter(rvl);
    }
}
