package eason.linyuzai.easonicon.painter.basic.polygon;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Size;

import eason.linyuzai.easonicon.annotation.EdgeCountField;
import eason.linyuzai.easonicon.painter.basic.path.PathPainter;

@EdgeCountField
public class PolygonPainter extends PathPainter {

    private int edgeCount;

    private PointF[] points;

    public PolygonPainter() {
        this(3);
    }

    public PolygonPainter(@Size(min = 3) int edgeCount) {
        setEdgeCount(edgeCount);
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void setEdgeCount(@Size(min = 3) int edgeCount) {
        this.edgeCount = edgeCount;
        points = new PointF[edgeCount];
        for (int i = 0; i < points.length; i++) {
            points[i] = new PointF();
        }
    }

    @Override
    public void configurePath(Path path, RectF draw, RectF original, Paint paint) {
        configurePolygonPath(path, draw, original, paint, getPoints(draw, points));
    }

    public void configurePolygonPath(Path path, RectF draw, RectF original, Paint paint, PointF[] points) {
        path.moveTo(points[0].x, points[0].y);
        for (int i = 1; i < points.length; i++)
            path.lineTo(points[i].x, points[i].y);
        path.close();
    }

    public PointF[] getPoints(RectF rectF, PointF[] points) {
        return getEqualDivisionPoints(points, rectF, 90f);
    }

    public final PointF[] getEqualDivisionPoints(PointF[] points, RectF rectF, float startAngle) {
        int edgeCount = points.length;
        float a = rectF.width() * 0.5f;
        float b = rectF.height() * 0.5f;
        float angle = 360f / edgeCount;
        for (int i = 0; i < edgeCount; i++) {
            //PointF pointF = new PointF();
            float totalAngle = startAngle + angle * i;
            if (totalAngle % 360f <= getPrecisionAccuracy()) {
                points[i].x = a;
                points[i].y = 0f;
            } else if (Math.abs(totalAngle % 360f - 90f) <= getPrecisionAccuracy()) {
                points[i].x = 0f;
                points[i].y = b;
            } else if (Math.abs(totalAngle % 360f - 180f) <= getPrecisionAccuracy()) {
                points[i].x = -a;
                points[i].y = 0f;
            } else if (Math.abs(totalAngle % 360f - 270f) <= getPrecisionAccuracy()) {
                points[i].x = 0f;
                points[i].y = -b;
            } else {
                float tan = (float) Math.tan(Math.toRadians(totalAngle));
                points[i].x = (float) Math.sqrt((a * a * b * b) / (b * b + tan * tan * a * a));
                if (tan > 0) {
                    if (totalAngle > 180f && totalAngle < 270f) {
                        points[i].x = -points[i].x;
                    }
                } else {
                    if (totalAngle > 90f && totalAngle < 180f) {
                        points[i].x = -points[i].x;
                    }
                }
                points[i].y = tan * points[i].x;
            }
            points[i].x += a;
            points[i].y -= b;
            //pointF.x = (float) (a * Math.cos(totalAngle)) + a;
            //pointF.y = (float) (b * Math.sin(totalAngle)) - b;
            points[i].x = Math.abs(points[i].x);
            points[i].y = Math.abs(points[i].y);
            if (points[i].x < getPrecisionAccuracy())
                points[i].x = 0;
            if (points[i].y < getPrecisionAccuracy())
                points[i].y = 0;
            getCoordinate(points[i], rectF);
            //Log.d("point", "index:" + i + "----" + points[i].toString());
        }
        return points;
    }

    protected double getPrecisionAccuracy() {
        return 5e-5;
    }
}
