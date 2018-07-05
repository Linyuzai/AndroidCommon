package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class RightTopLeftBottomRoundRectPainter extends RectPainter {
    public RightTopLeftBottomRoundRectPainter(float r) {
        setRightTopLeftBottom(r);
    }

    public RightTopLeftBottomRoundRectPainter(float x, float y) {
        setRightTopLeftBottom(x, y);
    }
}
