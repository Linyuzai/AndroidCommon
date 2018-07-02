package eason.linyuzai.easonicon.painter.combine;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.RoundField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryStyleInterceptor;

public class BackSolidRectPainter extends EasonPainterSet {

    public BackSolidRectPainter(@AuxiliaryColorField int auxiliaryColor, @AuxiliaryColorField int circleColor) {
        this(0.5f, auxiliaryColor, circleColor);
    }

    public BackSolidRectPainter(@AuxiliaryScaleField float auxiliaryScale, @AuxiliaryColorField int auxiliaryColor,
                                @AuxiliaryColorField int circleColor) {
        this(auxiliaryScale, auxiliaryColor, circleColor, 0f, 0f, 0f, 0f);
    }

    public BackSolidRectPainter(@AuxiliaryColorField int auxiliaryColor, @AuxiliaryColorField int circleColor,
                                @RoundField float leftTopRound, @RoundField float leftBottomRound,
                                @RoundField float rightTopRound, @RoundField float rightBottomRound) {
        this(0.5f, auxiliaryColor, circleColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound);
    }

    public BackSolidRectPainter(@AuxiliaryScaleField float auxiliaryScale, @AuxiliaryColorField int auxiliaryColor,
                                @AuxiliaryColorField int circleColor, @RoundField float leftTopRound,
                                @RoundField float leftBottomRound, @RoundField float rightTopRound,
                                @RoundField float rightBottomRound) {
        addPainter(new RectPainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
        Painter painter = new BackPainter();
        painter.setCenterPercent(auxiliaryScale);
        addPainter(painter);
        addInterceptor(new AuxiliaryStyleInterceptor());
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor, circleColor));
    }
}
