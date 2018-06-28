package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class LeftTopRoundRectPainter extends RectPainter {
    public LeftTopRoundRectPainter(@RoundField float r) {
        setLeftTop(r);
    }

    public LeftTopRoundRectPainter(@RoundField float x, @RoundField float y) {
        setLeftTop(x, y);
    }
}
