package eason.linyuzai.easonicon.painter.basic.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.painter.EasonPainter;

public class TextPainter extends EasonPainter {
    private String text;

    public TextPainter() {
    }

    public TextPainter(String text) {
        this.text = text;
    }

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        //paint.setTex
        if (text == null)
            return;
        RectF rectF = getRectF(draw);
        canvas.drawText(text, rectF.left, rectF.top, paint);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
