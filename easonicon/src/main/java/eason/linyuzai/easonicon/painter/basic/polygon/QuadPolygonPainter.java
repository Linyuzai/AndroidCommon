package eason.linyuzai.easonicon.painter.basic.polygon;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

public class QuadPolygonPainter extends ExtraPolygonPainter {

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
    public void configurePath(Path path, RectF draw, RectF original, Paint paint) {
        PointF[] points = getPoints(draw);
        path.moveTo(points[0].x, points[0].y);
        for (int i = 1; i < points.length; i += 2) {
            if (i == points.length - 1) {
                path.quadTo(points[i].x, points[i].y, points[0].x, points[0].y);
            } else {
                path.quadTo(points[i].x, points[i].y, points[i + 1].x, points[i + 1].y);
            }
        }
    }
}
