package eason.linyuzai.easonicon.painter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
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

    private boolean canDraw = true;

    private RectParam rectParam = new RectParam();

    private RectF tempRectF = new RectF();
    private PointF topLeft = new PointF();
    private PointF rightBottom = new PointF();

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

    @Override
    public boolean canDraw() {
        return canDraw;
    }

    @Override
    public void setCanDraw(boolean canDraw) {
        this.canDraw = canDraw;
    }

    /**
     * 设置x百分比
     *
     * @param percentX x百分比
     */
    @Override
    public void setPercentX(float percentX) {
        rectParam.setPercentX(percentX);
    }

    /**
     * 获得x百分比
     *
     * @return x百分比
     */
    @Override
    public float getPercentX() {
        return rectParam.getPercentX();
    }

    /**
     * 设置y百分比
     *
     * @param percentY y百分比
     */
    @Override
    public void setPercentY(float percentY) {
        rectParam.setPercentY(percentY);
    }

    /**
     * 获得y百分比
     *
     * @return y百分比
     */
    @Override
    public float getPercentY() {
        return rectParam.getPercentY();
    }

    /**
     * 设置x偏移量
     *
     * @param offsetX x偏移量
     */
    @Override
    public void setOffsetX(float offsetX) {
        rectParam.setOffsetX(offsetX);
    }

    /**
     * 获得x偏移量
     *
     * @return x偏移量
     */
    @Override
    public float getOffsetX() {
        return rectParam.getOffsetX();
    }

    /**
     * 设置y偏移量
     *
     * @param offsetY y偏移量
     */
    @Override
    public void setOffsetY(float offsetY) {
        rectParam.setOffsetY(offsetY);
    }

    /**
     * 获得y偏移量
     *
     * @return y偏移量
     */
    @Override
    public float getOffsetY() {
        return rectParam.getOffsetY();
    }

    /**
     * 设置x偏移量百分比
     *
     * @param offsetPercentX x偏移量百分比
     */
    @Override
    public void setOffsetPercentX(float offsetPercentX) {
        rectParam.setOffsetPercentX(offsetPercentX);
    }

    /**
     * 获得x偏移量百分比
     *
     * @return x偏移量百分比
     */
    @Override
    public float getOffsetPercentX() {
        return rectParam.getOffsetPercentX();
    }

    /**
     * 设置y偏移量百分比
     *
     * @param offsetPercentY y偏移量百分比
     */
    @Override
    public void setOffsetPercentY(float offsetPercentY) {
        rectParam.setOffsetPercentY(offsetPercentY);
    }

    /**
     * 获得y偏移量百分比
     *
     * @return y偏移量百分比
     */
    @Override
    public float getOffsetPercentY() {
        return rectParam.getOffsetPercentY();
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

    /**
     * 获得中心点坐标
     *
     * @param pointF point
     * @param rectF  区域
     * @return 该区域的中心点
     */
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
        //newRectF.top = rectF.top + rectF.height() * (1f - getPercentY()) * 0.5f + getOffsetPercentY() * rectF.height() + getOffsetY();
        //newRectF.bottom = rectF.bottom - rectF.height() * (1f - getPercentY()) * 0.5f + getOffsetPercentY() * rectF.height() + getOffsetY();
        //newRectF.left = rectF.left + rectF.width() * (1f - getPercentX()) * 0.5f + getOffsetPercentX() * rectF.width() + getOffsetX();
        //newRectF.right = rectF.right - rectF.width() * (1f - getPercentX()) * 0.5f + getOffsetPercentX() * rectF.width() + getOffsetX();
        topLeft.set(0f, 0f);
        rightBottom.set(rectF.width(), rectF.height());
        getCoordinate(topLeft, rectF);
        getCoordinate(rightBottom, rectF);
        tempRectF.top = topLeft.y;
        tempRectF.bottom = rightBottom.y;
        tempRectF.left = topLeft.x;
        tempRectF.right = rightBottom.x;
        return tempRectF;
    }

    /**
     * 适配画笔宽度的绘制区域
     *
     * @param rectF 原绘制区域
     * @param paint 画笔
     * @return 处理参数后的绘制区域
     */
    public final RectF getRectF(RectF rectF, Paint paint) {
        float ex = paint.getStrokeWidth() * 0.5f;
        RectF mRectF = getRectF(rectF);
        mRectF.left += ex;
        mRectF.top += ex;
        mRectF.right -= ex;
        mRectF.bottom -= ex;
        return mRectF;
    }

    /**
     * 绘制区域参数
     */
    public static class RectParam {
        private float percentX = 1f;//x百分比
        private float percentY = 1f;//y百分比

        private float offsetX = 0f;//x偏移
        private float offsetY = 0f;//y偏移

        private float offsetPercentX = 0f;//x偏移百分比，相对控件宽度
        private float offsetPercentY = 0f;//y偏移百分比，相对控件高度

        public float getPercentX() {
            return percentX;
        }

        public void setPercentX(float percentX) {
            this.percentX = percentX;
        }

        public float getPercentY() {
            return percentY;
        }

        public void setPercentY(float percentY) {
            this.percentY = percentY;
        }

        public float getOffsetX() {
            return offsetX;
        }

        public void setOffsetX(float offsetX) {
            this.offsetX = offsetX;
        }

        public float getOffsetY() {
            return offsetY;
        }

        public void setOffsetY(float offsetY) {
            this.offsetY = offsetY;
        }

        public float getOffsetPercentX() {
            return offsetPercentX;
        }

        public void setOffsetPercentX(float offsetPercentX) {
            this.offsetPercentX = offsetPercentX;
        }

        public float getOffsetPercentY() {
            return offsetPercentY;
        }

        public void setOffsetPercentY(float offsetPercentY) {
            this.offsetPercentY = offsetPercentY;
        }
    }
}
