package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class LeftTopRightBottomRoundRectPainter extends RectPainter {
    public LeftTopRightBottomRoundRectPainter(@RoundField float r) {
        setLeftTopRightBottom(r);
    }

    public LeftTopRightBottomRoundRectPainter(@RoundField float x, @RoundField float y) {
        setLeftTopRightBottom(x, y);
    }
}
