package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.PenSizeScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.polygon.ExtraPolygonPainter;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;
import eason.linyuzai.easonicon.painter.interceptor.mode.DstOutPorterDuffModeInterceptor;

@AuxiliaryScaleField
@AuxiliaryColorField
@PenSizeScaleField
public class SettingPainter extends EasonPainterSet {

    private ExtraPolygonPainter polygon;
    private CirclePainter circle;
    private float auxiliaryScale;
    private float penSizeScale;

    public SettingPainter(int auxiliaryColor) {
        this(0.5f, auxiliaryColor, 1f);
    }

    public SettingPainter(float auxiliaryScale, int auxiliaryColor, float penSizeScale) {
        setPenSizeScale(penSizeScale);
        polygon = new ExtraPolygonPainter(8);
        polygon.setCenterPercent(0.5f);
        addPainter(polygon);
        circle = new CirclePainter();
        //circle.setCenterPercent(0.35f);
        setAuxiliaryScale(auxiliaryScale);
        addPainter(circle);
        addInterceptor(new SettingInterceptor());
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor));
    }

    public float getAuxiliaryScale() {
        return auxiliaryScale;
    }

    public void setAuxiliaryScale(float auxiliaryScale) {
        this.auxiliaryScale = auxiliaryScale;
        circle.setCenterPercent(0.7f * auxiliaryScale);
    }

    public float getPenSizeScale() {
        return penSizeScale;
    }

    public void setPenSizeScale(float penSizeScale) {
        this.penSizeScale = penSizeScale;
    }

    @Override
    public float getDefaultPercent() {
        return 0.5f;
    }

    private class SettingInterceptor implements PainterInterceptor {

        private RectF rectF = new RectF();
        private float polygonPenSize;
        private float circlePenSize;
        private Paint.Style style;
        private Paint.Cap cap;

        @Override
        public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            this.rectF.set(rectF);
            float size = Math.min(rectF.width(), rectF.height());
            rectF.left += (rectF.width() - size) * 0.5f;
            rectF.right -= (rectF.width() - size) * 0.5f;
            rectF.top += (rectF.height() - size) * 0.5f;
            rectF.bottom -= (rectF.height() - size) * 0.5f;

            style = paint.getStyle();
            cap = paint.getStrokeCap();

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            if (painter instanceof ExtraPolygonPainter) {
                polygonPenSize = paint.getStrokeWidth();
                polygon.setExtraOffset(-size * 0.56f);
                paint.setStrokeWidth(size * 0.11f);
            } else if (painter instanceof CirclePainter) {
                circlePenSize = paint.getStrokeWidth();
                paint.setStrokeWidth(size * 0.1f * getPenSizeScale());
            }
        }

        @Override
        public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            rectF.set(this.rectF);
            paint.setStyle(style);
            paint.setStrokeCap(cap);
            if (painter instanceof ExtraPolygonPainter) {
                paint.setStrokeWidth(polygonPenSize);
            } else if (painter instanceof CirclePainter) {
                paint.setStrokeWidth(circlePenSize);
            }
        }
    }
}
