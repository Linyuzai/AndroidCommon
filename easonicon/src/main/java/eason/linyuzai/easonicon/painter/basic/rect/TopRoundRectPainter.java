package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundRectField;

@RoundRectField
public class TopRoundRectPainter extends RectPainter {
    public TopRoundRectPainter(float r) {
        setTop(r);
    }

    public TopRoundRectPainter(float x, float y) {
        setTop(x, y);
    }
}
