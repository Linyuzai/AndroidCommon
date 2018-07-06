package eason.linyuzai.easonicon.open;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by linyuzai on 2018/5/19.
 *
 * @author linyuzai
 */

public interface Painter extends RectSupport {
    void draw(Canvas canvas, RectF draw, RectF original, Paint paint);

    void drawBitmap(Canvas canvas, Bitmap bitmap, RectF draw, RectF original, Paint paint);

    Bitmap transformBitmap(RectF draw, RectF original, Paint paint);

    <T> T getTag();

    /**
     * 设置TAG
     *
     * @param tag tag
     */
    <T> void setTag(T tag);

    void printStructure(int deep, boolean includeInterceptor);
}
