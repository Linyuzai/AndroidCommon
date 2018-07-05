package eason.linyuzai.easonicon.painter.basic.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;

import java.lang.ref.WeakReference;

import eason.linyuzai.easonicon.annotation.BitmapField;
import eason.linyuzai.easonicon.painter.EasonPainter;

@BitmapField
public class BitmapPainter extends EasonPainter {

    private Bitmap bitmap;
    private WeakReference<Bitmap> handled = new WeakReference<>(null);

    public BitmapPainter() {
    }

    public BitmapPainter(Bitmap bitmap) {
        setBitmap(bitmap);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getHandled() {
        return handled.get();
    }

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        Bitmap bmp = handled.get();
        if ((bmp == null || bmp.isRecycled()) && bitmap != null && !bitmap.isRecycled()) {
            handled = new WeakReference<>(handleBitmap(bitmap, draw));
            bmp = handled.get();
        }
        if (bmp == null || bmp.isRecycled())
            return;
        drawBitmap(canvas, bmp, draw, getOffsetRectF(bmp, draw), paint);
    }

    public Bitmap handleBitmap(@Nullable Bitmap bitmap, RectF rectF) {
        if (bitmap == null) {
            return null;
        }
        float scaleX = bitmap.getWidth() / rectF.width();// 宽的比例
        float scaleY = bitmap.getHeight() / rectF.height();// 高的比例
        //新的宽高
        int newW;
        int newH;
        if (scaleX >= scaleY) {
            newW = (int) (bitmap.getWidth() / scaleX);
            newH = (int) (bitmap.getHeight() / scaleX);
        } else {
            newW = (int) (bitmap.getWidth() / scaleY);
            newH = (int) (bitmap.getHeight() / scaleY);
        }
        return Bitmap.createScaledBitmap(bitmap, newW, newH, true);
    }

    public RectF getOffsetRectF(Bitmap bitmap, RectF rectF) {
        RectF newRectF = new RectF(rectF);
        newRectF.left += (rectF.width() - bitmap.getWidth()) * 0.5f;
        newRectF.right -= (rectF.width() - bitmap.getWidth()) * 0.5f;
        newRectF.top += (rectF.height() - bitmap.getHeight()) * 0.5f;
        newRectF.bottom -= (rectF.height() - bitmap.getHeight()) * 0.5f;
        return newRectF;
    }

    public static Bitmap getBitmapFromDrawable(Drawable drawable) {
        // 取 drawable 的长宽
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        // 取 drawable 的颜色格式
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        // 建立对应 bitmap
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        // 建立对应 bitmap 的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        // 把 drawable 内容画到画布中
        drawable.draw(canvas);
        return bitmap;
    }
}
