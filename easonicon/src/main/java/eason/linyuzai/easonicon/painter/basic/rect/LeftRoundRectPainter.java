package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class LeftRoundRectPainter extends RectPainter {
    public LeftRoundRectPainter(float r) {
        setLeft(r);
    }

    public LeftRoundRectPainter(float x, float y) {
        setLeft(x, y);
    }
}
