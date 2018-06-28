package eason.linyuzai.easonicon.painter.basic.rect;

import eason.linyuzai.easonicon.annotation.RoundField;

public class TopRoundRectPainter extends RectPainter {
    public TopRoundRectPainter(@RoundField float r) {
        setTop(r);
    }

    public TopRoundRectPainter(@RoundField float x, @RoundField float y) {
        setTop(x, y);
    }
}
