package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.path.CubicPainter;
import eason.linyuzai.easonicon.painter.combine.filler.PenStyleHueFiller;

public class LovePainter extends EasonPainterSet {

    private CubicPainter cubicLeft;
    private CubicPainter cubicRight;

    public LovePainter() {
        cubicLeft = new CubicPainter();
        cubicLeft.setOffsetX(0.5f);
        cubicRight = new CubicPainter();
        cubicRight.setOffsetX(-0.5f);
        addPainter(cubicLeft);
        addPainter(cubicRight);
        addInterceptor(new LoveInterceptor());

        addInterceptor(new PenStyleHueFiller());
    }

    private class LoveInterceptor implements PainterInterceptor {

        @Override
        public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            if (painter == cubicLeft) {
                cubicLeft.setStartPoint(rectF.width() * 0.5f, rectF.height() * 0.3f);
                cubicLeft.setEndPoint(rectF.width() * 0.5f, rectF.height() * 0.78f);
                cubicLeft.setControlPoint(rectF.width() * 0.25f, rectF.height() * 0.1f, 0f, rectF.height() * 0.5f);
            } else if (painter == cubicRight) {
                cubicRight.setStartPoint(rectF.width() * 0.5f, rectF.height() * 0.3f);
                cubicRight.setEndPoint(rectF.width() * 0.5f, rectF.height() * 0.78f);
                cubicRight.setControlPoint(rectF.width() * 0.75f, rectF.height() * 0.1f, rectF.width(), rectF.height() * 0.5f);
            }
        }

        @Override
        public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {

        }
    }
}
