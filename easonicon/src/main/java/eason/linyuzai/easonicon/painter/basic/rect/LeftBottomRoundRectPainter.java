package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class LeftBottomRoundRectPainter extends RectPainter {
    public LeftBottomRoundRectPainter(@RoundField float r) {
        setLeftBottom(r);
    }

    public LeftBottomRoundRectPainter(@RoundField float x, @RoundField float y) {
        setLeftBottom(x, y);
    }
}
