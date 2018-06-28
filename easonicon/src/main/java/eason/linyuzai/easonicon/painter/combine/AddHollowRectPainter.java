package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.RoundField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;

public class AddHollowRectPainter extends EasonPainterSet {

    public AddHollowRectPainter() {
        this(0.5f);
    }

    public AddHollowRectPainter(@AuxiliaryScaleField float addScale) {
        this(addScale, 0f, 0f, 0f, 0f);
    }

    public AddHollowRectPainter(@RoundField float leftTopRound, @RoundField float leftBottomRound,
                                @RoundField float rightTopRound, @RoundField float rightBottomRound) {
        this(0.5f, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound);
    }

    public AddHollowRectPainter(@AuxiliaryScaleField float addScale, @RoundField float leftTopRound,
                                @RoundField float leftBottomRound, @RoundField float rightTopRound,
                                @RoundField float rightBottomRound) {
        addPainter(new RectPainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
        Painter add = new AddPainter();
        add.setCenterPercent(addScale);
        addPainter(add);
    }
}
