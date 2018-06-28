package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class RightRoundRectPainter extends RectPainter {
    public RightRoundRectPainter(@RoundField float r) {
        setRight(r);
    }

    public RightRoundRectPainter(@RoundField float x, @RoundField float y) {
        setRight(x, y);
    }
}
