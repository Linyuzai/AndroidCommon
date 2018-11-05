package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.support.AuxiliaryColorSupport;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.polygon.PolygonPainter;
import eason.linyuzai.easonicon.painter.combine.filler.PenColorHueFiller;
import eason.linyuzai.easonicon.painter.combine.filler.PenStyleHueFiller;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;

public class SignPainter extends SupportEasonPainterSet implements AuxiliaryColorSupport {

    public SignPainter() {
        this(Color.WHITE);
    }

    public SignPainter(int auxiliaryColor) {
        PolygonPainter polygon = new PolygonPainter(6) {
            @Override
            public PointF[] getPoints(RectF rectF, PointF[] points) {
                points[0].set(0f, 0f);
                points[1].set(0f, rectF.height() * 0.4f);
                points[2].set(rectF.width() * 0.6f, rectF.height());
                points[3].set(rectF.width() * 0.6f, rectF.height() * 0.6f);
                points[4].set(rectF.width(), rectF.height() * 0.6f);
                points[5].set(rectF.width() * 0.4f, 0f);
                for (PointF point : points)
                    getCoordinate(point, rectF);
                return points;
            }
        };
        addPainter(polygon);
        CirclePainter circle = new CirclePainter();
        circle.setPercent(0.25f);
        circle.setOffsetPercent(0.15f);
        addPainter(circle);
        addInterceptor(new AuxiliaryColorInterceptor(auxiliaryColor));

        addInterceptor(new PenStyleHueFiller());
        addInterceptor(new PenColorHueFiller());
    }
}
