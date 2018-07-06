package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.RoundRectField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;
import eason.linyuzai.easonicon.painter.basic.rect.TopRoundRectPainter;

@RoundRectField
public class UserPainter extends EasonPainterSet {

    public UserPainter(float leftTop, float leftBottom, float rightTop, float rightBottom) {
        Painter circle = new CirclePainter();
        circle.setPercent(0.5f);
        circle.setCenterPercentX(0.5f);
        addPainter(circle);
        Painter rect = new RectPainter(leftTop, leftBottom, rightTop, rightBottom);
        rect.setCenterPercentX(0.85f);
        rect.setPercentY(0.5f);
        rect.setOffsetPercentY(0.5f);
        addPainter(rect);
    }
}
