package eason.linyuzai.easonicon.painter.combine.interceptor;

import android.graphics.Paint;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenStyleInterceptor;

public class AuxiliaryStyleInterceptor extends PenStyleInterceptor {
    @Override
    public Paint.Style getStyle(Painter painter, int index, Paint.Style original) {
        return 0 == index ? Paint.Style.FILL_AND_STROKE : Paint.Style.STROKE;
    }
}
