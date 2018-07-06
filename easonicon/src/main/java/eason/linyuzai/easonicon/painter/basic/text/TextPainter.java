package eason.linyuzai.easonicon.painter.basic.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.annotation.TextField;
import eason.linyuzai.easonicon.painter.EasonPainter;

@TextField
public class TextPainter extends EasonPainter {
    private String text;
    private boolean isDefaultSize = true;
    private float penSize;

    public TextPainter() {
    }

    public TextPainter(String text) {
        this.text = text;
    }

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        if (text == null)
            return;
        RectF rectF = getRectF(draw);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        final boolean isDefaultSize = isDefaultSize();
        if (isDefaultSize) {
            penSize = paint.getStrokeWidth();
            paint.setStrokeWidth(0f);
        }
        canvas.drawText(text, rectF.left, rectF.top - fontMetrics.ascent, paint);
        if (isDefaultSize) {
            paint.setStrokeWidth(penSize);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDefaultSize() {
        return isDefaultSize;
    }

    public void setDefaultSize(boolean defaultSize) {
        isDefaultSize = defaultSize;
    }
}
