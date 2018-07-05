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

public class RightArrowPainter extends EasonPainterSet {

    public RightArrowPainter() {
        Painter next = new NextPainter();
        next.setOffsetPercentX(0.2f);
        addPainter(next);
        Painter horizontal = new HorizontalLinePainter();
        horizontal.setOffsetPercentY(0.5f);
        addPainter(horizontal);
    }
}
