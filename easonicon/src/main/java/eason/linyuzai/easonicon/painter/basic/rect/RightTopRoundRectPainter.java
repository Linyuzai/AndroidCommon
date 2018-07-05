package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class RightTopRoundRectPainter extends RectPainter {
    public RightTopRoundRectPainter(float r) {
        setRightTop(r);
    }

    public RightTopRoundRectPainter(float x, float y) {
        setRightTop(x, y);
    }
}
