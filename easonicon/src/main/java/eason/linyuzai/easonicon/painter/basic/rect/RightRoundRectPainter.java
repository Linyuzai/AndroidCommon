package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class RightRoundRectPainter extends RectPainter {
    public RightRoundRectPainter(float r) {
        setRight(r);
    }

    public RightRoundRectPainter(float x, float y) {
        setRight(x, y);
    }
}
