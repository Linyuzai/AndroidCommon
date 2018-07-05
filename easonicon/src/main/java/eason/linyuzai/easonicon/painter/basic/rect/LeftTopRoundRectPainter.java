package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class LeftTopRoundRectPainter extends RectPainter {
    public LeftTopRoundRectPainter(float r) {
        setLeftTop(r);
    }

    public LeftTopRoundRectPainter(float x, float y) {
        setLeftTop(x, y);
    }
}
