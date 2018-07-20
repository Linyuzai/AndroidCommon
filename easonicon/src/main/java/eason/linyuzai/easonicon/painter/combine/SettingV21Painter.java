package eason.linyuzai.easonicon.painter.combine;

import android.os.Build;
import android.support.annotation.RequiresApi;

import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.PenSizeScaleField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.support.AuxiliaryScaleSupport;
import eason.linyuzai.easonicon.open.support.PenSizeScaleSupport;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.polygon.ExtraPolygonPainter;
import eason.linyuzai.easonicon.painter.combine.interceptor.PenSizeScaleInterceptor;
import eason.linyuzai.easonicon.painter.interceptor.mode.DstOutPorterDuffModeInterceptor;

@AuxiliaryScaleField
@PenSizeScaleField
public class SettingV21Painter extends SupportEasonPainterSet implements AuxiliaryScaleSupport, PenSizeScaleSupport {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SettingV21Painter() {
        this(0.5f, 1f);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SettingV21Painter(float auxiliaryScale, float penSizeScale) {
        ExtraPolygonPainter polygon = new ExtraPolygonPainter(8);
        polygon.setCenterPercent(0.5f);
        addPainter(polygon);
        Painter painter = new CirclePainter();
        //setAuxiliaryScale(auxiliaryScale);
        painter.setCenterPercent(0.7f * auxiliaryScale);
        setAuxiliaryScalePainter(painter);
        addPainter(painter);
        addInterceptor(new SettingPainter.SettingInterceptor(polygon));
        addInterceptor(new PenSizeScaleInterceptor(painter, penSizeScale, 0.1f));
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
}
