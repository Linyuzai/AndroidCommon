package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class RightTopRoundRectPainter extends RectPainter {
    public RightTopRoundRectPainter(@RoundField float r) {
        setRightTop(r);
    }

    public RightTopRoundRectPainter(@RoundField float x, @RoundField float y) {
        setRightTop(x, y);
    }
}
