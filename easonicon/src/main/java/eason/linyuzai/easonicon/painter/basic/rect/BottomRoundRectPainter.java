package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class BottomRoundRectPainter extends RectPainter {
    public BottomRoundRectPainter(@RoundField float r) {
        setBottom(r);
    }

    public BottomRoundRectPainter(@RoundField float x, @RoundField float y) {
        setBottom(x, y);
    }
}
