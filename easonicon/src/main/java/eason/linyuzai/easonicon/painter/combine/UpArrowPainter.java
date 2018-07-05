package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.VerticalLinePainter;

/**
 * Created by linyuzai on 2018/5/19.
 * 返回键头
 *
 * @author linyuzai
 */

public class UpArrowPainter extends EasonPainterSet {

    public UpArrowPainter() {
        Painter collapse = new CollapsePainter();
        collapse.setOffsetPercentY(-0.2f);
        addPainter(collapse);
        Painter vertical = new VerticalLinePainter();
        vertical.setOffsetPercentX(0.5f);
        addPainter(vertical);
    }
}
