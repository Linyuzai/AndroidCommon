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
        back.setOffsetPercentX(0f);
        addPainter(back);
        addPainter(new HorizontalLinePainter());
    }
}
