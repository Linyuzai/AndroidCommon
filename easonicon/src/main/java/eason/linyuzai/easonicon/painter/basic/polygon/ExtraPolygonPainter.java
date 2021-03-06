package eason.linyuzai.easonicon.painter.basic.polygon;

import android.graphics.PointF;
import android.graphics.RectF;

import eason.linyuzai.easonicon.annotation.EdgeCountField;
import eason.linyuzai.easonicon.annotation.ExtraOffsetField;
import eason.linyuzai.easonicon.open.support.EdgeCountSupport;
import eason.linyuzai.easonicon.open.support.ExtraOffsetSupport;

@EdgeCountField
@ExtraOffsetField
public class ExtraPolygonPainter extends PolygonPainter implements EdgeCountSupport, ExtraOffsetSupport {

    private float extraOffset;

    private PointF[] extras;
    private PointF[] total;

    private PointF midpoint = new PointF();
    private Line line = new Line();

    private PointF center = new PointF();

    public ExtraPolygonPainter() {
        this(0f);
    }

    public ExtraPolygonPainter(int edgeCount) {
        super(edgeCount);
    }

    public ExtraPolygonPainter(float extraOffset) {
        this.extraOffset = extraOffset;
    }

    public ExtraPolygonPainter(int edgeCount, float extraOffset) {
        super(edgeCount);
        this.extraOffset = extraOffset;
    }

    @Override
    public float getExtraOffset() {
        return extraOffset;
    }

    @Override
    public void setExtraOffset(float extraOffset) {
        this.extraOffset = extraOffset;
    }

    @Override
    public void setEdgeCount(int edgeCount) {
        super.setEdgeCount(edgeCount);
        extras = new PointF[getEdgeCount()];
        total = new PointF[2 * getEdgeCount()];
        for (int i = 0; i < extras.length; i++) {
            extras[i] = new PointF();
        }
    }

    @Override
    public PointF[] getPoints(RectF rectF, PointF[] points) {
        PointF[] equals = getEqualDivisionPoints(points, rectF, 90f);
        PointF[] extras = getExtraPoints(equals, this.extras, rectF);
        //PointF[] total = new PointF[points.length + extras.length];
        for (int i = 0; i < total.length; i += 2) {
            total[i] = equals[i / 2];
            total[i + 1] = extras[i / 2];
        }
        return total;
    }

    public final PointF[] getExtraPoints(PointF[] points, PointF[] extras, RectF rectF) {
        PointF center = getCenter(this.center, rectF);
        //PointF[] extras = new PointF[points.length];
        PointF start;
        PointF end;
        for (int i = 0; i < points.length; i++) {
            //PointF extra = new PointF();
            if (i == points.length - 1) {
                start = points[i];
                end = points[0];
            } else {
                start = points[i];
                end = points[i + 1];
            }
            midpoint.x = (start.x + end.x) * 0.5f;
            midpoint.y = (start.y + end.y) * 0.5f;
            //PointF midpoint = new PointF((start.x + end.x) * 0.5f, (start.y + end.y) * 0.5f);
            if (Math.abs(start.x - end.x) <= getPrecisionAccuracy()) {
                if (midpoint.x >= center.x) {
                    extras[i].x = midpoint.x + extraOffset;
                } else {
                    extras[i].x = midpoint.x - extraOffset;
                }
                extras[i].y = midpoint.y;
            } else if (Math.abs(start.y - end.y) <= getPrecisionAccuracy()) {
                if (midpoint.y >= center.y) {
                    extras[i].y = midpoint.y + extraOffset;
                } else {
                    extras[i].y = midpoint.y - extraOffset;
                }
                extras[i].x = midpoint.x;
            } else {
                //Line line = new Line(start, end);
                line.calculate(start, end);
                line.reverseSlope(midpoint);
                if (extraOffset >= 0f) {
                    if (midpoint.x >= center.x) {
                        extras[i].x = (float) (Math.sqrt((extraOffset * extraOffset) / (1 + line.k * line.k)) + midpoint.x);
                    } else {
                        extras[i].x = (float) (-Math.sqrt((extraOffset * extraOffset) / (1 + line.k * line.k)) + midpoint.x);
                    }
                } else {
                    if (midpoint.x >= center.x) {
                        extras[i].x = (float) (-Math.sqrt((extraOffset * extraOffset) / (1 + line.k * line.k)) + midpoint.x);
                    } else {
                        extras[i].x = (float) (Math.sqrt((extraOffset * extraOffset) / (1 + line.k * line.k)) + midpoint.x);
                    }
                }
                extras[i].y = line.getY(extras[i].x);
            }
            //extras[i] = extra;
        }
        return extras;
    }

    public static class Line {

        float k;
        float b;

        public Line() {

        }

        public Line(PointF startPoint, PointF endPoint) {
            calculate(startPoint, endPoint);
        }

        public void calculate(PointF startPoint, PointF endPoint) {
            k = (endPoint.y - startPoint.y) / (endPoint.x - startPoint.x);
            b = startPoint.y - k * startPoint.x;
        }

        public float getY(float x) {
            return k * x + b;
        }

        public void reverseSlope(PointF point) {
            k = -1f / k;
            b = point.y - k * point.x;
        }
    }
}
