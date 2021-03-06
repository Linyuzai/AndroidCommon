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

public class DownArrowPainter extends EasonPainterSet {

    public DownArrowPainter() {
        Painter expand = new ExpandPainter();
        expand.setPercent(0.8f);
        expand.setOffsetPercentX(0.1f);
        expand.setOffsetPercentY(0.36f);
        addPainter(expand);
        Painter vertical = new VerticalLinePainter();
        vertical.setOffsetPercentX(0.5f);
        addPainter(vertical);
    }
}
