package eason.linyuzai.easonicon.painter.basic.arc;

import eason.linyuzai.easonicon.annotation.ArcField;

@ArcField
public class CenterArcPainter extends ArcPainter {

    public CenterArcPainter(float sweepAngle) {
        super(sweepAngle, true);
    }

    public CenterArcPainter(float startAngle, float sweepAngle) {
        super(startAngle, sweepAngle, true);
    }
}
