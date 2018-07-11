package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.PenSizeScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.open.support.AuxiliaryScaleSupport;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.polygon.ExtraPolygonPainter;
import eason.linyuzai.easonicon.painter.interceptor.mode.DstOutPorterDuffModeInterceptor;

@AuxiliaryScaleField
@PenSizeScaleField
public class SettingV21Painter extends SupportEasonPainterSet implements AuxiliaryScaleSupport {

    private ExtraPolygonPainter polygon;
    private float penSizeScale;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SettingV21Painter() {
        this(0.5f, 1f);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SettingV21Painter(float auxiliaryScale, float penSizeScale) {
        setPenSizeScale(penSizeScale);
        polygon = new ExtraPolygonPainter(8);
        polygon.setCenterPercent(0.5f);
        addPainter(polygon);
        Painter painter = new CirclePainter();
        //setAuxiliaryScale(auxiliaryScale);
        painter.setCenterPercent(0.7f * auxiliaryScale);
        setAuxiliaryScalePainter(painter);
        addPainter(painter);
        addInterceptor(new SettingInterceptor());
        addInterceptor(new DstOutPorterDuffModeInterceptor());
    }

    @Override
    public float getAuxiliaryScale() {
        return super.getAuxiliaryScale() / 0.7f;
    }

    @Override
    public void setAuxiliaryScale(float auxiliaryScale) {
        super.setAuxiliaryScale(auxiliaryScale * 0.7f);
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
