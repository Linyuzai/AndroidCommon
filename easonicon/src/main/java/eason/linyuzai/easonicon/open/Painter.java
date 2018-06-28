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

public interface Painter {
    void draw(Canvas canvas, RectF draw, RectF original, Paint paint);

    void drawBitmap(Canvas canvas, Bitmap bitmap, RectF draw, RectF original, Paint paint);

    Bitmap transformBitmap(RectF draw, RectF original, Paint paint);

    /**
     * 设置xy百分比，并居中
     *
     * @param centerPercent 百分比
     */
    void setCenterPercent(float centerPercent);

    /**
     * 设置xy百分比
     *
     * @param percent 百分比
     */
    void setPercent(float percent);

    /**
     * 设置xy偏移量
     *
     * @param offset 偏移量
     */
    void setOffset(float offset);

    /**
     * 设置xy偏移百分比
     *
     * @param offsetPercent 百分比
     */
    void setOffsetPercent(float offsetPercent);

    /**
     * 设置x百分比
     *
     * @param percentX x百分比
     */
    void setPercentX(float percentX);

    /**
     * 获得x百分比
     *
     * @return x百分比
     */
    float getPercentX();

    /**
     * 设置y百分比
     *
     * @param percentY y百分比
     */
    void setPercentY(float percentY);

    /**
     * 获得y百分比
     *
     * @return y百分比
     */
    float getPercentY();

    /**
     * 设置x偏移量
     *
     * @param offsetX x偏移量
     */
    void setOffsetX(float offsetX);

    /**
     * 获得x偏移量
     *
     * @return x偏移量
     */
    float getOffsetX();

    /**
     * 设置y偏移量
     *
     * @param offsetY y偏移量
     */
    void setOffsetY(float offsetY);

    /**
     * 获得y偏移量
     *
     * @return y偏移量
     */
    float getOffsetY();

    /**
     * 设置x偏移量百分比
     *
     * @param offsetPercentX x偏移量百分比
     */
    void setOffsetPercentX(float offsetPercentX);

    /**
     * 获得x偏移量百分比
     *
     * @return x偏移量百分比
     */
    float getOffsetPercentX();

    /**
     * 设置y偏移量百分比
     *
     * @param offsetPercentY y偏移量百分比
     */
    void setOffsetPercentY(float offsetPercentY);

    /**
     * 获得y偏移量百分比
     *
     * @return y偏移量百分比
     */
    float getOffsetPercentY();

    <T> T getTag();

    /**
     * 设置TAG
     *
     * @param tag tag
     */
    <T> void setTag(T tag);

    void printStructure(int deep, boolean includeInterceptor);
}
