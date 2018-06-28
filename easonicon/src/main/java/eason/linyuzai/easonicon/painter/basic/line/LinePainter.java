package eason.linyuzai.easonicon.painter.basic.line;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

import eason.linyuzai.easonicon.painter.EasonPainter;

/**
 * Created by linyuzai on 2018/5/21.
 * 线
 *
 * @author linyuzai
 */

public class LinePainter extends EasonPainter {

    public static class Type {
        public static final int VERTICAL = 1;
        public static final int HORIZONTAL = 2;
        public static final int SLOPE_POSITIVE = 3;
        public static final int SLOPE_NEGATIVE = 4;
    }

    private int type;

    public LinePainter(int type) {
        setType(type);
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        float startPointX = 0f;
        float startPointY = 0f;
        float endPointX = 0f;
        float endPointY = 0f;
        switch (type) {
            case Type.VERTICAL:
                startPointX = draw.width() * 0.5f;
                startPointY = 0f;
                endPointX = draw.width() * 0.5f;
                endPointY = draw.height();
                break;
            case Type.HORIZONTAL:
                startPointX = 0f;
                startPointY = draw.height() * 0.5f;
                endPointX = draw.width();
                endPointY = draw.height() * 0.5f;
                break;
            case Type.SLOPE_POSITIVE:
                startPointX = 0f;
                startPointY = 0f;
                endPointX = draw.width();
                endPointY = draw.height();
                break;
            case Type.SLOPE_NEGATIVE:
                startPointX = 0f;
                startPointY = draw.height();
                endPointX = draw.width();
                endPointY = 0f;
                break;
        }
        PointF start = getCoordinate(new PointF(startPointX, startPointY), draw);
        PointF end = getCoordinate(new PointF(endPointX, endPointY), draw);
        canvas.drawLine(start.x, start.y, end.x, end.y, paint);
    }
}
