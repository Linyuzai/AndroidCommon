package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.RoundRectField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.support.RoundRectSupport;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;

@RoundRectField
public class CategoryPainter extends SupportEasonPainterSet implements RoundRectSupport {
    public CategoryPainter() {
        this(0f, 0f, 0f, 0f);
    }

    public CategoryPainter(float leftTop, float leftBottom, float rightTop, float rightBottom) {
        Painter lt = new RectPainter(leftTop, leftBottom, rightTop, rightBottom);
        lt.setPercent(0.45f);
        addPainter(lt);
        Painter rt = new RectPainter(leftTop, leftBottom, rightTop, rightBottom);
        rt.setPercent(0.45f);
        rt.setOffsetPercentX(0.55f);
        addPainter(rt);
        Painter lb = new RectPainter(leftTop, leftBottom, rightTop, rightBottom);
        lb.setPercent(0.45f);
        lb.setOffsetPercentY(0.55f);
        addPainter(lb);
        Painter rb = new RectPainter(leftTop, leftBottom, rightTop, rightBottom);
        rb.setPercent(0.45f);
        rb.setOffsetPercent(0.55f);
        addPainter(rb);
    }
}
