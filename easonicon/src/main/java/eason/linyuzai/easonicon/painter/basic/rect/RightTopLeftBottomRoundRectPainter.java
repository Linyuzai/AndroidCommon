package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class RightTopLeftBottomRoundRectPainter extends RectPainter {
    public RightTopLeftBottomRoundRectPainter(@RoundField float r) {
        setRightTopLeftBottom(r);
    }

    public RightTopLeftBottomRoundRectPainter(@RoundField float x, @RoundField float y) {
        setRightTopLeftBottom(x, y);
    }
}
