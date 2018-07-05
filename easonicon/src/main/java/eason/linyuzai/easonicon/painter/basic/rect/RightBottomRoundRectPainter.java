package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class RightBottomRoundRectPainter extends RectPainter {
    public RightBottomRoundRectPainter(float r) {
        setRightBottom(r);
    }

    public RightBottomRoundRectPainter(float x, float y) {
        setRightBottom(x, y);
    }
}
