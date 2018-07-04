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

public class BackPainter extends EasonPainterSet {

    public BackPainter() {
        Painter negative = new SlopeNegativeLinePainter();
        negative.setPercent(0.5f);
        negative.setOffsetPercentX(0.2f);
        addPainter(negative);
        Painter positive = new SlopePositiveLinePainter();
        positive.setPercent(0.5f);
        positive.setOffsetPercentY(0.5f);
        positive.setOffsetPercentX(0.2f);
        addPainter(positive);
    }
}
