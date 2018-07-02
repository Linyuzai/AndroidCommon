package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.RoundField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;

public class NextHollowRectPainter extends EasonPainterSet {

    public NextHollowRectPainter() {
        this(0.5f);
    }

    public NextHollowRectPainter(@AuxiliaryScaleField float auxiliaryScale) {
        this(auxiliaryScale, 0f, 0f, 0f, 0f);
    }

    public NextHollowRectPainter(@RoundField float leftTopRound, @RoundField float leftBottomRound,
                                 @RoundField float rightTopRound, @RoundField float rightBottomRound) {
        this(0.5f, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound);
    }

    public NextHollowRectPainter(@AuxiliaryScaleField float auxiliaryScale, @RoundField float leftTopRound,
                                 @RoundField float leftBottomRound, @RoundField float rightTopRound,
                                 @RoundField float rightBottomRound) {
        addPainter(new RectPainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
        Painter painter = new LeftArrowPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
    }
}
