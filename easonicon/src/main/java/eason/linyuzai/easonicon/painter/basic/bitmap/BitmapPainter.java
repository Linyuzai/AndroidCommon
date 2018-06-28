package eason.linyuzai.easonicon.painter.basic.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;

import eason.linyuzai.easonicon.annotation.BitmapField;
import eason.linyuzai.easonicon.painter.EasonPainter;

public class BitmapPainter extends EasonPainter {

    private Bitmap bitmap;
    private boolean isHandled;

    public BitmapPainter() {
    }

    public BitmapPainter(@BitmapField Bitmap bitmap) {
        setBitmap(bitmap);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        isHandled = false;
    }

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        if (!isHandled) {
            isHandled = true;
            bitmap = handleBitmap(bitmap, draw);
        }
        if (bitmap == null || bitmap.isRecycled())
            return;
        drawBitmap(canvas, bitmap, draw, getOffsetRectF(bitmap, draw), paint);
    }

    public Bitmap handleBitmap(@Nullable Bitmap bitmap, RectF rectF) {
        if (bitmap == null) {
            return null;
        }
        float scaleX = rectF.width() / bitmap.getWidth();// 宽的比例
        float scaleY = rectF.height() / bitmap.getHeight();// 高的比例
        //新的宽高
        int newW = 0;
        int newH = 0;
        if (scaleX > scaleY) {
            newW = (int) (bitmap.getWidth() * scaleX);
            newH = (int) (bitmap.getHeight() * scaleX);
        } else if (scaleX <= scaleY) {
            newW = (int) (bitmap.getWidth() * scaleY);
            newH = (int) (bitmap.getHeight() * scaleY);
        }
        return Bitmap.createScaledBitmap(bitmap, newW, newH, true);
    }

    public RectF getOffsetRectF(Bitmap bitmap, RectF rectF) {
        RectF newRectF = new RectF(rectF);
        newRectF.left += (rectF.width() - bitmap.getWidth()) * 0.5f;
        newRectF.top += (rectF.height() - bitmap.getHeight()) * 0.5f;
        return newRectF;
    }
}
