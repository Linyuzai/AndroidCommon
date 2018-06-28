package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class LeftRoundRectPainter extends RectPainter {
    public LeftRoundRectPainter(@RoundField float r) {
        setLeft(r);
    }

    public LeftRoundRectPainter(@RoundField float x, @RoundField float y) {
        setLeft(x, y);
    }
}
