package eason.linyuzai.easonicon.painter.basic.arc;

import eason.linyuzai.easonicon.annotation.ArcField;
import eason.linyuzai.easonicon.open.support.ArcSupport;

@ArcField
public class CenterArcPainter extends ArcPainter implements ArcSupport {

    public CenterArcPainter(float sweepAngle) {
        super(sweepAngle, true);
    }

    public CenterArcPainter(float startAngle, float sweepAngle) {
        super(startAngle, sweepAngle, true);
    }
}
