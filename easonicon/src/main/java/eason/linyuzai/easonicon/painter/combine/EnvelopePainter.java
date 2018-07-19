package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.RoundRectField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.support.RoundRectSupport;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;

@RoundRectField
public class EnvelopePainter extends SupportEasonPainterSet implements RoundRectSupport {

    private Painter expand;

    public EnvelopePainter() {
        this(0f, 0f, 0f, 0f);
    }

    public EnvelopePainter(float leftTopRound, float leftBottomRound,
                           float rightTopRound, float rightBottomRound) {
        Painter painter = new RectPainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound);
        painter.setCenterPercentY(0.7f);
        addPainter(painter);
        expand = new ExpandPainter();
        expand.setPercentY(0.5f);
        //expand.setOffsetPercentY(-0.03f);
        setExpandOffset(leftTopRound, rightTopRound);
        addPainter(expand);
    }

    @Override
    public void setLeftTop(float r) {
        super.setLeftTop(r);
        setExpandOffset(r, expand.getOffsetY());
    }

    @Override
    public void setRightTop(float r) {
        super.setRightTop(r);
        setExpandOffset(r, expand.getOffsetY());
    }

    private void setExpandOffset(float n, float o) {
        expand.setOffsetY(Math.max(n, o));
    }


}
