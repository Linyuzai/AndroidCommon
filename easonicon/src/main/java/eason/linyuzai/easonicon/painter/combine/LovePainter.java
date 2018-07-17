package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.path.CubicPainter;

public class LovePainter extends EasonPainterSet {

    private CubicPainter cubicLeft;
    private CubicPainter cubicRight;

    public LovePainter() {
        cubicLeft = new CubicPainter();
        addPainter(cubicLeft);
        cubicRight = new CubicPainter();
        addPainter(cubicRight);
        addInterceptor(new LoveInterceptor());
    }

    private class LoveInterceptor implements PainterInterceptor {

        @Override
        public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            if (painter == cubicLeft) {
                cubicLeft.setStartPoint(rectF.width() * 0.5f, rectF.height() * 0.25f);
                cubicLeft.setEndPoint(rectF.width() * 0.5f, rectF.height());
                cubicLeft.setControlPoint(0f, 0f, rectF.width() * 0.25f, rectF.height() * 0.75f);
            } else if (painter == cubicRight) {
                cubicRight.setStartPoint(rectF.width() * 0.5f, rectF.height() * 0.25f);
                cubicRight.setEndPoint(rectF.width() * 0.5f, rectF.height());
                cubicLeft.setControlPoint(rectF.width(), 0f, rectF.width() * 0.75f, rectF.height() * 0.75f);
            }
        }

        @Override
        public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {

        }
    }
}
