package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;

/**
 * Created by linyuzai on 2018/5/19.
 * 返回键头
 *
 * @author linyuzai
 */

public class LeftArrowPainter extends EasonPainterSet {

    public LeftArrowPainter() {
        Painter back = new BackPainter();
        back.setPercent(0.8f);
        back.setOffsetPercentX(-0.16f);
        back.setOffsetPercentY(0.1f);
        addPainter(back);
        Painter horizontal = new HorizontalLinePainter();
        horizontal.setOffsetPercentY(0.5f);
        addPainter(horizontal);
    }
}
