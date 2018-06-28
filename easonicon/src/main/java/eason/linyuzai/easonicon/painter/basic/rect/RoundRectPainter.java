package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class RoundRectPainter extends RectPainter {
    public RoundRectPainter(@RoundField float r) {
        setRoundAll(r);
    }

    public RoundRectPainter(@RoundField float x, @RoundField float y) {
        setRoundAll(x, y);
    }
}
