package eason.linyuzai.easonicon.painter.basic.arc;

import eason.linyuzai.easonicon.annotation.ArcField;

public class CenterArcPainter extends ArcPainter {

    public CenterArcPainter(@ArcField float sweepAngle) {
        super(sweepAngle, true);
    }

    public CenterArcPainter(@ArcField float startAngle, @ArcField float sweepAngle) {
        super(startAngle, sweepAngle, true);
    }
}
