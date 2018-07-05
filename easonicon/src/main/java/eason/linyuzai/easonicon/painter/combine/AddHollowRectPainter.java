package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.RoundRectField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;

@AuxiliaryScaleField
@RoundRectField
public class AddHollowRectPainter extends EasonPainterSet {

    public AddHollowRectPainter() {
        this(0.5f);
    }

    public AddHollowRectPainter(float auxiliaryScale) {
        this(auxiliaryScale, 0f, 0f, 0f, 0f);
    }

    public AddHollowRectPainter(float leftTopRound, float leftBottomRound, float rightTopRound,
                                float rightBottomRound) {
        this(0.5f, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound);
    }

    public AddHollowRectPainter(float auxiliaryScale, float leftTopRound, float leftBottomRound,
                                float rightTopRound, float rightBottomRound) {
        addPainter(new RectPainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
        Painter painter = new AddPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
