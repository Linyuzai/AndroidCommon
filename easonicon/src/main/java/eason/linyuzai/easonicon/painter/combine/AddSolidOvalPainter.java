package eason.linyuzai.easonicon.painter.combine;

import android.graphics.Paint;

import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenColorInterceptor;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenStyleInterceptor;

public class AddSolidOvalPainter extends EasonPainterSet {

    public AddSolidOvalPainter(@AuxiliaryColorField int addColor, @AuxiliaryColorField int circleColor) {
        this(0.5f, addColor, circleColor);
    }

    public AddSolidOvalPainter(@AuxiliaryScaleField float addScale, @AuxiliaryColorField int addColor,
                               @AuxiliaryColorField int circleColor) {
        addPainter(new OvalPainter());
        Painter add = new AddPainter();
        add.setCenterPercent(addScale);
        addPainter(add);
        addInterceptor(new StyleInterceptor());
        addInterceptor(new ColorInterceptor(addColor, circleColor));
    }

    private static class ColorInterceptor extends PenColorInterceptor {
        private int addColor;
        private int circleColor;

        private ColorInterceptor(int addColor, int circleColor) {
            this.addColor = addColor;
            this.circleColor = circleColor;
        }

        @Override
        public int getColor(Painter painter, int index) {
            return 0 == index ? circleColor : addColor;
        }
    }

    private static class StyleInterceptor extends PenStyleInterceptor {

        @Override
        public Paint.Style getStyle(Painter painter, int index) {
            return 0 == index ? Paint.Style.FILL_AND_STROKE : Paint.Style.STROKE;
        }
    }
}
