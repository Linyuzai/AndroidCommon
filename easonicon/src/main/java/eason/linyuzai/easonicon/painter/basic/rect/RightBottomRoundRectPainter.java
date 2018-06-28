package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class RightBottomRoundRectPainter extends RectPainter {
    public RightBottomRoundRectPainter(@RoundField float r) {
        setRightBottom(r);
    }

    public RightBottomRoundRectPainter(@RoundField float x, @RoundField float y) {
        setRightBottom(x, y);
    }
}
