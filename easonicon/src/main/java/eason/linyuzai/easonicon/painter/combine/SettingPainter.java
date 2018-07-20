package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.PenSizeScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.open.support.AuxiliaryColorSupport;
import eason.linyuzai.easonicon.open.support.AuxiliaryScaleSupport;
import eason.linyuzai.easonicon.open.support.PenSizeScaleSupport;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.polygon.ExtraPolygonPainter;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;
import eason.linyuzai.easonicon.painter.combine.interceptor.PenSizeScaleInterceptor;

@AuxiliaryScaleField
@AuxiliaryColorField
@PenSizeScaleField
public class SettingPainter extends SupportEasonPainterSet implements AuxiliaryScaleSupport, AuxiliaryColorSupport, PenSizeScaleSupport {

    public SettingPainter() {
        this(Color.WHITE);
    }

    public SettingPainter(int auxiliaryColor) {
        this(0.5f, auxiliaryColor, 1f);
    }

    public SettingPainter(float auxiliaryScale, int auxiliaryColor, float penSizeScale) {
        ExtraPolygonPainter polygon = new ExtraPolygonPainter(8);
        polygon.setCenterPercent(0.5f);
        addPainter(polygon);
        Painter painter = new CirclePainter();
        painter.setCenterPercent(0.7f * auxiliaryScale);
        setAuxiliaryScalePainter(painter);
        //setAuxiliaryScale(auxiliaryScale);
        addPainter(painter);
        addInterceptor(new SettingInterceptor(polygon));
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor));
        addInterceptor(new PenSizeScaleInterceptor(painter, penSizeScale, 0.1f));
    }

    @Override
    public float getAuxiliaryScale() {
        return super.getAuxiliaryScale() / 0.7f;
    }

    @Override
    public void setAuxiliaryScale(float auxiliaryScale) {
        super.setAuxiliaryScale(auxiliaryScale * 0.7f);
    }

    public static class SettingInterceptor implements PainterInterceptor {

        private ExtraPolygonPainter polygon;

        private RectF rectF = new RectF();
        private float polygonPenSize;
        private Paint.Style style;
        private Paint.Cap cap;

        public SettingInterceptor(ExtraPolygonPainter polygon) {
            this.polygon = polygon;
        }

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
            }
        }

        @Override
        public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            rectF.set(this.rectF);
            paint.setStyle(style);
            paint.setStrokeCap(cap);
            if (painter instanceof ExtraPolygonPainter) {
                paint.setStrokeWidth(polygonPenSize);
            }
        }
    }
}
