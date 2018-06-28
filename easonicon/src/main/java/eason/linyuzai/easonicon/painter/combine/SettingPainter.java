package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.polygon.ExtraPolygonPainter;
import eason.linyuzai.easonicon.painter.interceptor.mode.DstOutPorterDuffModeInterceptor;

public class SettingPainter extends EasonPainterSet {

    private ExtraPolygonPainter polygon;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SettingPainter() {
        polygon = new ExtraPolygonPainter(8, 0f);
        polygon.setCenterPercent(0.5f);
        addPainter(polygon);
        CirclePainter circle = new CirclePainter();
        circle.setCenterPercent(0.45f);
        addPainter(circle);
        addInterceptor(new SettingInterceptor());
        addInterceptor(new DstOutPorterDuffModeInterceptor());
    }

    private class SettingInterceptor implements PainterInterceptor {

        private RectF rectF = new RectF();
        private float extraOffset;
        private float polygonPenSize;
        private float circlePenSize;
        private Paint.Style style;
        private Paint.Cap cap;

        @Override
        public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            this.rectF.set(rectF);
            float size = Math.min(rectF.width(), rectF.height());
            rectF.left += (rectF.width() - size) * 0.5;
            rectF.right -= (rectF.width() - size) * 0.5;
            rectF.top += (rectF.height() - size) * 0.5;
            rectF.bottom -= (rectF.height() - size) * 0.5;

            style = paint.getStyle();
            cap = paint.getStrokeCap();

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            if (painter instanceof ExtraPolygonPainter) {
                extraOffset = polygon.getExtraOffset();
                polygonPenSize = paint.getStrokeWidth();
                polygon.setExtraOffset(-size * 0.56f);
                paint.setStrokeWidth(size * 0.11f);
            } else if (painter instanceof CirclePainter) {
                circlePenSize = paint.getStrokeWidth();
                paint.setStrokeWidth(size * 0.1f);
            }
        }

        @Override
        public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            rectF.set(this.rectF);
            paint.setStyle(style);
            paint.setStrokeCap(cap);
            if (painter instanceof ExtraPolygonPainter) {
                polygon.setExtraOffset(extraOffset);
                paint.setStrokeWidth(polygonPenSize);
            } else if (painter instanceof CirclePainter) {
                paint.setStrokeWidth(circlePenSize);
            }
        }
    }
}
