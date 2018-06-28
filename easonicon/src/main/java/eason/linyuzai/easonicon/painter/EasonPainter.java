package eason.linyuzai.easonicon.painter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Size;
import android.util.Log;

import eason.linyuzai.easonicon.open.Painter;

/**
 * Created by linyuzai on 2018/5/19.
 * 绘制者
 *
 * @author linyuzai
 */

public abstract class EasonPainter implements Painter {

    private Object tag;

    private float percentX = 1f;//x百分比
    private float percentY = 1f;//y百分比

    private float offsetX = 0f;//x偏移
    private float offsetY = 0f;//y偏移

    private float offsetPercentX = 0f;//x偏移百分比，相对控件宽度
    private float offsetPercentY = 0f;//y偏移百分比，相对控件高度

    @Override
    public Bitmap transformBitmap(RectF draw, RectF original, Paint paint) {
        Bitmap bitmap = Bitmap.createBitmap((int) original.width(), (int) original.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        draw(canvas, draw, original, paint);
        return bitmap;
    }

    @Override
    public void drawBitmap(Canvas canvas, Bitmap bitmap, RectF draw, RectF original, Paint paint) {
        canvas.drawBitmap(bitmap, null, original, paint);
    }

    /**
     * 设置xy百分比，并居中
     *
     * @param centerPercent 百分比
     * @see EasonPainter#setPercent(float)
     * @see EasonPainter#setOffsetPercent(float)
     */
    @Override
    public void setCenterPercent(float centerPercent) {
        setPercent(centerPercent);
        setOffsetPercent((1f - centerPercent) * 0.5f);
    }

    /**
     * 设置xy百分比
     *
     * @param percent 百分比
     * @see EasonPainter#setPercentX(float)
     * @see EasonPainter#setPercentY(float)
     */
    @Override
    public void setPercent(float percent) {
        setPercentX(percent);
        setPercentY(percent);
    }

    /**
     * 设置xy偏移量
     *
     * @param offset 偏移量
     * @see EasonPainter#setOffsetX(float)
     * @see EasonPainter#setOffsetY(float)
     */
    @Override
    public void setOffset(float offset) {
        setOffsetX(offset);
        setOffsetY(offset);
    }

    /**
     * 设置xy偏移百分比
     *
     * @param offsetPercent 百分比
     * @see EasonPainter#setOffsetPercentX(float)
     * @see EasonPainter#setOffsetPercentY(float)
     */
    @Override
    public void setOffsetPercent(float offsetPercent) {
        setOffsetPercentX(offsetPercent);
        setOffsetPercentY(offsetPercent);
    }

    /**
     * 设置x百分比
     *
     * @param percentX x百分比
     */
    @Override
    public void setPercentX(float percentX) {
        this.percentX = percentX;
    }

    /**
     * 获得x百分比
     *
     * @return x百分比
     */
    @Override
    public float getPercentX() {
        return percentX;
    }

    /**
     * 设置y百分比
     *
     * @param percentY y百分比
     */
    @Override
    public void setPercentY(float percentY) {
        this.percentY = percentY;
    }

    /**
     * 获得y百分比
     *
     * @return y百分比
     */
    @Override
    public float getPercentY() {
        return percentY;
    }

    /**
     * 设置x偏移量
     *
     * @param offsetX x偏移量
     */
    @Override
    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    /**
     * 获得x偏移量
     *
     * @return x偏移量
     */
    @Override
    public float getOffsetX() {
        return offsetX;
    }

    /**
     * 设置y偏移量
     *
     * @param offsetY y偏移量
     */
    @Override
    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }

    /**
     * 获得y偏移量
     *
     * @return y偏移量
     */
    @Override
    public float getOffsetY() {
        return offsetY;
    }

    /**
     * 设置x偏移量百分比
     *
     * @param offsetPercentX x偏移量百分比
     */
    @Override
    public void setOffsetPercentX(float offsetPercentX) {
        this.offsetPercentX = offsetPercentX;
    }

    /**
     * 获得x偏移量百分比
     *
     * @return x偏移量百分比
     */
    @Override
    public float getOffsetPercentX() {
        return offsetPercentX;
    }

    /**
     * 设置y偏移量百分比
     *
     * @param offsetPercentY y偏移量百分比
     */
    @Override
    public void setOffsetPercentY(float offsetPercentY) {
        this.offsetPercentY = offsetPercentY;
    }

    /**
     * 获得y偏移量百分比
     *
     * @return y偏移量百分比
     */
    @Override
    public float getOffsetPercentY() {
        return offsetPercentY;
    }

    /**
     * 获得TAG
     *
     * @return tag
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getTag() {
        return (T) tag;
    }

    /**
     * 设置TAG
     *
     * @param tag tag
     */
    @Override
    public <T> void setTag(T tag) {
        this.tag = tag;
    }

    @Override
    public void printStructure(int deep, boolean includeInterceptor) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < deep; i++) {
            builder.append("    ");
        }
        builder.append("[").append(getClass().toString()).append("]");
        Log.i("printStructure", builder.toString());
    }

    public final PointF getCenter(PointF pointF, RectF rectF) {
        //return getCoordinate(center, rectF);
        pointF.x = rectF.centerX();
        pointF.y = rectF.centerY();
        return pointF;
    }

    /**
     * 缩放平移point
     *
     * @param point 被缩放平移的point
     * @param rectF 在rectF平面上缩放平移
     * @return 缩放平移后的point
     */
    public final PointF getCoordinate(PointF point, RectF rectF) {
        //Log.d("getCoordinate", (getOffsetPercentX() * rectF.width()) + "");
        point.x = point.x * getPercentX() + rectF.left + getOffsetPercentX() * rectF.width() + getOffsetX();
        point.y = point.y * getPercentY() + rectF.top + getOffsetPercentY() * rectF.height() + getOffsetY();
        return point;
    }

    /**
     * 缩放平移rectF
     *
     * @param rectF 被缩放平移的rectF
     * @return 缩放平移后的rectF
     */
    public final RectF getRectF(RectF rectF) {
        RectF newRectF = new RectF();
        //newRectF.top = rectF.top + rectF.height() * (1f - getPercentY()) * 0.5f + getOffsetPercentY() * rectF.height() + getOffsetY();
        //newRectF.bottom = rectF.bottom - rectF.height() * (1f - getPercentY()) * 0.5f + getOffsetPercentY() * rectF.height() + getOffsetY();
        //newRectF.left = rectF.left + rectF.width() * (1f - getPercentX()) * 0.5f + getOffsetPercentX() * rectF.width() + getOffsetX();
        //newRectF.right = rectF.right - rectF.width() * (1f - getPercentX()) * 0.5f + getOffsetPercentX() * rectF.width() + getOffsetX();
        PointF topLeft = getCoordinate(new PointF(0f, 0f), rectF);
        PointF bottomRight = getCoordinate(new PointF(rectF.width(), rectF.height()), rectF);
        newRectF.top = topLeft.y;
        newRectF.bottom = bottomRight.y;
        newRectF.left = topLeft.x;
        newRectF.right = bottomRight.x;
        return newRectF;
    }

    public final RectF getTransformRectF(RectF rectF, Paint paint) {
        float ex = paint.getStrokeWidth() * 0.5f;
        RectF mRectF = getRectF(rectF);
        return new RectF(mRectF.left + ex, mRectF.top + ex, mRectF.right - ex, mRectF.bottom - ex);
    }
}
