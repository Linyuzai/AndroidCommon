package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.SlopeNegativeLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopePositiveLinePainter;

/**
 * Created by linyuzai on 2018/5/19.
 * 返回键头
 *
 * @author linyuzai
 */

public class NextPainter extends EasonPainterSet {

    public NextPainter() {
        Painter positive = new SlopePositiveLinePainter();
        positive.setPercent(0.5f);
        Painter negative = new SlopeNegativeLinePainter();
        negative.setPercent(0.5f);
        negative.setOffsetPercentY(0.5f);
        addPainter(positive);
        addPainter(negative);
        setOffsetPercentX(0.25f);
    }
}
