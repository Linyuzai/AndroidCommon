package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Color;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.RoundRectField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.support.AuxiliaryColorSupport;
import eason.linyuzai.easonicon.open.support.AuxiliaryScaleSupport;
import eason.linyuzai.easonicon.open.support.RoundRectSupport;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;
import eason.linyuzai.easonicon.painter.combine.filler.PenColorHueFiller;
import eason.linyuzai.easonicon.painter.combine.filler.PenStyleHueFiller;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;

@AuxiliaryScaleField
@AuxiliaryColorField
@RoundRectField
public class ErrorRectPainter extends SupportEasonPainterSet implements AuxiliaryScaleSupport, AuxiliaryColorSupport, RoundRectSupport {

    public ErrorRectPainter() {
        this(Color.WHITE);
    }

    public ErrorRectPainter(int auxiliaryColor) {
        this(0.5f, auxiliaryColor);
    }

    public ErrorRectPainter(float auxiliaryScale, int auxiliaryColor) {
        this(auxiliaryScale, auxiliaryColor, 0f, 0f, 0f, 0f);
    }

    public ErrorRectPainter(int auxiliaryColor, float leftTopRound, float leftBottomRound,
                            float rightTopRound, float rightBottomRound) {
        this(0.5f, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound);
    }

    public ErrorRectPainter(float auxiliaryScale, int auxiliaryColor, float leftTopRound,
                            float leftBottomRound, float rightTopRound, float rightBottomRound) {
        addPainter(new RectPainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
        Painter painter = new ErrorPainter();
        painter.setCenterPercent(auxiliaryScale);
        setAuxiliaryScalePainter(painter);
        addPainter(painter);
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor));

        addInterceptor(new PenStyleHueFiller());
        addInterceptor(new PenColorHueFiller());
    }
}
