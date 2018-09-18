package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.SlopeNegativeLinePainter;

public class CodeGeneratePainter extends EasonPainterSet {

    public CodeGeneratePainter() {
        Painter b = new BackPainter();
        b.setPercentX(0.5f);
        b.setPercentY(0.5f);
        b.setOffsetPercentX(-0.08f);
        b.setOffsetPercentY(0.25f);
        addPainter(b);
        Painter n = new NextPainter();
        n.setPercentX(0.5f);
        n.setPercentY(0.5f);
        n.setOffsetPercentX(0.58f);
        n.setOffsetPercentY(0.25f);
        addPainter(n);
        Painter snl = new SlopeNegativeLinePainter();
        snl.setPercentX(0.3f);
        snl.setPercentY(0.7f);
        snl.setOffsetPercentX(0.35f);
        snl.setOffsetPercentY(0.15f);
        addPainter(snl);
    }
}
