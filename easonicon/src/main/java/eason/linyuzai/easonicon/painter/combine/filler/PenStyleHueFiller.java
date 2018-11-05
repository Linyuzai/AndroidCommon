package eason.linyuzai.easonicon.painter.combine.filler;

import android.graphics.Paint;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenStyleInterceptor;

public class PenStyleHueFiller extends PenStyleInterceptor {

    @Override
    public Paint.Style getStyle(Painter painter, int index, Paint.Style original) {
        return Paint.Style.FILL_AND_STROKE;
    }

    @Override
    public boolean isHueFiller() {
        return true;
    }
}
