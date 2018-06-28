package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;
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
        expand.setOffsetPercentY(0.5f);
        addPainter(expand);
        addPainter(new VerticalLinePainter());
    }
}
