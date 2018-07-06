package eason.linyuzai.androidcommon;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterSet;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.polygon.PolygonPainter;
import eason.linyuzai.easonicon.painter.basic.rect.RoundRectPainter;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenColorInterceptor;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenSizeInterceptor;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenStyleInterceptor;
import eason.linyuzai.elib.component.EasonActivity;

public class LibraryHelper {
    public static final String MEMORY_LIBRARY_PARAM = "memory_library_param";

    public static void init(EasonActivity eason) {
        List<LibraryParam> libraryParams = new ArrayList<>();
        libraryParams.add(getEasonIconLibraryParam(eason));
        eason.memory().unsafe(MEMORY_LIBRARY_PARAM, libraryParams);
    }

    public static List<LibraryHelper.LibraryParam> getLibraryParam(EasonActivity eason) {
        return eason.memory().unsafe(LibraryHelper.MEMORY_LIBRARY_PARAM);
    }

    private static LibraryParam getEasonIconLibraryParam(EasonActivity eason) {
        PainterSet painterSet = new EasonPainterSet();

        Painter circle = new CirclePainter();
        circle.setPercent(0.5f);
        circle.setOffsetPercentX(0.48f);
        circle.setOffsetPercentY(0.2f);
        painterSet.addPainter(circle);

        Painter rect = new RoundRectPainter(eason.dip(10));
        rect.setPercentX(0.4f);
        rect.setPercentY(0.55f);
        rect.setOffsetPercentX(0.08f);
        rect.setOffsetPercentY(0.05f);
        painterSet.addPainter(rect);

        Painter triangle = new PolygonPainter();
        triangle.setPercent(0.5f);
        triangle.setOffsetPercentX(0.35f);
        triangle.setOffsetPercentY(0.1f);
        painterSet.addPainter(triangle);

        painterSet.addInterceptor(new PenColorInterceptor() {
            @Override
            public int getColor(Painter painter, int index, int original) {
                return Color.WHITE;
            }
        });
        painterSet.addInterceptor(new PenStyleInterceptor() {
            @Override
            public Paint.Style getStyle(Painter painter, int index, Paint.Style original) {
                return Paint.Style.STROKE;
            }
        });
        painterSet.addInterceptor(new PenSizeInterceptor() {
            @Override
            public float getPenSize(Painter painter, int index, float original) {
                return eason.dip(8);
            }
        });
        return new LibraryParam(Color.parseColor("#0099cc"), Color.parseColor("#33b5e5"),
                Color.parseColor("#330099cc"), painterSet, "Eason Icon");
    }

    public static class LibraryParam {
        private int titleColor;
        private int contentColor;
        private int backgroundColor;
        private Painter painter;
        private String text;

        private LibraryParam(int titleColor, int contentColor, int backgroundColor, Painter painter, String text) {
            this.titleColor = titleColor;
            this.contentColor = contentColor;
            this.backgroundColor = backgroundColor;
            this.painter = painter;
            this.text = text;
        }

        public int getTitleColor() {
            return titleColor;
        }

        public void setTitleColor(int titleColor) {
            this.titleColor = titleColor;
        }

        public int getContentColor() {
            return contentColor;
        }

        public void setContentColor(int contentColor) {
            this.contentColor = contentColor;
        }

        public int getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        public Painter getPainter() {
            return painter;
        }

        public void setPainter(Painter painter) {
            this.painter = painter;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

}
