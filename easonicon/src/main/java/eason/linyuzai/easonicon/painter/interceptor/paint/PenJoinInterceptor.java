package eason.linyuzai.easonicon.painter.interceptor.paint;

import android.graphics.Paint;

import eason.linyuzai.easonicon.open.Painter;

public abstract class PenJoinInterceptor extends PaintInterceptor {

    private Paint.Join restoreJoin;

    @Override
    public void beforeDraw(Painter painter, Paint paint, int index) {
        restoreJoin = paint.getStrokeJoin();
        paint.setStrokeJoin(getJoin(painter, index));
    }

    @Override
    public void afterDraw(Painter painter, Paint paint, int index) {
        paint.setStrokeJoin(restoreJoin);
    }

    public abstract Paint.Join getJoin(Painter painter, int index);
}
