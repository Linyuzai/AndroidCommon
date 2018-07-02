package eason.linyuzai.easonicon.painter.basic.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.painter.EasonPainter;

public class TextPainter extends EasonPainter {
    private String text;

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        //paint.setTex
        canvas.drawText(text, 0, 0, paint);
    }
}
