package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class RoundRectPainter extends RectPainter {
    public RoundRectPainter(float r) {
        setRoundAll(r);
    }

    public RoundRectPainter(float x, float y) {
        setRoundAll(x, y);
    }
}
