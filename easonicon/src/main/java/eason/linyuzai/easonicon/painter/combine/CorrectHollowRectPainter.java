package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.RoundRectField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.support.RoundRectSupport;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;

@AuxiliaryScaleField
@RoundRectField
public class CorrectHollowRectPainter extends SupportEasonPainterSet implements RoundRectSupport {

    public CorrectHollowRectPainter() {
        this(0.5f);
    }

    public CorrectHollowRectPainter(float auxiliaryScale) {
        this(auxiliaryScale, 0f, 0f, 0f, 0f);
    }

    public CorrectHollowRectPainter(float leftTopRound, float leftBottomRound, float rightTopRound,
                                    float rightBottomRound) {
        this(0.5f, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound);
    }

    public CorrectHollowRectPainter(float auxiliaryScale, float leftTopRound, float leftBottomRound,
                                    float rightTopRound, float rightBottomRound) {
        addPainter(new RectPainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
        Painter painter = new CorrectPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
