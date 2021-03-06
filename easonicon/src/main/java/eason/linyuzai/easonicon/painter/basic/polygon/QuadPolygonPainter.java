package eason.linyuzai.easonicon.painter.basic.polygon;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

import eason.linyuzai.easonicon.annotation.EdgeCountField;
import eason.linyuzai.easonicon.annotation.ExtraOffsetField;
import eason.linyuzai.easonicon.open.support.EdgeCountSupport;
import eason.linyuzai.easonicon.open.support.ExtraOffsetSupport;

@EdgeCountField
@ExtraOffsetField
public class QuadPolygonPainter extends ExtraPolygonPainter implements EdgeCountSupport, ExtraOffsetSupport {

    public QuadPolygonPainter() {
        this(0f);
    }

    public QuadPolygonPainter(int edgeCount) {
        super(edgeCount);
    }

    public QuadPolygonPainter(float extraOffset) {
        super(extraOffset);
    }

    public QuadPolygonPainter(int edgeCount, float extraOffset) {
        super(edgeCount, extraOffset);
    }

    @Override
    public void configurePolygonPath(Path path, RectF draw, RectF original, Paint paint, PointF[] points) {
        path.moveTo(points[0].x, points[0].y);
        for (int i = 1; i < points.length; i += 2) {
            if (i == points.length - 1) {
                path.quadTo(points[i].x, points[i].y, points[0].x, points[0].y);
            } else {
                path.quadTo(points[i].x, points[i].y, points[i + 1].x, points[i + 1].y);
            }
        }
        path.close();
    }
}
