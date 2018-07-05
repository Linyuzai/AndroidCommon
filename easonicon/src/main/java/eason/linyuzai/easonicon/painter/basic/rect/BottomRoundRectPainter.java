package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class BottomRoundRectPainter extends RectPainter {
    public BottomRoundRectPainter(float r) {
        setBottom(r);
    }

    public BottomRoundRectPainter(float x, float y) {
        setBottom(x, y);
    }
}
