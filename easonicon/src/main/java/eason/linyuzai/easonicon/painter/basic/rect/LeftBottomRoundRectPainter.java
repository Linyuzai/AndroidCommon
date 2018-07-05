package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class LeftBottomRoundRectPainter extends RectPainter {
    public LeftBottomRoundRectPainter(float r) {
        setLeftBottom(r);
    }

    public LeftBottomRoundRectPainter(float x, float y) {
        setLeftBottom(x, y);
    }
}
