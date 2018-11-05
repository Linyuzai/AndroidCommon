package eason.linyuzai.easonicon.painter.combine.filler;

import android.graphics.Color;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenColorInterceptor;

public class PenColorHueFiller extends PenColorInterceptor {

    @Override
    public int getColor(Painter painter, int index, int original) {
        return index == 0 ? original : Color.WHITE;
    }

    @Override
    public boolean isHueFiller() {
        return true;
    }

}
