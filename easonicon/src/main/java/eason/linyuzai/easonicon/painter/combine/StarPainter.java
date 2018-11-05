package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.polygon.ExtraPolygonPainter;
import eason.linyuzai.easonicon.painter.combine.filler.PenStyleHueFiller;

public class StarPainter extends EasonPainterSet {

    private ExtraPolygonPainter extraPolygon;

    public StarPainter() {
        extraPolygon = new ExtraPolygonPainter(5);
        addPainter(extraPolygon);
        addInterceptor(new StarInterceptor());

        addInterceptor(new PenStyleHueFiller());
    }

    private class StarInterceptor implements PainterInterceptor {

        @Override
        public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
            if (painter instanceof ExtraPolygonPainter) {
                extraPolygon.setExtraOffset(-0.2f * Math.min(rectF.width(), rectF.height()));
            }
        }

        @Override
        public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {

        }
    }
}
