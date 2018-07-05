package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class LeftTopRightBottomRoundRectPainter extends RectPainter {
    public LeftTopRightBottomRoundRectPainter(float r) {
        setLeftTopRightBottom(r);
    }

    public LeftTopRightBottomRoundRectPainter(float x, float y) {
        setLeftTopRightBottom(x, y);
    }
}
